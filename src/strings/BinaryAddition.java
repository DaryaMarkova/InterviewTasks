package strings;

public class BinaryAddition {
    public String addBinary(String a, String b) {
        int i = a.length();
        int j = b.length();
        int rest = 0;
        int value, aValue, bValue;

        StringBuffer result = new StringBuffer();

        while (--i >= 0 || --j >= 0) {
//
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

    public static void main(String[] args) {
        BinaryAddition addition = new BinaryAddition();
        System.out.println(addition.addBinary( "1", "1"));
    }
}
