package com.epam.strings.stringbuilder;

/**
 * 2. В строке вставить после каждого символа 'a' символ 'b'
 */
public class Task2 {
    public static void main(String[] args) {
        String line = "ababab";
        String changedLine = replacement(line);
        System.out.println(changedLine);
    }

    private static String replacement(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a') {
                stringBuilder.append('b');
            } else {
                stringBuilder.append(line.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
