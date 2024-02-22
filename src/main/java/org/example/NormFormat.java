package org.example;

public class NormFormat {
    public static String returnRub(double sum) {
        int value = (int) sum % 100;
        String rub = "";
        if (value >= 10 & value <= 20) {

            rub = "Рублей";
        } else {
            rub = switch (value % 10) {
                case 1 -> "Рубль";
                case 2, 3, 4 -> "Рубля";
                case 5, 6, 7, 8, 9, 0 -> "Рублей";
                default -> rub;
            };
        }
        return String.format("%.2f",sum) + " " + rub;
    }






}
