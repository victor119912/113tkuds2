import java.util.*;

public class LC34_SearchRange_DelaySpan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        int left = lowerBound(nums, target);
        if(left == n || nums[left] != target){
            System.out.println("-1 -1");
            return;
        }
        int right = lowerBound(nums, target+1)-1;
        System.out.println(left + " " + right);
    }

    static int lowerBound(int[] arr, int val){
        int l = 0, r = arr.length;
        while(l < r){
            int m = l + (r-l)/2;
            if(arr[m] < val) l = m+1;
            else r = m;
        }
        return l;
    }
}
