package com.epam.strings.stringbuilder;

/**
 * 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 * def", то должно быть выведено "abcdef".
 */
public class Task7 {
    public static void main(String[] args) {
        String str = " aa bf sffd ade ";
        System.out.println("without spaces: " + deleteSpaces(str));
    }

    private static String deleteSpaces(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag;
        for (int i = 0; i < str.length() - 1; i++) {
            flag = true;
            if (str.charAt(i) == ' ') {
                continue;
            }
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
