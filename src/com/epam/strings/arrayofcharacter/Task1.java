package com.epam.strings.arrayofcharacter;

/**
 * 1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */
public class Task1 {
    public static void main(String[] args) {
        String[] camelCase = {"camelCase", "getSomething", "setSomething", "toLowerCase", "toUpperCase" };
        String[] snakeCase = toSnakeCase(camelCase);
        System.out.println(String.join(", ", camelCase));
        System.out.print(String.join(", ", snakeCase));
    }

    private static String[] toSnakeCase(String[] camelCase) {
        String[] snakeCase = new String[camelCase.length];
        for (int i = 0; i < snakeCase.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < camelCase[i].length(); j++) {
                char letter = camelCase[i].toCharArray()[j];
                if (Character.isUpperCase(letter)) {
                    stringBuilder.append("_");
                    stringBuilder.append(Character.toLowerCase(letter));
                } else {
                    stringBuilder.append(letter);
                }
            }
            snakeCase[i] = stringBuilder.toString();
        }
        return snakeCase;
    }
}
