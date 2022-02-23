package com.epam.strings.stringbuilder;

/**
 * 4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */
public class Task4 {
    public static void main(String[] args) {
        String str = "информатика";
        System.out.println(getNewWord(str));
    }

    private static String getNewWord(String str) {
        String str2 = String.valueOf(str.charAt(str.indexOf('т')));
        str2 += String.valueOf(str.charAt(str.indexOf('о')));
        str2 += String.valueOf(str.charAt(str.indexOf('р')));
        str2 += String.valueOf(str.charAt(str.indexOf('т')));
        return str2;
    }
}
