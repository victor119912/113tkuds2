import java.util.*;

public class LC33_SearchRotated_RentHot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        int l = 0, r = n-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                System.out.println(mid);
                return;
            }
            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]) r = mid-1;
                else l = mid+1;
            } else {
                if(nums[mid] < target && target <= nums[r]) l = mid+1;
                else r = mid-1;
            }
        }
        System.out.println(-1);
    }
}
