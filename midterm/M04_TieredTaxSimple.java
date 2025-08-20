// M04_TieredTaxSimple.java
import java.util.*;

public class M04_TieredTaxSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long total = 0;
        for (int i=0;i<n;i++) {
            long income = sc.nextLong();
            long tax = calc(income);
            total += tax;
            System.out.println("Tax: " + tax);
        }
        System.out.println("Average: " + (total/n));
    }
    static long calc(long x) {
        long tax=0;
        if (x>1000000) { tax += (x-1000000)*30/100; x=1000000; }
        if (x>500000) { tax += (x-500000)*20/100; x=500000; }
        if (x>120000) { tax += (x-120000)*12/100; x=120000; }
        tax += x*5/100;
        return tax;
    }
}
/*
 * Time Complexity: O(n)
 * 說明：逐一計算，每筆收入花費O(1)，總共O(n)。
 */
