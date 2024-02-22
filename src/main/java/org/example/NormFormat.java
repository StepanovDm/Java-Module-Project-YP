package org.example;
public class NormFormat {
    public static String returnRub(double sum) {
        int value = (int) sum % 100;
        String rub = "";
        if (value >= 10 & value <= 20) {

            rub = "Рублей";

        } else {
            switch (value % 10) {
                case 1:
                    rub = "Рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rub = "Рубля";
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                    rub = "Рублей";
            }
        }
        return String.format("%.2f",sum) + " " + rub;
    }
}
