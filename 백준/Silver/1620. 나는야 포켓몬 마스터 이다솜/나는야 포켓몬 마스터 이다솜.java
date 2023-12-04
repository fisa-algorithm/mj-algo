import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     HashMap<String, Integer> mapString = new HashMap<>();
	     HashMap<Integer, String> mapInteger = new HashMap<>();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     int k = Integer.parseInt(st.nextToken());
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 String name = st.nextToken();
	    	 mapString.put(name,i+1);
	    	 mapInteger.put(i+1, name);
	     }
	     
	     for(int i=0; i<k; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 String something = st.nextToken();
	    	 if(65<=something.charAt(0) && something.charAt(0)<=122) {
	    		 //65~122이면 숫자아님
	    		 sb.append(mapString.get(something)).append("\n");
	    		 
	    	 }else {
	    		 //숫자
	    		 sb.append(mapInteger.get(Integer.parseInt(something))).append("\n");
	    	 }
	     }
	     
	     sb.substring(0, 2*k-1);
	     bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	}

}