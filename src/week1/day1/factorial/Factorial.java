package week1.day1.factorial;

public class Factorial {

    public static int getResult(int number) throws NumberException {
        checkNumber(number);

        return getResultFactorial(number);
    }

    private static void checkNumber(int number) throws NumberException {
        if (number < 1) {
            throw new NumberException("Your number < 1");
        }
    }
    private static int getResultFactorial(int number) {
        int resultFactorial = 1;
        for (int i = 1; i <= number; i++) {
            resultFactorial *= i;
        }
        return resultFactorial;
    }
}
