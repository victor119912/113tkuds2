class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 先排序

        for (int i = 0; i < nums.length - 2; i++) {
            // 避免重複：同樣的起始數字直接跳過
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一組答案
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳過重複的 left
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 跳過重複的 right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // 太小了 → 左邊往右移
                } else {
                    right--; // 太大了 → 右邊往左移
                }
            }
        }

        return res;
    }
}
