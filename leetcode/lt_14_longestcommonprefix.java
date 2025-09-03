class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // 先假設第一個字串是共同前綴
        String prefix = strs[0];

        // 從第二個字串開始比
        for (int i = 1; i < strs.length; i++) {
            // 當前字串
            String cur = strs[i];

            // 不斷縮短 prefix，直到它是 cur 的開頭
            while (cur.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // 沒有共同前綴
            }
        }

        return prefix;
    }
}
