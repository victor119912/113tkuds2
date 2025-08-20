// M07_BinaryTreeLeftView.java
import java.util.*;

class Node {
    int val; Node left,right;
    Node(int v){val=v;}
}
public class M07_BinaryTreeLeftView {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n==0){ System.out.println("LeftView:"); return;}
        int[] vals=new int[n];
        for (int i=0;i<n;i++) vals[i]=sc.nextInt();
        Node root=build(vals,0);
        List<Integer> view=new ArrayList<>();
        if(root!=null){
            Queue<Node> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    Node cur=q.poll();
                    if(i==0) view.add(cur.val);
                    if(cur.left!=null) q.offer(cur.left);
                    if(cur.right!=null) q.offer(cur.right);
                }
            }
        }
        System.out.print("LeftView:");
        for(int v:view) System.out.print(" "+v);
        System.out.println();
    }
    static Node build(int[] a,int i){
        if(i>=a.length||a[i]==-1) return null;
        Node root=new Node(a[i]);
        root.left=build(a,2*i+1);
        root.right=build(a,2*i+2);
        return root;
    }
}
