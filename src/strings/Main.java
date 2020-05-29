package strings;

public class Main {
    public String addBinary(String a, String b) {
        int i = a.length();
        int j = b.length();
        int rest = 0;
        int value, aValue, bValue;

        StringBuffer result = new StringBuffer();

        while (--i >= 0 || --j >= 0) {
            aValue = (i < 0) ? 0 : a.charAt(i) - 48;
            bValue = (j < 0) ? 0 : b.charAt(j) - 48;
            value = aValue + bValue + rest;
            result.append(value % 2);
            rest = value / 2;
        }

        if (rest == 1) {
            result.append("1");
        }

        return result.reverse().toString();

    }

    public String multiply(String str1, String str2) {
        if (str1 == "0" || str2 == "0") {
            return "0";
        }

        if (str1.length() == 1 && str1.charAt(0) == '0') {
            return "0";
        }

        if (str2.length() == 1 && str2.charAt(0) == '0') {
            return "0";
        }

        int[][] matrix = new int[str2.length()][];

        int len2 = str2.length();
        int len1 = str1.length();

        for (int i = len2 - 1; i >= 0; i--) {
            int number1 = Character.getNumericValue(str2.charAt(i));
            int rest = 0;

            matrix[len2 - 1 - i] = new int[len1 + 1];

            for (int j = len1 - 1; j >= 0; j--) {
                int number2 = Character.getNumericValue(str1.charAt(j));
                int temp = number1 * number2 + rest;
                rest = temp / 10;
                matrix[len2 - 1 - i][len1 - 1 - j] = temp % 10;
            }

            if (rest > 0) {
                matrix[len2 - 1 - i][len1] = rest;
            }

        }

        int size = matrix.length + matrix[0].length - 1;
        int rows = matrix.length, cols = matrix[0].length;
        int rest = 0;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int temp = 0, index = 0;
            int result = 0;

            for (int j = 0; j < rows; j++) {
                int value = i - index >= 0 && i - index < cols ? matrix[j][i - index] : 0;
                temp += value;
                ++index;
            }

            result = (temp + rest) % 10;
            rest = (temp + rest) / 10;

            // может быть накапливать число дальше???
            if (!(i == size-1 && result == 0))
                output.insert(0, result);
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Main().multiply("9133", "0"));
    }
}
