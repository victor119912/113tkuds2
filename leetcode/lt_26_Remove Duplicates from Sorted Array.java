class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0; // 用來記錄不重複元素最後的位置

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) { 
                uniqueIndex++;            // 移動到下一個位置
                nums[uniqueIndex] = nums[i]; // 放入新的不重複元素
            }
        }

        return uniqueIndex + 1; // 返回不重複元素個數
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,1,2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println(k1); // 2
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + " "); // 1 2
        System.out.println();

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println(k2); // 5
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + " "); // 0 1 2 3 4
        System.out.println();
    }
}
