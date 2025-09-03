class Solution {
    public String intToRoman(int num) {
        // 對應表：數字對應到羅馬字，順序要從大到小
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        // 一直從最大數值開始減
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) { 
                num -= values[i];       // 減掉數值
                sb.append(symbols[i]);  // 加上對應的羅馬字
            }
        }

        return sb.toString(); // 回傳最後結果
    }
}
