import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int mostMax(int[] list) {
		int[] dp = new int[list.length];
		int max = 0;
		dp[0] = list[0];
		
		if(list.length>1) {
			dp[1] = list[0]+list[1];
		}
		if(list.length>2) {
			dp[2] = Math.max(list[0]+list[1], Math.max(list[1]+list[2], list[0]+list[2]));
					
		}
		if(list.length>3) {
			for(int i=3; i<list.length; i++) {
				dp[i] = Math.max(Math.max(dp[i-3]+list[i-1]+list[i], dp[i-2]+list[i]),dp[i-1]);
			}
		}
		
		//System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		
		return dp[list.length-1];
	}
	
    public static void main(String[] args) throws IOException{ //실행을 위한 필수 요소
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
    	st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
       
        for(int i = 0 ; i < n; i++) {
	       	st = new StringTokenizer(br.readLine());
	       	int m = Integer.parseInt(st.nextToken());  //주어지는 포도주 양
	       	list[i] = m;
		} 
    	
    	System.out.println(mostMax(list));
    }
}