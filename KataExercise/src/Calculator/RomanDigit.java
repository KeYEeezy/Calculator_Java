package Calculator;

import java.util.HashMap;
import java.util.Map;

public class RomanDigit {
    Map<Character, Integer> romanDigit = new HashMap<>();
    Map<Integer, Character> arabDigits = new HashMap<>();

    {
        romanDigit.put('I', 1);
        romanDigit.put('V', 5);
        romanDigit.put('X', 10);
    }

    {
        arabDigits.put(1, 'I');
        arabDigits.put(5, 'V');
        arabDigits.put(10, 'X');
    }

    public boolean containRoma(String roman) {
        return romanDigit.containsKey(roman.charAt(0));
    }

    public int romanToInt(String s) {
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

    }

    public String intToRoman(int a) {
        int[] values = {1, 4, 5, 9, 10};
        String[] roman = {"I", "IV", "V", "IX", "X"};
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
