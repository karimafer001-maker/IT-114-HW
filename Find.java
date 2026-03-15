import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int largest = input.nextInt();
        
        for (int i = 2; i <= 5; i++) {
            System.out.printf("Enter number: ");
            int number = input.nextInt();
            
            if (number > largest) {
                largest = number;
            }
        }
        
        System.out.printf("Largest number is: " + largest);
        
        input.close();
    }
}
