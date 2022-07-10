package hm1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Numbers {

    public static int failedAttemptCount = 0;
    public static int[] failedAttempts;
    public static int inputNumber;

    public static String name;

    public static boolean findNumber(int allNumbers[], int randomNumber) {

        System.out.println("Please enter new number");

        Scanner num = new Scanner(System.in); // Input your number
        if (num.hasNextInt()) {
            inputNumber = num.nextInt();
        } else {
            System.out.println("Please, enter valid data!");
            return false;
        }


        failedAttemptCount++;
        if (inputNumber == randomNumber) {
            System.out.println("Congratulations, " + name + " !");
            return true;
        } else if (inputNumber > randomNumber) {
            System.out.println("Your number is too big. Please, try again.");
            failedAttempts[failedAttemptCount - 1] = inputNumber;
        } else if (inputNumber < randomNumber) {
            System.out.println("Your number is too small. Please, try again.");
            failedAttempts[failedAttemptCount - 1] = inputNumber;
        }

        return false;

    }

    public static void main(String[] args) {

        System.out.println("Please, enter your name: ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();


        int[] allNumbers = new int[101]; //Array of all numbers in the memory of application


        Random r = new Random();
        int randomNumber = r.nextInt(allNumbers.length); // Randomly select number from app memory
                failedAttempts = new int[allNumbers.length];

        boolean found = findNumber(allNumbers, randomNumber);
        while (!found) {
            found = findNumber(allNumbers, randomNumber);
        }


        int temp = 0;   // Sorting array
        for (int i = 0; i < failedAttempts.length; i++) {
            for (int j = i + 1; j < failedAttempts.length; j++) {
                if (failedAttempts[i] < failedAttempts[j]) {
                    temp = failedAttempts[i];
                    failedAttempts[i] = failedAttempts[j];
                    failedAttempts[j] = temp;
                }
            }
        }
        System.out.println("Your numbers:");  //Printing failed attempts
        for (int failedAttempt : failedAttempts) {
            if (failedAttempt != 0) {
                System.out.print(failedAttempt + "  ");
            }
        }
    }
}
