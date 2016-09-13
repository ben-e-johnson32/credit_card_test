package com.clara;

import java.util.Scanner;

/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard
{

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        // Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc)
    {
        // If the first digit is not a 4, return false right away.
        if (!cc.startsWith("4"))
        { return false; }

        // Initialize a total counter and create an array of the number's digits as characters.
        int total = 0;
        char[] chars = cc.toCharArray();

        // If it's not 16 digits, return false.
        if (chars.length != 16)
        { return false; }

        // Empty int array for the numeric values.
        int[] ints = new int[chars.length];

        // For each loop with a counter. Loops through characters in the char array and puts their int
        // equivalents into the int array.
        int i = 0;
        for (char c : chars)
        { ints[i] = Character.getNumericValue(c); i++; }

        // A for loop to do the totaling.
        for (int x = 0; x < ints.length; x++)
        {
            // If it's the first number, or every other number thereafter, just add that value to the total.
            if (x % 2 != 0)
            { total += ints[x]; }

            // Otherwise, double the number. If it's one digit, just add that digit. If it's two digits,
            // split it into digits and add each to the total individually.
            else
            {
                if (ints[x] * 2 < 10)
                { total += ints[x] * 2; }

                else
                {
                    int y = ints[x] * 2;
                    String s = Integer.toString(y);
                    char[] digits = s.toCharArray();

                    for (char d : digits)
                    { total += Character.getNumericValue(d); }
                }
            }
        }

        // Return whether or not the total is evenly divisible by 10.
        return total % 10 == 0;
    }
}
