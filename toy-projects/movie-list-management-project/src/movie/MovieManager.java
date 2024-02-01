package movie;

import dto.MovieDTO;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    List<MovieDTO> movieList = new ArrayList();



    public void addList(MovieDTO movieDTO) {
        movieList.add(movieDTO);
    }

    public List<MovieDTO> selectList() {
        return movieList;
    }

    public boolean updateList(MovieDTO updateMovie) {

        MovieDTO old = null;

        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieId() == updateMovie.getMovieId()) {
                movieList.set(i, updateMovie);
            }
        }
        return old != null;
    }

    public boolean deleteList(int id) {

        MovieDTO old = null;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieId() == id) {
                old = movieList.remove(i);
            }
        }
        return old!= null;
    }

    public List<MovieDTO> searchTitle(String movieTitle) {
        List<MovieDTO> searchList = new ArrayList<>();

        for (MovieDTO movie : movieList) {
            if (movie.getMovieTitle().contains(movieTitle)) {
                searchList.add(movie);
            }
        }
        return searchList;
    }

    public List<MovieDTO> searchDirectors(String movieDirectors) {
        List<MovieDTO> searchList = new ArrayList<>();

        for (MovieDTO movie : movieList) {
            if (movie.getMovieDirectors().contains(movieDirectors)){
                searchList.add(movie);
            }
        }
        return searchList;
    }

}