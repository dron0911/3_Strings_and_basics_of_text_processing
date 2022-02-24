package com.epam.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
 * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
 * алфавиту.
 */
public class Task1 {
    public static void main(String[] args) {
        String patternParagraph = "\\r\\n";
        String patternSentence = "\\.*[.!?]\\s*";
        String patternWord = "\\s*[\\s;:,]\\s*";

        String myText = "   Unbundling is the division of a complete system into parts, each of which can work autonomously." +
                " For example, Facebook has one single application, but also has Messenger - an application related to" +
                " the main program, but made into a separate product, for more convenient messaging. The term is " +
                "translated from English \"separation\".\r\n" +
                "   Debug / debug - debug - search for errors in the written code and their further correction.\r\n" +
                "   Deploy - deploy - publishing the written and tested code to the server for its further use. It is the" +
                "final stage of development. After placing the code, its program becomes available to all users.\r\n" +
                "   Code review - rechecking the code - is an assessment of the correctness of writing the code and its" +
                "compliance with the task and goals of the company." +
                "In fact, this is to prevent the transition of code to legacy.\r\n";
        String[] paragraphs = myText.split(patternParagraph);
        String[] sentences = myText.split(patternSentence);
        String[] words = myText.split(patternWord);
        sortParagraphs(paragraphs, patternSentence);
        printArray(paragraphs);
    }

    private static int counter(String text, String regex) {
        int counter = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private static void swap(String[] array, int indexOne, int indexTwo) {
        String temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private static void printArray(String[] text) {
        for (String str : text) {
            System.out.println(str);
        }
    }

    private static void sortParagraphs(String[] text, String pattern) {
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < text.length - 1; i++) {
                if (counter(text[i], pattern) < counter(text[i + 1], pattern)) {
                    swap(text, i, i + 1);
                    flag = false;
                }
            }
        }
    }

}
