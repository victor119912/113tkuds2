// M11_HeapSortWithTie.java
import java.util.*;

public class M11_HeapSortWithTie {
    static class Pair { int val, idx; Pair(int v,int i){val=v;idx=i;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Pair[] arr=new Pair[n];
        for(int i=0;i<n;i++) arr[i]=new Pair(sc.nextInt(),i);

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> a.val!=b.val? b.val-a.val : a.idx-b.idx
        );
        for(Pair p:arr) pq.offer(p);
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--) ans[i]=pq.poll().val;
        for(int i=0;i<n;i++){
            if(i>0) System.out.print(" ");
            System.out.print(ans[i]);
        }
        System.out.println();
    }
}
/*
 * Time Complexity: O(n log n)
 * 說明：HeapSort透過建堆與pop，每次O(log n)，總O(n log n)。
 */
