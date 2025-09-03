import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums); // 先排序，方便雙指針和去重
        int n = nums.length;

        // 第一層迴圈，固定第一個數字
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

            // 第二層迴圈，固定第二個數字
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 去重

                int left = j + 1;      // 左指針
                int right = n - 1;     // 右指針

                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right]; // 防止整數溢位

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 左右指針去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // 總和小於目標，左指針右移
                    } else {
                        right--; // 總和大於目標，右指針左移
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(sol.fourSum(nums1, target1));
        // 輸出: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        int[] nums2 = {2,2,2,2,2};
        int target2 = 8;
        System.out.println(sol.fourSum(nums2, target2));
        // 輸出: [[2,2,2,2]]
    }
}
