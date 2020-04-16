package arrays;


public class NumberAddition {
    public int[] add(int[] number1, int[] number2) {
        int size1 = number1.length, size2 = number2.length;
        int size = size1 > size2 ? size1 : size2;
        int rest = 0, k = size, value;
        int[] result = new int[size];

        int i = size1, j = size2;

        while (--i >= 0 && --j >= 0) {
            value = number1[i] + number2[j] + rest;
            result[--k] = value % 10;
            rest = value / 10;
        }

        if (size1 > size2) {
            while(--k > 0) {
                value = number1[k] + rest;
                result[k] = value % 10;
                rest = value / 10;
            }
        }

        if (size2 > size1) {
            while(--k > 0) {
                value = number2[k] + rest;
                result[k] = value % 10;
                rest = value / 10;
            }
        }

        if (rest > 0) {
            int[] newResult = new int[size + 1];
            newResult[0] = rest;
            System.arraycopy(result, 0, newResult, 1, size);
            return newResult;
        }

        return result;
    }

    public static void main(String[] args) {
       int[] result = new NumberAddition().add(new int[]{9,9,9,9,9,9,9}, new int[]{1,6,8,2,6,7});
    }
}
