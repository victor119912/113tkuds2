// M06_PalindromeClean.java
import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().toLowerCase();
        StringBuilder sb=new StringBuilder();
        for (char c:s.toCharArray()) if (Character.isLetter(c)) sb.append(c);
        String clean=sb.toString();
        String rev=sb.reverse().toString();
        System.out.println(clean.equals(rev)?"Yes":"No");
    }
}
