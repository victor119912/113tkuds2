import java.util.*;

public class LC17_PhoneCombos_CSShift {
    static String[] map = {
        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        if (digits.isEmpty()) return;
        backtrack(digits, 0, new StringBuilder());
    }

    static void backtrack(String digits, int idx, StringBuilder sb) {
        if (idx == digits.length()) {
            System.out.println(sb.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '2'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
