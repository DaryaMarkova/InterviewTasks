import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public static void main(String[] args) {
        List<String> output = new Main().letterCombinations("2");
        output.forEach(item -> System.out.println(item));
    }

    public  List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList<>();

        if (digits.length() == 0)
            return output;

        output.add("");
        String[] charMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (output.peek().length() == i) {
                String permutation = output.remove();

                for(char c: charMap[index].toCharArray()) {
                    output.add(permutation + c);
                }
            }
        }

        return output;
    }

    int threeSumClosest(int[] array, int targetSum) {
       int closestSum = array[0] + array[1] + array[2];
       Arrays.sort(array);

       for (int i = 0; i < array.length - 2; i++) {
           int pairSumTarget = targetSum - array[i];
           int left = i + 1, right = array.length - 1;

           while (left < right) {
               int currentSum = array[left] + array[right];

               if (Math.abs(targetSum - (currentSum + array[i])) < Math.abs(targetSum - closestSum)) {
                   closestSum = currentSum + array[i];
               }

               if (currentSum == pairSumTarget) {
                   closestSum = targetSum;
                   break;
               } else if (currentSum < pairSumTarget) {
                   left++;
               } else {
                   right--;
               }
           }
       }

       return closestSum;
    }

    String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                output.append(strings[i]);
            }
        }

        return output.toString();
    }

    int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int unique = nums[0];

        for(int i = 1; i < nums.length; i++) {
            unique ^= nums[i];
        }

        return unique;
    }

    boolean isAlphaNumeric(char ch) {
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }

    public boolean isPalindrome(String s) {

        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();

        for (int i = 0, k = s.length() - 1;  i < s.length() / 2; i++, k--) {

            while (i < s.length() - 1 && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }

            while (k > 0 && !isAlphaNumeric(s.charAt(k))) {
                k--;
            }

            char a = s.charAt(i);
            char b = s.charAt(k);

            if (isAlphaNumeric(a) && isAlphaNumeric(b) &&  a != b) {
                return false;
            }
        }

        return true;
    }

    public String convertToTitle(int n) {
        String alphabet = "ZABCDEFGHIJKLMNOPQRSTUVWXYZ";    // На нулевом месте - Z, так как если мы получили нулевой остаток от деления ненулевого N на 26, то число N кратно 26 и в этом случае мы должны добавить символ Z.
        StringBuilder title = new StringBuilder();

        int base = 26;

        while (n > 0) {
            title.insert(0, alphabet.charAt(n % base)); // Старшие разряды записываем в начало
            n = (n - 1) / base; // Единица вычитается на случай, если N кратно 26, т.к. иначе в таком случае новое N будет на единицу больше, чем нужно. Для остальных ненулевых N это вычитание единицы не вредит.
        }

        return title.toString();
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                indexes[0] = map.get(numbers[i]) + 1;
                indexes[1] = i + 1;
                break;
            }

            map.put(target - numbers[i], i);
        }

        return indexes;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int rest) {
        int value1 = l1 == null ? 0 : l1.val;
        int value2 = l2 == null ? 0 : l2.val;
        int result = rest + value1 + value2;

        ListNode output = new ListNode(result % 10);

        ListNode l1Next = l1 == null ? null : l1.next;
        ListNode l2Next = l2 == null ? null : l2.next;

        if (l1Next != null || l2Next != null || result / 10 > 0) {
            output.next = addTwoNumbers(l1Next, l2Next, result / 10);
        }

        return output;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    public String longestPalindrome(String s) {
        int n = s.length();

        if (n == 1) {
            return s;
        }

        boolean[][] matrix = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
               if (i == j) {
                   matrix[i][j] = true;
               } else if (j - i == 1) {
                   matrix[i][j] = s.charAt(i) == s.charAt(j);
               } else {
                   matrix[i][j] = s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1];
               }
            }
        }

        int maxLen = 0;
        String palindrome = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (matrix[i][j] && j - i >= maxLen) {
                    maxLen = j - i;
                    palindrome = s.substring(i, j + 1);
                }
            }
        }

        return palindrome;
    }
}
