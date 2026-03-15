import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Enter a number between 1 and 7: ");
        int day = input.nextInt();
        
        switch (day) {
            case 1:
                System.out.printf("Monday");
                break;
            case 2:
                System.out.printf("Tuesday");
                break;
            case 3:
                System.out.printf("Wednesday");
                break;
            case 4:
                System.out.printf("Thursday");
                break;
            case 5:
                System.out.printf("Friday");
                break;
            case 6:
                System.out.printf("Saturday");
                break;
            case 7:
                System.out.printf("Sunday");
                break;
            default:
                System.out.printf("Invalid number! Please enter between 1 and 7.");
                break;
        }
        
        input.close();
    }
}