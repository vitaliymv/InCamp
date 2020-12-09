package week1.day1.sum;

public class SumInRange {

    public static int getSum(int number1, int number2) {
        int result = 0;

        if(number1 < number2) {
            for (int i = number1; i <= number2; i++) {
                result += i;
            }
        } else if (number1 > number2) {
            for (int i = number2; i <= number1; i++) {
                result += i;
            }
        }

        return result;
    }

}
