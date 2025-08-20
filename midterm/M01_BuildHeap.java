// M01_BuildHeap.java
import java.util.*;

public class M01_BuildHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next();   // max or min
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int i = n/2 - 1; i >= 0; i--) heapify(arr, n, i, type.equals("max"));

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    private static void heapify(int[] arr, int n, int i, boolean isMax) {
        int extreme = i;
        int l = 2*i+1, r = 2*i+2;
        if (l < n && compare(arr[l], arr[extreme], isMax)) extreme = l;
        if (r < n && compare(arr[r], arr[extreme], isMax)) extreme = r;
        if (extreme != i) {
            int tmp = arr[i]; arr[i] = arr[extreme]; arr[extreme] = tmp;
            heapify(arr, n, extreme, isMax);
        }
    }
    private static boolean compare(int a, int b, boolean isMax) {
        return isMax ? a > b : a < b;
    }
}
/*
 * Time Complexity: O(n)
 * 說明：Build-Heap 自底向上，總操作次數為 n。
 */
