import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int pibo(int num) {
		if(num==1) {
			return 1;
		}else if(num==2) {
			return 2;
		}else if(num==3) {
			return 4;
		}
		
		int ans=0;
		
		int i = 3;
		while(i>0) {
			i--;
			num--;
			ans += pibo(num);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     int[] step = new int[n];
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 step[i] = Integer.parseInt(st.nextToken());
	     }
	     
	     
	    
	     for(int i=0; i<n; i++) {
	    	 sb.append(pibo(step[i])+"\n");
	     }
	     
	     bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	}

}
