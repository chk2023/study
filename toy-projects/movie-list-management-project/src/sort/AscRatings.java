package sort;

import dto.MovieDTO;

import java.util.Comparator;

public class AscRatings implements Comparator<MovieDTO> {
    @Override
    public int compare(MovieDTO o1, MovieDTO o2) {
        return o1.getMovieRatings().compareTo(o2.getMovieRatings());
    }
}
