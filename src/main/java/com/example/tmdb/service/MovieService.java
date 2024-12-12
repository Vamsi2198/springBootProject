package com.example.tmdb.service;

import com.example.tmdb.model.Movie;
import com.example.tmdb.repo.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie create(Movie movie){

        if(movie == null){
            throw new RuntimeException("Invalid Movie");
        }
        return movieRepository.save(movie);
    }

    public Movie read(long id){
      return  movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("movie not found"));
    }

    public void update(Long id,Movie update){
        if(update == null || id == null){
            throw new RuntimeException("Invalid Movie");
        }
       if(movieRepository.existsById(id)){
          Movie movie= movieRepository.getReferenceById(id);
          movie.setName(update.getName());
          movie.setDirector(update.getDirector());
          movie.setActors((update.getActors()));
          movieRepository.save(movie);
       }else{
           throw new RuntimeException("movie not found");
       }
    }

    public void delete(long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
        }else{
            throw new RuntimeException("movie not found");
        }
    }
}
