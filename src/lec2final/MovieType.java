package lec2final;

public interface MovieType {
    MovieType REGULAR = new Regular();
    MovieType CHILDRENS = new Childrens();
    MovieType NEW_RELEASE = new NewRelease();

    int rentalPoints(int daysRented);

    double rentalCost(int daysRented);

    static class Regular implements MovieType {
        @Override
        public int rentalPoints(int daysRented) {
            return 1;
        }

        @Override
        public double rentalCost(int daysRented) {
            double result = 2;
            if (daysRented > 2) {
                result += (daysRented - 2) * 1.5;
            }
            return result;
        }
    }

    static class Childrens implements MovieType {
        @Override
        public int rentalPoints(int daysRented) {
            return 1;
        }

        @Override
        public double rentalCost(int daysRented) {
            double result = 1.5;
            if (daysRented > 3) {
                result += (daysRented - 3) * 1.5;
            }
            return result;
        }
    }

    static class NewRelease implements MovieType {
        @Override
        public int rentalPoints(int daysRented) {
            return daysRented < 2 ? 1 : 2;
        }

        @Override
        public double rentalCost(int daysRented) {
            return daysRented*3;
        }
    }
}
