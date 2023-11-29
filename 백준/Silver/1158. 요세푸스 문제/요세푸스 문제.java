import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());

	     int n = Integer.parseInt(st.nextToken());
	     int k = Integer.parseInt(st.nextToken());
	     
	     ArrayList<Integer> list = new ArrayList<Integer>();
	     
	     int front = 0;
	     String answer = "<";
	     
	     for(int i=1; i<=n; i++) {
	    	 list.add(i);
	     }
	     
	     while(list.size()>0) {
	    	 answer += list.get((front+k-1)%list.size())+", ";
	    	 list.remove((front+k-1)%list.size());
	    	 
	    	 if(list.size() != 0) {
	    		 front = (front+k-1)%(list.size()+1);
	    	 }
	     }
	     answer = answer.substring(0,answer.length()-2);
	     answer += ">";
	     System.out.println(answer);
	}

}