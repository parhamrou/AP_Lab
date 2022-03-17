
public class AUTMath {
    /**
     * gets two integers and returns their sum.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @return int
     */
    public static int sum(int num1, int num2) {
        return num1+num2;
    }

    /**
     * gets two integer and returns their subtraction.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @return int
     */
    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    /**
     * gets two numbers and returns their multiply.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @return int
     */
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    /**
     * gets two numbers and returns their division.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @return double
     */
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    /**
     * gets a number and returns its factorial.
     *
     * @param number the number
     * @return int
     */
    public static int factorial(int number) {
        int result = 1;

        for (int counter = 1; counter <= number; counter++) {
            result = multiply(counter, result);
        }
        return result;
    }

    /**
     * gets a base and a power and calculates base in power of the input.
     *
     * @param base  the base
     * @param power the power
     * @return int
     */
    public static int pow(int base, int power) {
        int result = 1;

        for (int counter = 1; counter <= power; counter++) {
            result = multiply(base, result);
        }

        return result;
    }

    /**
     * gets an index and calculates the fibonacci sequence at that exact index recursively.
     *
     * @param index the index
     * @return int
     */
    public static int fib(int index) {
        if (index == 1 || index == 2) {
            return 1;
        }
        return fib(index-1) + fib(index - 2);
    }
}