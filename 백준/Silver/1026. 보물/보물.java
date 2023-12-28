import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     int[] a = new int[n];
	     int[] b = new int[n];
	     
	     int ans = 0;
	     
    	 st = new StringTokenizer(br.readLine());
    	 for(int j=0; j<n; j++) {
    		 a[j] = Integer.parseInt(st.nextToken());
    	 }
	     
    	 st = new StringTokenizer(br.readLine());
    	 for(int j=0; j<n; j++) {
    		 b[j] = Integer.parseInt(st.nextToken());
    	 }
	     
    	 Arrays.sort(a);
    	 Arrays.sort(b);
    	 
    	 for(int i=0; i<n; i++) {
    		 ans += a[i]*b[n-i-1];
    	 }
	     
	     sb.append(ans);
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}

}