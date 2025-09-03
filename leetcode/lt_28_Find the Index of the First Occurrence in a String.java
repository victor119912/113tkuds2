class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0; // 空字串直接返回 0

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // 找到第一個匹配位置
            }
        }
        return -1; // 沒找到
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.strStr("sadbutsad", "sad")); // 0
        System.out.println(sol.strStr("leetcode", "leeto")); // -1
    }
}
