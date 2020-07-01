package combinations;
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    // restore addresses
    public static void main(String[] args) {
        new RestoreIPAddresses().restoreIpAddresses("25525511135");
        // new RestoreIPAddresses().restore("25525511135", 0, new LinkedList<>());
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<>();
        restoreIp(s, solutions, 0, "", 0);
        solutions.forEach(solution -> System.out.println(solution));
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int start, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && start == ip.length()) solutions.add(restored);

        for (int i = 1; i < 4; i++) {
            if (start + i > ip.length()) break;

            String s = ip.substring(start,start + i);

            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, start + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}
