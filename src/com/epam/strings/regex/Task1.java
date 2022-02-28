package com.epam.strings.regex;

import java.util.Scanner;
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

        String myText = "   Unbundling is the division of a complete system into parts, each of which can work autonomously." +
                " For example, Facebook has one single application, but also has Messenger - an application related to" +
                " the main program, but made into a separate product, for more convenient messaging. The term is " +
                "translated from English \"separation\".\n" +
                "   Debug / debug - debug - search for errors in the written code and their further correction.\n" +
                "   Deploy - deploy - publishing the written and tested code to the server for its further use. It is the" +
                "final stage of development. After placing the code, its program becomes available to all users.\n" +
                "   Code review - rechecking the code - is an assessment of the correctness of writing the code and its" +
                "compliance with the task and goals of the company." +
                "In fact, this is to prevent the transition of code to legacy.\n";

        String patternParagraph = "\\n";
        String patternSentence = "\\.*[.!?]\\s*";
        String patternWord = "\\s*[\\s;:,.\\-/]\\s*";

        String[] paragraphs = myText.split(patternParagraph);
        String[] sentences = myText.split(patternSentence);

        String[] sortOfParagraphs = sortParagraphs(paragraphs, patternSentence);
        String[] sortOfSentences = sortSentences(sentences, patternWord);
        String[] sortOfWords = sortByCountOfLexem(sentences, patternWord);
        menu(sortOfParagraphs, sortOfSentences, sortOfWords);
    }

    private static void menu(String[] sortParagraphs, String[] sortSentences, String[] sortWords) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter (1) for sorting paragraphs by amount of sentences; \n" +
                "Enter (2) for sorting sentences by words length;\n" +
                "Enter (3) for sorting tokens by descending of amount of entered value;\n" +
                "For exit enter (exit).\n");
        String choice = "";
        int n = 0;
        while (!choice.equalsIgnoreCase("exit")) {
            System.out.println("Enter your choice");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    printArray(sortParagraphs);
                    break;
                case "2":
                    printArray(sortSentences);
                    break;
                case "3":
                    printArray(sortWords);
                    break;
                case "exit":
                    break;
                default:
                    if (n < 5) {
                        n++;
                        System.out.println("Incorrect. Please repeat one more time.\n");
                    } else {
                        break;
                    }
            }
        }
    }

    private static String[] sortParagraphs(String[] text, String pattern) {
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
        ;
        return text.clone();
    }

    private static String[] sortSentences(String[] text, String pattern) {
        for (int i = 0; i < text.length; i++) {
            String[] words = text[i].split(pattern);
            boolean flag = false;
            while (!flag) {
                flag = true;
                for (int j = 0; j < words.length - 1; j++) {
                    if (words[j].length() > words[j + 1].length()) {
                        swap(words, j, j + 1);
                        flag = false;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            for (String word : words) {
                str.append(word).append(" ");
            }
            text[i] = str.toString();
        }
        return text.clone();
    }

    private static String[] sortByCountOfLexem(String[] text, String pattern) {
        String regex = "[aA]";
        for (int i = 0; i < text.length; i++) {
            String[] words = text[i].split(pattern);
            boolean flag = false;
            while (!flag) {
                flag = true;
                for (int j = 0; j < words.length - 1; j++) {
                    if (counter(words[j], regex) < counter(words[j + 1], regex)) {
                        swap(words, j, j + 1);
                        flag = false;
                    } else if (counter(words[j], regex) == counter(words[j + 1], regex) && counter(words[j], regex) > 0) {
                        for (int k = 0; k < words[j].length(); k++) {
                            if (words[j].charAt(k) < words[j + 1].charAt(k)) {
                                break;
                            } else if (words[j].charAt(k) > words[j + 1].charAt(k)) {
                                swap(words, j, j + 1);
                                flag = false;
                                break;
                            } else if (words[j].charAt(k) == words[j + 1].charAt(k)) {
                                continue;
                            }
                        }
                    }
                }

            }
            StringBuilder str = new StringBuilder();
            for (String word : words) {
                str.append(word).append(" ");
            }
            text[i] = str.toString();
        }
        return text.clone();
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
}
