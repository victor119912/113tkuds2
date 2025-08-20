// M05_GCD_LCM_Recursive.java
import java.util.*;

public class M05_GCD_LCM_Recursive {
    static long gcd(long a,long b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong(), b=sc.nextLong();
        long g=gcd(a,b);
        long l=a/g*b;
        System.out.println("GCD: "+g);
        System.out.println("LCM: "+l);
    }
}
/*
 * Time Complexity: O(log(min(a,b)))
 * 說明：歐幾里得遞迴，每步驟取模，步數約為log(min(a,b))。
 */
