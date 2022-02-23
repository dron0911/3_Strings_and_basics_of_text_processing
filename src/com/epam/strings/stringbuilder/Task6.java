package com.epam.strings.stringbuilder;

/**
 * 6. Из заданной строки получить новую, повторив каждый символ дважды.
 */
public class Task6 {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println("repeat: " + repeatEverySymbol(str));
    }

    private static String repeatEverySymbol(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i)).append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
