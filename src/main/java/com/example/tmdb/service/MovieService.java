package com.example.tmdb.service;

import com.example.tmdb.exception.InvalidDataException;
import com.example.tmdb.exception.NotFoundException;
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
            throw new InvalidDataException("Invalid Movie: null");
        }
        return movieRepository.save(movie);
    }

    public Movie read(long id){
      return  movieRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("movie not found with id: "));
    }

    public void update(Long id,Movie update){
        if(update == null || id == null){
            throw new InvalidDataException("Invalid Movie : null");
        }
       if(movieRepository.existsById(id)){
          Movie movie= movieRepository.getReferenceById(id);
          movie.setName(update.getName());
          movie.setDirector(update.getDirector());
          movie.setActors((update.getActors()));
          movieRepository.save(movie);
       }else{
           throw new NotFoundException("movie not found with id: ");
       }
    }

    public void delete(long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
        }else{
            throw new NotFoundException("movie not found with id: ");
        }
    }
}
