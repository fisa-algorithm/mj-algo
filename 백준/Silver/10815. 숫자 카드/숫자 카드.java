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
	     StringTokenizer st;
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(br.readLine());
	     int[] get = new int[n];
	     st = new StringTokenizer(br.readLine());
	     for(int i=0; i<n; i++) {
	    	 get[i] = Integer.parseInt(st.nextToken());
	     }

	     String ans = "";
	     
	     int k = Integer.parseInt(br.readLine());
	     int[] test = new int[k];
	     st = new StringTokenizer(br.readLine());
	     for(int i=0; i<k; i++) {
	    	 test[i] = Integer.parseInt(st.nextToken());
	     }
	     
	     Arrays.sort(get);

	     //System.out.println(Arrays.toString(get));
	     //System.out.println(Arrays.toString(test));
	       	     
	     int[] answer = new int[k];
	     
	     for(int i=0; i<k; i++) {
	    	 int pointL = 0;
		     int pointR = n-1;
		     
		     //System.out.println("i: "+i);
	    	 while(pointL <= pointR) {
	    		 int mid = (pointL+pointR)/2;
	    		 //System.out.println("pointL: "+pointL);
	    		 //System.out.println("pointR: "+pointR);
	    		 if(test[i] < get[mid]) {
	    			 pointR = mid-1;
	    		 }else if(test[i] > get[mid]) {
	    			 pointL = mid+1;
	    		 }else {
	    			 answer[i] = 1;
	    			 break;
	    		 }
	    	 }
	    	 
	     }
	     
	     for(int i : answer) {
	    	 sb.append(i).append(" ");
	     }
	     sb.substring(0, 2*k-1);
	     bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	}
}