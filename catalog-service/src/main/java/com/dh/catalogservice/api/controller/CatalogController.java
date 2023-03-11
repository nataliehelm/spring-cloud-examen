package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMovieClient;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final IMovieClient iMovieClient;

    public CatalogController(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
      return ResponseEntity.ok().body(iMovieClient.findByGenre(genre));
    }

}
