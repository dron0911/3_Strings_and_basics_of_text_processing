package com.epam.strings.stringbuilder;

/**
 * 5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */
public class Task5 {
    public static void main(String[] args) {
        String str = "aabbabaa";
        System.out.println("count of a in string " + countOfA(str));
    }

    private static int countOfA(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }
}
