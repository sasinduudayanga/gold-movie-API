package com.sasindu.movies;

import com.sasindu.exception.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with IMDB ID:" + imdbId));
    }
}
