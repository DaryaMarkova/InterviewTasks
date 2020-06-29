import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        new DecodeWays().numDecodings("216");
    }

    int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int currentDigit = Integer.valueOf(s.substring(i - 1, i));
            int prevTwoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (currentDigit >= 1) {
                dp[i] += dp[i-1];
            }

            if (prevTwoDigits >= 10 && prevTwoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    private int numDecodings(String s, int start) {
        int count = 0;

        if (start == s.length()) {
            return 1;
        }


        for (int i = start; i < s.length(); i++) {
            int value = Integer.parseInt(s.substring(start, i + 1));

            if (value == 0) {
                return 0;
            }

            if (value < 27 && value > 0) {
               count += numDecodings(s, i + 1);
            } else if (value > 27) {
                return count;
            }
        }

        return count;
    }

    private void numDecodings(String s, int start, List<String> output) {
        if (start == s.length()) {
            System.out.println(output);
        }

        for (int i = start; i < s.length(); i++) {
            String substr = s.substring(start, i + 1);

            if (Integer.parseInt(substr) < 27) {
                output.add(substr);
                numDecodings(s, i + 1, output);

                if (!output.isEmpty()) {
                    output.remove(output.size() - 1);
                }
            }
        }
    }
}
