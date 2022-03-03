package com.epam.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дана строка, содержащая следующий текст (xml-документ):
 * <notes>
 * <note id = "1">
 * <to>Вася</to>
 * <from>Света</from>
 * <heading>Напоминание</heading>
 * <body>Позвони мне завтра!</body>
 * </note>
 * <note id = "2">
 * <to>Петя</to>
 * <from>Маша</from>
 * <heading>Важное напоминание</heading>
 * <body/>
 * </note>
 * </notes>
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов
 * xml-документа и его тип (открывающий тег, закрывающий тег, содержимое тега,
 * тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */
public class Task2 {
    public static void main(String[] args) {
        String xml = "<notes>\n" +
                "    <note id = \"1\">\n" +
                "        <to>Вася</to>\n" +
                "        <from>Света</from>\n" +
                "        <heading>Напоминание</heading>\n" +
                "        <body>Позвони мне завтра!</body>\n" +
                "    </note>\n" +
                "    <note id = \"2\">\n" +
                "        <to>Петя</to>\n" +
                "        <from>Маша</from>\n" +
                "        <heading>Важное напоминание</heading>\n" +
                "        <body/>\n" +
                "    </note>\n" +
                " </notes> \n";
        String xmlAnalysis = xmlAnalyzer(xml);
        System.out.println(xmlAnalysis);
    }

    private static String xmlAnalyzer(String xml) {
        String[] lines = xml.split("\n");
        StringBuilder strBuilder = new StringBuilder();
        Pattern pOpen = Pattern.compile("<([^/].+?>)");
        Pattern pClose = Pattern.compile("(</.+?>)");
        Pattern pBody = Pattern.compile("(<[^/].+?>)(.+?)(</.+?>)");
        Pattern pWithoutBody = Pattern.compile("<(.+?/)>");

        Matcher mOpen = pOpen.matcher(xml);
        Matcher mClose = pClose.matcher(xml);
        Matcher mBody = pBody.matcher(xml);
        Matcher mWithoutBody = pWithoutBody.matcher(xml);

        for (int i = 0; i < lines.length * 3; i++) {
            if (mBody.find()) {
                strBuilder.append(mBody.group(2));
                strBuilder.append(" - body of tag\n");
            } else if (mOpen.find()) {
                strBuilder.append(mOpen.group());
                strBuilder.append(" - open tag\n");
            } else if (mClose.find()) {
                strBuilder.append(mClose.group());
                strBuilder.append(" - closed tag\n");
            } else if (mWithoutBody.find()) {
                strBuilder.append(mWithoutBody.group());
                strBuilder.append(" - tag without body\n");
            }
        }
        return strBuilder.toString();
    }
}
