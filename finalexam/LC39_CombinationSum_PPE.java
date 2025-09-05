import java.util.*;

public class LC39_CombinationSum_PPE {
    static List<List<Integer>> res;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, new ArrayList<>(), 0);
        for(List<Integer> comb: res){
            for(int i=0;i<comb.size();i++){
                if(i>0) System.out.print(" ");
                System.out.print(comb.get(i));
            }
            System.out.println();
        }
    }

    static void backtrack(int[] nums, int remain, List<Integer> path, int idx){
        if(remain == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i] > remain) break;
            path.add(nums[i]);
            backtrack(nums, remain - nums[i], path, i); // i for reuse
            path.remove(path.size()-1);
        }
    }
}
