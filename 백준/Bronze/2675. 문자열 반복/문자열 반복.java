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
	        
	        
	        for(int i = 0 ; i < n; i++) {
	        	
	        	st = new StringTokenizer(br.readLine());
	        	int m = Integer.parseInt(st.nextToken());
	        	String text = st.nextToken();
	        	String ans = "";	
	      
	        	
				for(int z=0;z<text.length();z++) {
					for(int j=1;j<=m;j++) {
						ans += text.substring(z,z+1);
					}
				}
				System.out.println(ans);
	        }	
	}

}