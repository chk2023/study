package dto;

public class MovieDTO {
    private static int increase = 1;
    private int movieId;
    private String movieTitle;
    private String movieDirectors;
    private String movieRatings;

    public MovieDTO(String movieTitle, String movieDirectors, String movieRatings) {
        this.movieId = MovieDTO.increase++;
        this.movieTitle = movieTitle;
        this.movieDirectors = movieDirectors;
        this.movieRatings = movieRatings;
    }

    public MovieDTO(int movieId, String movieTitle, String movieDirectors, String movieRatings) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieDirectors = movieDirectors;
        this.movieRatings = movieRatings;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDirectors() {
        return movieDirectors;
    }

    public void setMovieDirectors(String movieDirectors) {
        this.movieDirectors = movieDirectors;
    }

    public String getMovieRatings() {
        return movieRatings;
    }

    public void setMovieRatings(String movieRatings) {
        this.movieRatings = movieRatings;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieDirectors='" + movieDirectors + '\'' +
                ", movieRatings='" + movieRatings + '\'' +
                '}';
    }
}
