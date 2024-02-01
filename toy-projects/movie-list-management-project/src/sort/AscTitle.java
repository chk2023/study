package sort;

import dto.MovieDTO;

import java.util.Comparator;

public class AscTitle implements Comparator<MovieDTO> {
    @Override
    public int compare(MovieDTO o1, MovieDTO o2) {
        return o1.getMovieTitle().compareTo(o2.getMovieTitle());
    }
}
