public class Movie {

    private String title;
    private int[] ratings;
    private int ratingCount;

    public Movie(String title) {
        this.title = title;
        this.ratings = new int[10];   // fixed capacity of 10
        this.ratingCount = 0;
    }

    public void addRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating! Rating must be between 1 and 5.");
            return;
        }
        
        if (ratingCount >= 10) {
            System.out.println("Cannot add more ratings. The list is full.");
            return;
        }
        
        ratings[ratingCount] = rating;
        ratingCount++;
        System.out.println("Added rating: " + rating);
    }

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int i = 0; i < ratingCount; i++) {
            sum += ratings[i];
        }
        
        return (double) sum / ratingCount;
    }

    public int getHighestRating() {
        if (ratingCount == 0) {
            return 0;
        }
        
        int highest = ratings[0];
        for (int i = 1; i < ratingCount; i++) {
            if (ratings[i] > highest) {
                highest = ratings[i];
            }
        }
        return highest;
    }

    @Override
    public String toString() {
        return "'" + title + "' - " + ratingCount + " ratings";
    }

    public static void main(String[] args) {
        
        Movie movie1 = new Movie("Nice Guy");
        Movie movie2 = new Movie("Cool Guy");

        System.out.println("Created Movies:");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println();

        System.out.println("Adding ratings to 'Nice Guy':");
        movie1.addRating(5);
        movie1.addRating(4);
        movie1.addRating(3);
        movie1.addRating(5);
        movie1.addRating(0);        
        movie1.addRating(6);        

        System.out.println("\nAdding ratings to 'Cool Guy':");
        movie2.addRating(4);
        movie2.addRating(5);
        movie2.addRating(2);
        movie2.addRating(5);

        System.out.print("\nResults:");
        System.out.print(movie1);
        System.out.print("Average Rating: " + movie1.getAverageRating());
        System.out.print("Highest Rating: " + movie1.getHighestRating());

        System.out.print("\n" + movie2);
        System.out.print("Average Rating: " + movie2.getAverageRating());
        System.out.print("Highest Rating: " + movie2.getHighestRating());
    }
}