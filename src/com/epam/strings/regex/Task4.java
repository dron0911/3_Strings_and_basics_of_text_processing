package com.epam.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел,
 * записанных по правилам Java, с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task4 {
    public static void main(String[] args) {
        String regex = "0[xX][1-9a-fA-F]+";
        String text = "asdfg 0x32c jfkf sdfdd df 0XF";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
