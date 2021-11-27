import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            String[] readedS = s.split(" ");
            if (readedS.length != 3) {
                throw new IllegalArgumentException("Invalid input data");
            }
            String number1 = readedS[0];
            String operation = readedS[1];
            String number2 = readedS[2];
            int parsedNumber1 = 0;
            int parsedNumber2 = 0;
            int flag = 0;
            try {
                parsedNumber1 = Integer.parseInt(number1);
            } catch (NumberFormatException e) {
                flag++;
            }
            try {
                parsedNumber2 = Integer.parseInt(number2);
            } catch (NumberFormatException e) {
                flag++;
            }
            switch (flag) {
                case(0) ->System.out.println(operations(parsedNumber1, operation, parsedNumber2));
                case (1) ->throw new IllegalArgumentException("different numeric systems used");
                case (2) ->System.out.println(ConverterUtil.arabicToRoman(operations(ConverterUtil.romanToArabic(number1), operation, ConverterUtil.romanToArabic(number2))));
            }
        }
    }

    public static int operations(int number1, String operation, int number2) {
        int result;
        if (number1 <= 0 || number2 <= 0) {
            throw new IllegalArgumentException("less or equal zero");
        }
        switch (operation) {
            case ("+") -> result = number1 + number2;
            case ("-") -> result = number1 - number2;
            case ("*") -> result = number1 * number2;
            case ("/") -> result = number1 / number2;
            default -> throw new IllegalArgumentException("unsupported operation");
        }
        return result;
    }
}
