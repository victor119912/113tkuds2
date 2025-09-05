import java.util.*;

public class LC28_StrStr_NoticeSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        if(needle.length() == 0){
            System.out.println(0);
            return;
        }
        int n = haystack.length(), m = needle.length();
        for(int i=0;i<=n-m;i++){
            if(haystack.substring(i,i+m).equals(needle)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
