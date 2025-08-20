// M09_AVLValidate.java
import java.util.*;

class Node3 {
    int val; Node3 left,right;
    Node3(int v){val=v;}
}
public class M09_AVLValidate {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] vals=new int[n];
        for(int i=0;i<n;i++) vals[i]=sc.nextInt();
        Node3 root=build(vals,0);
        if(!isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            System.out.println("Invalid BST");
            return;
        }
        if(checkAVL(root)==-2){
            System.out.println("Invalid AVL");
            return;
        }
        System.out.println("Valid");
    }
    static Node3 build(int[] a,int i){
        if(i>=a.length||a[i]==-1) return null;
        Node3 root=new Node3(a[i]);
        root.left=build(a,2*i+1);
        root.right=build(a,2*i+2);
        return root;
    }
    static boolean isBST(Node3 root,int min,int max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return isBST(root.left,min,root.val)&&isBST(root.right,root.val,max);
    }
    static int checkAVL(Node3 root){
        if(root==null) return -1;
        int lh=checkAVL(root.left); if(lh==-2) return -2;
        int rh=checkAVL(root.right); if(rh==-2) return -2;
        if(Math.abs(lh-rh)>1) return -2;
        return Math.max(lh,rh)+1;
    }
}
/*
 * Time Complexity: O(n)
 * 說明：檢查BST與AVL各需一次DFS，總計O(n)。
 */
