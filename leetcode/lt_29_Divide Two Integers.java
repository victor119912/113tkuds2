class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // 防溢位

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;

        long result = 0;
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) { // 加速減法
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        return sign * (int)result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.divide(10, 3)); // 3
        System.out.println(sol.divide(7, -3)); // -2
    }
}
