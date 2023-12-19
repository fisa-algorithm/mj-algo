import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     ArrayList<Integer> list = new ArrayList<>();
	     
	     st = new StringTokenizer(br.readLine());	 
	     
	     for(int i=0; i<n; i++) {
	    	 list.add(Integer.parseInt(st.nextToken()));
	     }
	     
	   
	     ArrayList<Integer> sumList = new ArrayList<Integer>();
	     sumList.add(list.get(0));
	     
	     for(int i=1; i<n; i++) {
	    	 int max = list.get(i);
	    	 if(sumList.get(i-1)+list.get(i)>max) {
	    		 max = sumList.get(i-1)+list.get(i);
	    	 }
	    	 sumList.add(max);
	     }

	     
	     Collections.sort(sumList);
	     
	     sb.append(sumList.get(n-1));
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}

}