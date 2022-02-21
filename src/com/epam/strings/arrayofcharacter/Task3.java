package com.epam.strings.arrayofcharacter;

/**
 * 3. В строке найти количество цифр
 */
public class Task3 {
    public static void main(String[] args) {
        String string = "age: 22  dayOfBirth: 14 monthOfBirth: 11 yearOfBirth: 1999";
        System.out.println("There are " + countDigits(string) + " digits in this line.");
    }

    public static int countDigits(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
