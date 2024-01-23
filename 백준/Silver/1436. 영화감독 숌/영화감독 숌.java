import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int ans = 0;
		for(int i=1; i<1000000000; i++) {
			String newStr = i+"";
			if(newStr.contains("666")) {
				ans++;
			}
			if(ans==n) {
				System.out.println(newStr);
				break;
			}
		}
		
		sc.close();
	}

}
