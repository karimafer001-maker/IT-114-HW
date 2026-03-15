import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int secret = 7;
        int guess;
        
        System.out.println("Guess the number:");
        
        do {
            guess = input.nextInt();
            
            if (guess < secret) {
                System.out.printf("Too low");
                System.out.printf("Guess the number:");
            }
            else if (guess > secret) {
                System.out.printf("Too high");
                System.out.printf("Guess the number:");
            }
        } while (guess != secret);
        
        System.out.println("Correct!");
    }
}