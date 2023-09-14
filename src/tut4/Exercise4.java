package tut4;

import java.util.Scanner;

public class Exercise4 {

    // 3 options to solve this exercise
    // option 1: using volatile variable,  private static volatile long maxDivisorCount;  private static volatile long numberWithMaxDivisors;
    // option 2: using synchronize method for updating the result
    // option 3: using AtomicInteger (similar to option1)
    private static long startNum;
    private static long endNum;

    private static int numberOfThreads;

    private static long maxDivisorCount;
    private static long numberWithMaxDivisors;


    public static void main(String[] args) throws InterruptedException {
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
        System.out.println("Enter the number of threads used to solve the problem: ");
        numberOfThreads = Integer.parseInt(scanner.nextLine());
    }

    private static void processing() throws InterruptedException {
        // get the number of current active thread in program
        int currentThreadNum = Thread.activeCount();
        long from = startNum;
        long totalNumber = endNum - startNum + 1;
        long step = (totalNumber) / numberOfThreads - 1; // minus 1 because the for loop will use >=

        // calculate "to" for the first thread
        long to = from + step + (totalNumber % numberOfThreads);

        // for example
        // numbers from 1 - 11
        // using 3 threads
        // thread 1: 1 2 3 4 5 (because 11 % 3 = 2, so thread 1 will take extra 2 more numbers)
        // thread 2: 6 7 8
        // thread 3: 9 10 11
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            if (i > 0) {
                to = from + step;
            }
            System.out.println(String.format("Thread #%d: from %d to %d", i + 1, from, to));
            threads[i] = new MyThread(from, to);
            threads[i].start();
            from = to + 1;

        }

        // make all custom threads join with main method,
        // the main method will stop execution at here until all custom threads stop
       for (Thread thread : threads) {
           thread.join();
       }

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

    public static synchronized void updateResult(long num, long divisorCount) {
        // there can be only one thread can call this method at a time
        if (divisorCount > maxDivisorCount) {
            maxDivisorCount = divisorCount;
            numberWithMaxDivisors = num;
        }
    }
}


class MyThread extends Thread {

    private long from;
    private long to;

    public MyThread(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (long i = from; i <= to ; i++) {
            long divisorCount = countNumberOfDivisor(i);
            Exercise4.updateResult(i, divisorCount);
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

}