class Solution {
    public int maxArea(int[] height) {
        int left = 0;                  // 左指針
        int right = height.length - 1; // 右指針
        int maxArea = 0;               // 記錄最大面積

        while (left < right) {
            int width = right - left; // 算寬度
            int h = Math.min(height[left], height[right]); // 高度看矮的那根
            int area = width * h; // 算面積
            maxArea = Math.max(maxArea, area); // 更新最大值

            // 移動比較矮的那邊，因為短板效應
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // 回傳最大面積
    }
}
