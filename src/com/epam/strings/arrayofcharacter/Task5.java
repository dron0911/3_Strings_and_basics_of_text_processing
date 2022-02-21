package com.epam.strings.arrayofcharacter;

/**
 * 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */
public class Task5 {
    public static void main(String[] args) {
        String myLine = "  Be   or not to  be - that is  the   question. ";
        System.out.println(myLine);
        System.out.println(removeExtraSpaces(myLine));
        System.out.println(myLine.replaceAll("( )+", " ").trim());
    }

    private static String removeExtraSpaces(String myLine) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = myLine.trim();
        boolean isSpace = false;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                if (!isSpace) {
                    stringBuilder.append(" ");
                }
                isSpace = true;
            } else {
                stringBuilder.append(line.charAt(i));
                isSpace = false;
            }
        }
        return stringBuilder.toString();
    }
}
