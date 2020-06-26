package different;

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String input) {
        int i = -1, size = input.length();
        Stack<String> segments = new Stack<>();
        StringBuilder folder = new StringBuilder();
        segments.push("/");

        while (++i < size) {
            if (input.charAt(i) == '/')
                continue;

            folder.setLength(0);

            while (i < size && input.charAt(i) != '/') {
                folder.append(input.charAt(i));
                ++i;
            }

            if (folder.toString().equals("..")) {
                if (segments.size() > 1) // is not empty
                    segments.pop();
            } else if (!folder.toString().equals(".")) {
                segments.push(folder.toString());
            }
        }

        Iterator<String> iterator = segments.iterator();
        StringBuilder output = new StringBuilder();

        if (iterator.hasNext())
            output.append(iterator.next());

        while (iterator.hasNext()) {
            output.append(iterator.next()).append("/");
        }

        if (output.length() > 1)
            output.deleteCharAt(output.length() - 1);

        return output.toString();
    }
}
