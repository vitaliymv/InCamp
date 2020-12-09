package week1.day1.factorial;

public class Factorial {

    public static int getResultFactorial(int number) throws NumberException {
        int resultFactorial = 1;

        if(number < 1 ) {
            throw new NumberException("Your number < 1");
        }

        for (int i = 1; i <= number; i++) {
            resultFactorial *= i;
        }

        return resultFactorial;
    }

}
