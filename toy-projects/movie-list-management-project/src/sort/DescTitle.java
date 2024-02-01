package sort;

import dto.MovieDTO;

import java.util.Comparator;

public class DescTitle implements Comparator<MovieDTO> {
    @Override
    public int compare(MovieDTO o1, MovieDTO o2) {
        return o2.getMovieTitle().compareTo(o1.getMovieTitle());
    }
}
