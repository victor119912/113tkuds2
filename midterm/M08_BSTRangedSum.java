// M08_BSTRangedSum.java
import java.util.*;

class Node2 {
    int val; Node2 left,right;
    Node2(int v){val=v;}
}
public class M08_BSTRangedSum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] vals=new int[n];
        for(int i=0;i<n;i++) vals[i]=sc.nextInt();
        int L=sc.nextInt(),R=sc.nextInt();
        Node2 root=build(vals,0);
        System.out.println("Sum: "+dfs(root,L,R));
    }
    static Node2 build(int[] a,int i){
        if(i>=a.length||a[i]==-1) return null;
        Node2 root=new Node2(a[i]);
        root.left=build(a,2*i+1);
        root.right=build(a,2*i+2);
        return root;
    }
    static int dfs(Node2 root,int L,int R){
        if(root==null) return 0;
        if(root.val<L) return dfs(root.right,L,R);
        if(root.val>R) return dfs(root.left,L,R);
        return root.val+dfs(root.left,L,R)+dfs(root.right,L,R);
    }
}
