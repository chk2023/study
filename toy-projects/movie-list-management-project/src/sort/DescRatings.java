package sort;

import dto.MovieDTO;

import java.util.Comparator;

public class DescRatings implements Comparator<MovieDTO> {
    @Override
    public int compare(MovieDTO o1, MovieDTO o2) {
        return o2.getMovieRatings().compareTo(o1.getMovieRatings());
    }
}
