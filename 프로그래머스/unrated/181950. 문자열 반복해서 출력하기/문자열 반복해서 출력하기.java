import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String msg = "";
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            msg += str+"";
        }
        System.out.print(msg);
    }
}