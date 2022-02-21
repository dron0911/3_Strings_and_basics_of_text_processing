package com.epam.strings.stringbuilder;

/**
 * 1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */
public class Task1 {
    public static void main(String[] args) {
        String spaces = "three   four    five     end.";
        int maxCount = maxSpaces(spaces);
        System.out.println("max count of spaces is " + maxCount);
    }

    private static int maxSpaces(String spaces) {
        int maxCount = 0;
        int count;
        for (int i = 0; i < spaces.length(); i++) {
            count = 0;
            while (spaces.charAt(i) == ' ') {
                count++;
                i++;
            }
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
