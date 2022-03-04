package com.epam.strings.regex;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов абзацев,
 * в т.ч. тех, у которых есть параметры, например <p id ="p1">,
 * и замену их на простые теги абзацев <p>.
 */
public class Task5 {
    public static void main(String[] args) {
        String text = "<p id =\"p1\">fgd</p> fefg <p id =\"p2\"> fds </p>";
        System.out.println(text.replaceAll("(<p .+?>)(.+?</p>)", "<p>$2"));
    }
}
