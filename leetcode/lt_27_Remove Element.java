class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0; // 用來放非 val 元素的位置

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {      // 遇到非 val 元素才放進 index 位置
                nums[index] = nums[i];
                index++;
            }
        }

        return index; // 返回不等於 val 的元素個數
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3,2,2,3};
        int k1 = sol.removeElement(nums1, 3);
        System.out.println(k1); // 2
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + " "); // 2 2
        System.out.println();

        int[] nums2 = {0,1,2,2,3,0,4,2};
        int k2 = sol.removeElement(nums2, 2);
        System.out.println(k2); // 5
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + " "); // 0 1 3 0 4 (順序可不同)
        System.out.println();
    }
}
