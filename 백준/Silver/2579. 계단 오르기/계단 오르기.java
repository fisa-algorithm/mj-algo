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
	     
	     int[] step = new int[n];
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 step[i] = Integer.parseInt(st.nextToken());
	     }
	     
	     int[] score = new int[n];
	     
	     
	     score[0] = step[0];  //첫번째칸
	     if(n>1) {
	    	 score[1] = step[0]+step[1];  //두번째칸
	     }
	     
	     if(n>2) {
	    	 score[2] = Math.max(step[0]+step[2], step[1]+step[2]);  //세번째칸
	     }
	     
	     if(n>2) {
		     for(int i=3; i<n; i++) {
		    	 score[i] = Math.max(score[i-2], score[i-3]+step[i-1])+step[i];  //i+1번째 칸
		     }
	     }
	     sb.append(score[n-1]);
	     bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	}
}