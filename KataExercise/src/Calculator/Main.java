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
                throw new Exception("Строка не является математической операцией");
            }

            // Находим будущий индекс разделителя для массива splitSign
            int splitNumber = -1;
            for (int i = 0; i < sign.length; i++) {
                if (expWithoutSpaces.contains(sign[i])) {
                    splitNumber = i;
                    break;
                }
            }

            // Проверяем оператор выражения
            if (splitNumber == -1) {
                throw new Exception("Не соответствующая арифметическая операция");
            }

            // Делим строку на отдельные операнды при помощи метода split().
            String[] digits = expWithoutSpaces.split(splitSign[splitNumber]);

            // Проверяем согласно условию - a + b, a - b, a * b, a / b.
            // По таким условиям в нашем массиве не может быть более двух операндов.
            if (digits.length > 2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");
            }
            if (roma.containRoma(digits[0]) == roma.containRoma(digits[1])) {

                // Если оба элемента в массиве Римские числа
                // то конвертируем их в методе romanToInt и отправляем в switch
                if (roma.containRoma(digits[0])) {
                    a = roma.romanToInt(digits[0]);
                    b = roma.romanToInt(digits[1]);

                    if (a > 10 && b > 10) {
                        throw new Exception("В римской системе нет отрицательных чисел");
                    }
                } else {
                    // Иначе это цифры, парсим их в Int и передаем в switch
                    // сразу проверяя цифры ли там вообще...
                    try {
                        a = Integer.parseInt(digits[0]);
                        b = Integer.parseInt(digits[1]);
                    } catch (Exception e) {
                        throw new Exception("Калькулятор умеет работать только с целыми числами.");
                    }
                }
                if (a > 10 || b > 10) {
                    throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
                }
                int result = 0;

                // Находим результат
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
                if (roma.containRoma(digits[0])) {
                    System.out.println(roma.intToRoman(result));
                } else {
                    System.out.println(result);
                }


            } else {
                throw new Exception("Используются одновременно разные системы счисления");
            }


        }
    }
}





