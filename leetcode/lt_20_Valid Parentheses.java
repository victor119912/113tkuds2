import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // 使用堆疊來儲存開括號
        Stack<Character> stack = new Stack<>();
        
        // 遍歷字串每個字元
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')'); // 對應的閉括號入堆疊
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // 如果是閉括號
                if (stack.isEmpty() || stack.pop() != c) {
                    return false; // 不匹配，直接返回 false
                }
            }
        }
        
        // 最後堆疊應該為空，才算有效
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));       // true
        System.out.println(sol.isValid("()[]{}"));   // true
        System.out.println(sol.isValid("(]"));       // false
        System.out.println(sol.isValid("([])"));     // true
        System.out.println(sol.isValid("([)]"));     // false
    }
}
