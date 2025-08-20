// M10_RBPropertiesCheck.java
import java.util.*;

class RBNode {
    int val; char color; RBNode left,right;
    RBNode(int v,char c){val=v;color=c;}
}
public class M10_RBPropertiesCheck {
    static int n;
    static int[] vals; static char[] colors;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        vals=new int[n]; colors=new char[n];
        for(int i=0;i<n;i++){ vals[i]=sc.nextInt(); colors[i]=sc.next().charAt(0);}
        if(n==0){ System.out.println("RB Valid"); return;}
        if(colors[0]!='B'){ System.out.println("RootNotBlack"); return;}
        String res=check(0);
        if(res.equals("OK")) System.out.println("RB Valid");
        else System.out.println(res);
    }
    static String check(int i){
        if(i>=n||vals[i]==-1) return "0";
        int l=2*i+1, r=2*i+2;
        if(colors[i]=='R'){
            if(l<n&&vals[l]!=-1&&colors[l]=='R') return "RedRedViolation at index "+l;
            if(r<n&&vals[r]!=-1&&colors[r]=='R') return "RedRedViolation at index "+r;
        }
        String left=check(l); if(!left.equals("OK")&&!left.matches("\\d+")) return left;
        String right=check(r); if(!right.equals("OK")&&!right.matches("\\d+")) return right;
        if(left.matches("\\d+")&&right.matches("\\d+")){
            if(!left.equals(right)) return "BlackHeightMismatch";
            int bh=Integer.parseInt(left)+(colors[i]=='B'?1:0);
            return String.valueOf(bh);
        }
        return "OK";
    }
}
