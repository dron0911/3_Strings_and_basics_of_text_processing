package com.epam.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Написать программу, проверяющую, является ли введённая строка адресом почтового ящика.
 * В названии почтового ящика разрешить использование только букв, цифр и нижних подчеркиваний, при этом оно должно начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 * */
public class Task3 {
    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w+@\\w{3,}\\.(com|org|ru)";
        String mail = "lalalal18@mail.org";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        System.out.println(matcher.matches());

    }
}
