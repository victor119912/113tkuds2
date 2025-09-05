class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";  // base case

        String prev = countAndSay(n - 1); // 遞迴求前一項
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(prev.charAt(i - 1));
                count = 1; // reset
            }
        }
        sb.append(count).append(prev.charAt(prev.length() - 1)); // 最後一段

        return sb.toString();
    }
}
