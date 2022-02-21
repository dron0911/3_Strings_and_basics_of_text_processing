package com.epam.strings.arrayofcharacter;

/**
 * 2. Заменить в строке все вхождения word на letter.
 */
public class Task2 {
    public static void main(String[] args) {
        String str = "word word letter word letter word";
        String changeWord = changeWords(str);
        System.out.println(changeWord);
        System.out.println(str.replace("word", "letter"));
    }

    private static String changeWords(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'w'
                    && str.charAt(i + 1) == 'o'
                    && str.charAt(i + 2) == 'r'
                    && str.charAt(i + 3) == 'd') {
                stringBuilder.append("letter");
                i += 3;
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
