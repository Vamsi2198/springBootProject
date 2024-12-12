package com.example.tmdb.api;

import com.example.tmdb.model.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerIntTest {

        @Autowired
    ObjectMapper objectMapper;        
     MockMvc mockMvc;
        
        @Test
    void givenMovie_whenCreateMovie_thenReturnSaveMovie() throws Exception {
            Movie movie = new Movie();
            movie.setName("rrr");
            movie.setDirector("ss rajamouli");
            movie.setActors(List.of("NTR","Ram","ALia"));

//            mockMvc.perform(post("/movies")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValue))
        }
}