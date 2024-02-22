package org.example;
import static org.example.NormFormat.returnRub;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("На сколько человек необходимо разделить счет?");
        int numPeople = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                numPeople = scanner.nextInt();
                if (numPeople == 1) {
                    System.out.println("На одного человека нет смысла делить счет. Попробуйте еще раз.");
                } else if (numPeople < 1) {
                    System.out.println("Некорректное значение, попробуйте снова.");
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректное значение, нужна цифра.");
                scanner.next();
            }
        }

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> cost = new ArrayList<>();
        double sum = 0;

        while (true) {
            System.out.println("Введите название товара: ");
            String itemName = scanner.next();
            items.add(itemName);
            if (itemName.equalsIgnoreCase("Завершить")) {
                System.out.println("Итого: " + returnRub(sum));

                double perPerson = sum / numPeople;
                System.out.println("Каждый человек должен заплатить: " + returnRub(perPerson));

                System.out.println("Список товаров:");
                for (int i = 0; i < items.size(); i++) {
                    if (i < cost.size()) {
                        System.out.println(items.get(i) + " - " + returnRub(cost.get(i)));
                    }
                }
                scanner.close();
                break;

            }

            System.out.println("Введите стоимость товара. Стоимость должна быть в формате рубли.копейки:  ");
            while (true) {
                if (scanner.hasNextDouble()) {
                    double costItem = scanner.nextDouble();
                    if (costItem <= 0) {
                        System.out.println("Введите число больше нуля: ");
                    } else {
                        sum += costItem;
                        cost.add(costItem);
                        System.out.println("Товар " + itemName + " добавлен в корзину");
                        System.out.println("Общая стоимость: " + returnRub(sum));
                        break;
                    }
                } else {
                    System.out.println("Введите корректное значение (цифры): ");
                    scanner.next();
                }
            }

            System.out.println("Хотите добавить еще один товар? (да/нет):  ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("нет")) {
                System.out.println("Итого: " + returnRub(sum));

                double perPerson = sum / numPeople;
                System.out.println("Каждый человек должен заплатить: " + returnRub(perPerson));

                System.out.println("Список товаров:");
                for (int i = 0; i < items.size(); i++) {
                    if (i < cost.size()) {
                        System.out.println(items.get(i) + " - " + returnRub(cost.get(i)));
                    }
                }
                break;
            }
        }
        scanner.close();
    }
}