package com.epam.strings.arrayofcharacter;

/**
 * 4. В строке найти количество чисел.
 */
public class Task4 {
    public static void main(String[] args) {
        String string = "age: 22  dayOfBirth: 14 monthOfBirth: 11 yearOfBirth: 1999";
        System.out.println("There are " + countDigits(string) + " numbers in this line.");
    }

    public static int countDigits(String string) {
        String[] str = string.split(" ");
        int count = 0;
        for (String s : str) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                count++;
            }
        }
        return str.length - count;
    }
}
