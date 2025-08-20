// M12_MergeKTimeTables.java
import java.util.*;

public class M12_MergeKTimeTables {
    static class Node { int val, li, idx; Node(int v,int l,int i){val=v;li=l;idx=i;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<K;i++){
            int len=sc.nextInt();
            List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<len;j++) tmp.add(sc.nextInt());
            lists.add(tmp);
        }
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<K;i++) if(!lists.get(i).isEmpty()) pq.offer(new Node(lists.get(i).get(0),i,0));
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            ans.add(cur.val);
            if(cur.idx+1<lists.get(cur.li).size()){
                pq.offer(new Node(lists.get(cur.li).get(cur.idx+1),cur.li,cur.idx+1));
            }
        }
        for(int i=0;i<ans.size();i++){
            if(i>0) System.out.print(" ");
            System.out.print(ans.get(i));
        }
        System.out.println();
    }
}
