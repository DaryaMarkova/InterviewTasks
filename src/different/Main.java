package different;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    private int[] memo;

    private boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        // 0 - unknown, -1 - bad, 1 - good
        memo[memo.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int limit = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= limit; j++) {
                if (memo[j] > 0) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        return memo[0] == 1;
    }


    public List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String key: strings) {
            char[] symbols = key.toCharArray();
            Arrays.sort(symbols);
            String sortedKey = new String(symbols);

            if (!anagrams.containsKey(sortedKey)) {
                anagrams.put(sortedKey, new LinkedList<>());
            }

            anagrams.get(sortedKey).add(key);
        }

        return anagrams.values().stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // List<List<String>> groups = new Main().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat" });
        System.out.println(new Main().canJump(new int[]{3,2,1,0,4}));
    }
}
