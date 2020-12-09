package week1.day1.sum;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1;
        int number2;
        System.out.print("Write 2 numbers: ");
        number1 = scanner.nextInt();
        number2 = scanner.nextInt();

        int result = SumInRange.getSum(number1, number2);
        System.out.println("Sum in range: " + result);
    }

}
