import java.util.Scanner;

public class NumberAnalyzer {

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getFactorial(int num) {
        if (num <= 0) return 1;
        
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        num = Math.abs(num);   
        
        while (num > 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }
        return sum;
    }

    public static int reverseNumber(int num) {
        int reversed = 0;
        int original = num;
        num = Math.abs(num);   
        
        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num = num / 10;
        }
        
        return (original < 0) ? -reversed : reversed;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        System.out.print("Is Even: " + isEven(number));
        System.out.print("Is Prime: " + isPrime(number));
        System.out.print("Factorial: " + getFactorial(number));
        System.out.print("Sum of Digits: " + sumOfDigits(number));
        System.out.print("Reversed Number: " + reverseNumber(number));
        
        input.close();
    }
}