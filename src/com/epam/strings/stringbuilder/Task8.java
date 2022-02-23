package com.epam.strings.stringbuilder;

/**
 * 8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 * длинных слов может быть несколько, не обрабатывать.
 */
public class Task8 {
    public static void main(String[] args) {
        String str = "A string of words is entered, separated by spaces";
        System.out.println("The longest word in a string is: " + longestWordInString(str));
    }

    private static String longestWordInString(String str) {
        String string2 = "";
        for (String string : str.split(" ")) {
            string2 = string.length() > string2.length() ? string : string2;
        }
        return string2;
    }
}
