package lec2final;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
//    private int _priceCode;
    private MovieType _type;

    public Movie(String title, MovieType type) {
        _title = title;
        _type = type;
    }

    public MovieType getType() {
        return _type;
    }

    public void setType(MovieType type) {
        _type = type;
    }

    public String getTitle() {
        return _title;
    }

    public double rentalCost(int daysRented) {
        return getType().rentalCost(daysRented);
    }

    int rentalPoints(int daysRented) {
        return getType().rentalPoints(daysRented);
    }
}
