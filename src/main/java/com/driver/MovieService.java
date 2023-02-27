package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
    public void addMovieDirector(String movie,String director){
          movieRepository.saveMovieDirectorPair(movie,director);
    }
    public Movie getMovieName(String movie){
        return movieRepository.findMovie(movie);
    }
    public Director getDirectorName(String director){
        return movieRepository.findDirector(director);
    }
    public List<String> getMovieDirectorName(String director){
        return movieRepository.findMoviesDirector(director);
    }
    public List<String> getAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
    public void allMovies(){
        movieRepository.deleteAll();
    }
}
