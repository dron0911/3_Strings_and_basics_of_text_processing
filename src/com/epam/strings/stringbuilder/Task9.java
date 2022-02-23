package com.epam.strings.stringbuilder;

import java.util.regex.Pattern;

/**
 * 9. Посчитать количество строчных (маленьких) и прописных (больших) букв во введенной строке. Учитывать только английские
 * буквы.
 */
public class Task9 {
    public static void main(String[] args) {
        String str = "Ivan Ivanov";
        System.out.println(countOfSymbols(str));
    }

    private static String countOfSymbols(String str) {
        int countLower = 0;
        int countUpper = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) countLower++;
            if (Character.isUpperCase(str.charAt(i))) countUpper++;
        }
        return String.format("lower count = %d, upper count = %d", countLower, countUpper);
    }
}
