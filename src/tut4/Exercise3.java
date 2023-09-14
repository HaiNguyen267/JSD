package tut4;

import java.util.Scanner;

public class Exercise3 {

    private static long startNum;
    private static long endNum;
    private static long maxDivisorCount;
    private static long numberWithMaxDivisors;

    public static void main(String[] args) {

        askUserInput();

        long startTime = System.currentTimeMillis();
        processing();
        long endTime = System.currentTimeMillis();

        printResult(startTime, endTime);
    }



    private static void askUserInput() {
        // ask user to enter 2 numbers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the start number: ");
        startNum = Long.parseLong(scanner.nextLine());
        System.out.println("Enter the end number: ");
        endNum = Long.parseLong(scanner.nextLine());
    }

    private static void processing() {
        // loop from START to END to find the number with largest number of divisors and the number of divisors it has
        for (long i = startNum; i <= endNum; i++) {
            long divisorCount = countNumberOfDivisor(i);
            if (divisorCount > maxDivisorCount) {
                maxDivisorCount = divisorCount;
                numberWithMaxDivisors = i;
            }
        }
    }

    private static long countNumberOfDivisor(long num) {
        long count = 0;
        // loop from 1 to the square root of a number to count the number of divisors it has
        for (long i = 1; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) {
                count ++;
            }
        }

        return count;
    }

    private static void printResult(long startTime, long endTime) {
        // print out the result of the program
        System.out.println(String.format("Number from %d to %d with largest number of divisors: %d", startNum, endNum, numberWithMaxDivisors));
        System.out.println(String.format("It has %d divisors", maxDivisorCount));

        double executionTime = ((double)endTime - startTime);
        String timeUnit = "milliseconds(s)";


        // if the execution time is more than a second, print it as second
        if (executionTime > 1000) {
            executionTime /= 1000;
            timeUnit = "second(s)";
        }
        System.out.println(String.format("The program takes %.1f %s to run", executionTime, timeUnit));

    }
}
