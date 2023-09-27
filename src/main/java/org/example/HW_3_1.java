package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HW_3_1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные в следующем порядке через пробел: Фамилия Имя Отчество дата рождения номер телефона пол");
            String input = scanner.nextLine();
            scanner.close();

            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthdate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            // Проверка формата данных
            if (!birthdate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверный пол");
            }

            StringBuilder output = new StringBuilder();
            output.append(surname).append(name).append(patronymic).append(birthdate).append(" ").append(phoneNumber).append(gender);

            String fileName = surname + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(output.toString());
                writer.newLine();
            }

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
