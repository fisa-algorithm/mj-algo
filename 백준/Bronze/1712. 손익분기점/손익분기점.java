import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	    
	     long a = Long.parseLong(st.nextToken());
	     long b = Long.parseLong(st.nextToken());
	     long c = Long.parseLong(st.nextToken());
	     
	     long k = -1;
	     
	     if(b==c) {
	    	 System.out.println(k);
	     }else {
	    	 if((double)a/(c-b)>0) {
		    	 k = (long)Math.ceil((double)a/(c-b));
		    	 if((double)a/(c-b)==Math.ceil((double)a/(c-b))) {
		    		 k++;
		    	 }
	    	 }
	    	 System.out.println(k); //답 출력
	     }
	    
	}

}