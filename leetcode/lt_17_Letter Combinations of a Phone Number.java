import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result; // 空字串直接返回空結果

        // 數字對應的字母表 (像電話鍵盤)
        String[] mapping = {
            "",     // 0 沒有字母
            "",     // 1 沒有字母
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(result, new StringBuilder(), digits, 0, mapping);
        return result;
    }

    // 回溯函數
    private void backtrack(List<String> result, StringBuilder temp, String digits, int index, String[] mapping) {
        // 如果臨時字串長度等於輸入長度，表示完成一組組合
        if (temp.length() == digits.length()) {
            result.add(temp.toString());
            return;
        }

        int digit = digits.charAt(index) - '0'; // 取得數字對應整數
        String letters = mapping[digit];       // 對應的字母

        for (char c : letters.toCharArray()) {
            temp.append(c);                    // 選擇字母
            backtrack(result, temp, digits, index + 1, mapping); // 遞迴下一個數字
            temp.deleteCharAt(temp.length() - 1); // 回溯，移除最後一個字母
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
        // 輸出: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        System.out.println(sol.letterCombinations(""));
        // 輸出: []

        System.out.println(sol.letterCombinations("2"));
        // 輸出: ["a","b","c"]
    }
}
