package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int a, b;
        RomanDigit roma = new RomanDigit();
        String[] sign = {"-", "*", "+", "/"};
        String[] splitSign = {"-", "\\*", "\\+", "/"};

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Введите выражение - ");
            String exp = input.nextLine();

            String expWithoutSpaces = exp.replaceAll(" ", "");

            if (expWithoutSpaces.length() < 2) {
                throw new Exception("т.к. строка не является математической операцией");
            }
            // Находим будущий индекс разделителя для массива splitSign
            int splitNumber = 0;
            for (int i = 0; i < sign.length; i++) {
                if (expWithoutSpaces.contains(sign[i])) {
                    splitNumber = i;
                    break;
                }
            }
            String[] digits = expWithoutSpaces.split(splitSign[splitNumber]);
            if (digits.length > 2) {
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");
            }


            if (roma.containRoma(digits[0]) != roma.containRoma(digits[1])) {

                throw new Exception("т.к. используются одновременно разные системы счисления");

            } else {

                if (roma.containRoma(digits[0]) && roma.containRoma(digits[1])) {
                    a = roma.romanToInt(digits[0]);
                    b = roma.romanToInt(digits[1]);
                    int result = 0;

                    switch (sign[splitNumber]) {
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "+":
                            result = a + b;
                            break;
                        case "/":
                            result = a / b;
                    }
                    if (result >= 0) {
                        System.out.println(roma.intToRoman(result));
                    } else {
                        throw new Exception("т.к. в римской системе нет отрицательных чисел");
                    }
                } else {


                    a = Integer.parseInt(digits[0].replaceAll(" ", ""));
                    b = Integer.parseInt(digits[1].replaceAll(" ", ""));

                    int result = 0;

                    switch (sign[splitNumber]) {
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "+":
                            result = a + b;
                            break;
                        case "/":
                            result = a / b;
                    }
                    System.out.println(result);


                }
            }


        }
    }


}

