import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static int mini(int n) {
		int ans = -1;
	     
	     ArrayList<Integer> list = new ArrayList<Integer>();
	     
	     for(int i = n/5; i>=0; i--) {
	    	 int partAns = 0;
	    	 int k = n;
	    	 k -= 5*i;
	    	 partAns += i;
	    	 if(k!=0 && k%3==0) {
	    		 partAns += k/3;
	    		 list.add(partAns);
	    	 }else if(k==0){
	    		 list.add(partAns);
	    	 }
	     }
	     
	     if(list.size()==0) {
	    	 return -1;
	     }
	     
	     Collections.sort(list);
	     
		 return list.get(0);
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     sb.append(mini(n));
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}

}