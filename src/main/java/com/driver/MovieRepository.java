package com.driver;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie>movieMap;

    public HashMap<String, Movie> getMovieMap() {
        return movieMap;
    }

    public void setMovieMap(HashMap<String, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public HashMap<String, Director> getDirectorMap() {
        return directorMap;
    }

    public void setDirectorMap(HashMap<String, Director> directorMap) {
        this.directorMap = directorMap;
    }

    public HashMap<String,List<String>> getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(HashMap<String, List<String>> movieDirector) {
        this.movieDirector = movieDirector;
    }

    private HashMap<String,Director>directorMap;
    private HashMap<String,List<String>>movieDirector;

    public MovieRepository() {
        this.movieMap = new HashMap<String,Movie>();
        this.directorMap = new HashMap<String,Director>();
        this.movieDirector =new HashMap<String,List<String>>();
    }
    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }
    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }
    public void saveMovieDirectorPair(String movie,String director){
            if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){
                List<String>movieList=new ArrayList<String>();
                if(movieDirector.containsKey(director)){
                    movieList=movieDirector.get(director);
                }else{
                    movieList.add(movie);
                    movieDirector.put(director,movieList);
                }
            }
    }
    public Movie findMovie(String movie){
           return movieMap.get(movie);
    }
    public Director findDirector(String director){
        return directorMap.get(director);
    }
    public List<String> findMoviesDirector(String director){
        List<String>movielist=new ArrayList<String>();
        if(movieDirector.containsKey(director)){
            movielist=movieDirector.get(director);
        }
        return movielist;
    }
    public List<String> findAllMovies(){
        List<String>movielist=new ArrayList<String>();
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director){
       List<String>movies=new ArrayList<String>();
       if(movieDirector.containsKey(director)){
           movies=movieDirector.get(director);
           for(String movie:movies){
               if(movieMap.containsKey(movie)) {
                   movieMap.remove(movie);
               }
           }
           movieDirector.remove(director);
       }
       if(directorMap.containsKey(director)){
           directorMap.remove(director);
       }

    }
    public void deleteAll(){
        HashSet<String>rem=new HashSet<String>();
        for(String director:movieDirector.keySet()){
            for(String movie:movieDirector.get(director)){
                rem.add(movie);
            }
        }
        for(String movie:rem){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }

}
