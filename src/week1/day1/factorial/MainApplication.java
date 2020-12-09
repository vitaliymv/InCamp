package week1.day1.factorial;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        System.out.print("Write integer number: ");
        number = sc.nextInt();

        try {
            int resultFactorial = Factorial.getResult(number);
            System.out.println(number + "!" + " = " + resultFactorial);
        } catch (NumberException e) {
            System.out.println(e.getMessage());
        }

    }

}
