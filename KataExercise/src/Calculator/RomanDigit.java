package Calculator;

import java.util.HashMap;
import java.util.Map;

public class RomanDigit {
    Map<Character, Integer> romanDigit = new HashMap<>();


    {
        romanDigit.put('I', 1);
        romanDigit.put('V', 5);
        romanDigit.put('X', 10);
    }


    public boolean containRoma(String roman) {
        return romanDigit.containsKey(roman.charAt(0));
    }

    public int romanToInt(String s) throws Exception {
        if (romanDigit.containsKey(s.charAt(0))) {
            int result = 0;
            int prev = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int curr = romanDigit.get(s.charAt(i));
                if (prev > curr) {
                    result -= curr;
                } else {
                    result += curr;
                }
                prev = curr;


            }
            return result;

        } else {
            throw new Exception("Несуществующие значения");
        }
    }

    public String intToRoman(int a) throws Exception {
        if (a < 0) {
            throw new Exception("В римской системе нет отрицательных чисел");
        } else {
            int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            StringBuilder result = new StringBuilder();
            for (int i = values.length - 1; i >= 0 && a > 0; i--) {
                while (a >= values[i]) {
                    a -= values[i];
                    result.append(roman[i]);
                }

            }
            return result.toString();

        }
    }
}


