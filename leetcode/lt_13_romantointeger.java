class Solution {
    public int romanToInt(String s) {
        // 建立羅馬字對應表
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0; // 總和

        // 從左掃到右
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i)); // 當前數字

            // 看下一個，如果比它大 → 減法
            if (i + 1 < s.length() && cur < map.get(s.charAt(i + 1))) {
                total -= cur;
            } else {
                total += cur; // 否則就是加
            }
        }

        return total;
    }
}
