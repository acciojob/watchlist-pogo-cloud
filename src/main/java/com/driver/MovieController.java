package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>  addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.addMovieDirector(movie,director);
        return new ResponseEntity<>("director movie Pair added Successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie=movieService.getMovieName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
   @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>  getDirectorByName(@PathVariable String name){
        Director director=movieService.getDirectorName(name);
       return new ResponseEntity<>(director,HttpStatus.CREATED);
   }
   @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
       List<String>movie=movieService.getMovieDirectorName(name);
       return new ResponseEntity<>(movie,HttpStatus.CREATED);
   }
   @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>  findAllMovies(){
        List<String>movie=movieService.getAllMovies();
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
   }
   @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(String name){
        movieService.deleteDirector(name);
        return new ResponseEntity<>("deleted successfully",HttpStatus.GONE);
   }
   @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>  deleteAllDirectors(){
        movieService.allMovies();
        return new ResponseEntity<>("deleted successfully",HttpStatus.GONE);
   }
}
