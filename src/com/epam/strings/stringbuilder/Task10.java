package com.epam.strings.stringbuilder;

/**
 * 10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 * знаком. Определить количество предложений в строке X.
 */
public class Task10 {
    public static void main(String[] args) {
        String x = "First sentence. Second sentence! Third  sentence? Fourth sentence.";
        System.out.println(countSentences(x));

    }

    private static int countSentences(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.' ||
                    str.charAt(i) == '?' ||
                    str.charAt(i) == '!') {
                counter++;
            }
        }
        return counter;
    }
}
