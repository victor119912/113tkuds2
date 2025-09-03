class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * 回溯函數
     * @param result 結果列表
     * @param temp 當前臨時字串
     * @param open 已使用的左括號數量
     * @param close 已使用的右括號數量
     * @param n 括號對數
     */
    private void backtrack(List<String> result, StringBuilder temp, int open, int close, int n) {
        // 當臨時字串長度達到 2*n，表示生成完成一組括號
        if (temp.length() == 2 * n) {
            result.add(temp.toString());
            return;
        }

        // 如果還可以放左括號，放左括號並遞迴
        if (open < n) {
            temp.append('(');
            backtrack(result, temp, open + 1, close, n);
            temp.deleteCharAt(temp.length() - 1); // 回溯
        }

        // 如果右括號數小於左括號數，放右括號並遞迴
        if (close < open) {
            temp.append(')');
            backtrack(result, temp, open, close + 1, n);
            temp.deleteCharAt(temp.length() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3;
        System.out.println(sol.generateParenthesis(n1));
        // 輸出: ["((()))","(()())","(())()","()(())","()()()"]

        int n2 = 1;
        System.out.println(sol.generateParenthesis(n2));
        // 輸出: ["()"]
    }
}
