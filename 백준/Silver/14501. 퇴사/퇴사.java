import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static int outHow(ArrayList<ArrayList<Integer>> list) {
		int[] dp = new int[list.size()];
		for(int i=1; i<list.size(); i++) {
			if(i < list.get(i).get(0)) {
				//안됨
				dp[i] = dp[i-1];
			}else {
				dp[i] = Math.max(dp[i-1], list.get(i).get(1)+dp[i-list.get(i).get(0)]);
			}
		}
		return dp[list.size()-1];
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     int n = Integer.parseInt(st.nextToken());
	     
	     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	     ArrayList<Integer> newList = new ArrayList<Integer>();
	     
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 int t = Integer.parseInt(st.nextToken());
	    	 int p = Integer.parseInt(st.nextToken());
	    	 newList = new ArrayList<Integer>();
	    	 
	    	 newList.add(t);
	    	 newList.add(p);
	    	 
	    	 list.add(newList);
	     }
	     newList.add(0);
		 newList.add(0);
		 list.add(newList);
	     Collections.reverse(list);
	     
	     System.out.println(outHow(list));
	}

}