import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 先排序，方便雙指針操作
        int n = nums.length;
        
        // 假設最接近的總和是前三個數的和
        int closestSum = nums[0] + nums[1] + nums[2];

        // 固定第一個數字
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;      // 左指針
            int right = n - 1;     // 右指針

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // 如果當前總和更接近 target，就更新 closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 如果剛好等於 target，直接回傳
                if (currentSum == target) {
                    return currentSum;
                } else if (currentSum < target) {
                    left++;  // 總和小於目標，左指針右移
                } else {
                    right--; // 總和大於目標，右指針左移
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {-1,2,1,-4};
        int target1 = 1;
        System.out.println(sol.threeSumClosest(nums1, target1));
        // 輸出: 2

        int[] nums2 = {0,0,0};
        int target2 = 1;
        System.out.println(sol.threeSumClosest(nums2, target2));
        // 輸出: 0
    }
}
