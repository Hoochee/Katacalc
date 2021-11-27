import java.util.List;

public class ConverterUtil {
    public static int romanToArabic(String s) {
        String romanNumber = s.toUpperCase();
        int result = 0;
        List<RomanicNumbers> romanNumbers = RomanicNumbers.getReverseSortedValues();
        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size())) {
            RomanicNumbers symbol = romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException(s + " cannot be converted to a Roman Numeral");
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
        List<RomanicNumbers> arabicNumbers = RomanicNumbers.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((number > 0) && (i < arabicNumbers.size())) {
            RomanicNumbers symbol = arabicNumbers.get(i);
            if (symbol.getValue() <= number) {
                sb.append(symbol.name());
                number -= symbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
