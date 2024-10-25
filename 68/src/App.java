import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        int w = 16;
        Solution obj = new Solution();
        List<String> res = obj.fullJustify(words, w);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
class Solution {
    private String spaces(int count) {
        String spaces = " ".repeat(count); 
        return spaces;
    }

    private List<String> addSpacesInBetween(List<String> ls, int w) {
        List<String> res = new ArrayList<>();
        for (int j = 0; j < ls.size() - 1; j++) {
            String s = ls.get(j);
            int len = s.length();
            String[] a = s.split(" ");
            int n = a.length;
            int leftspaces = w - (len - n + 1);
            StringBuilder sb = new StringBuilder();
            if (n == 1) {
                sb.append(s);
                sb.append(spaces(leftspaces));
                res.add(sb.toString());
                continue;
            }
            int q = leftspaces / (n - 1);
            int r = leftspaces % (n - 1);
            for (int i = 0; i < n; i++) {
                String s1 = a[i];
                sb.append(s1);
                if (i != n - 1)
                    sb.append(spaces(q));
                if (r > 0) {
                    sb.append(" ");
                    r -= 1;
                }
            }
            res.add(sb.toString());
        }
        String last = ls.get(ls.size() - 1);
        res.add(last + spaces(w - last.length()));

        return res;
    }

    public List<String> fullJustify(String[] words, int w) {
        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();
        int len = 0;
        int i = 0;
        int n = words.length;
        while (i < n) {
            String s = words[i];
            if (len + s.length() <= w) {
                sb.append(s);
                sb.append(" ");
                len += 1 + s.length();
                i++;
            } else {
                ls.add(sb.toString().trim());
                sb = new StringBuilder();
                len = 0;
            }
        }
        if (sb.length() != 0)
            ls.add(sb.toString().trim());
        return addSpacesInBetween(ls, w);
    }
}