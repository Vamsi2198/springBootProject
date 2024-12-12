package com.example.tmdb.api;

import com.example.tmdb.model.Movie;
import com.example.tmdb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
       Movie movie = movieService.read(id);
        System.out.println("movie read ");
       return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createdMovie = movieService.create(movie);
       System.out.println("movie created ");
        return ResponseEntity.ok(createdMovie);
    }


    @PutMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.delete(id);
    }

}
