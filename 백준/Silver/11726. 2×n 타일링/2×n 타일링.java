import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{ //실행을 위한 필수 요소
    	st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        long D[] = new long[1001];
        
        D[1] = 1;
        
        D[2] = 2;
        
        for(int i=3; i<=n; i++) {
        	D[i] = (D[i-1] + D[i-2]) % 10007;
        }
	  
        System.out.println(D[n]);
 
	}
	
}