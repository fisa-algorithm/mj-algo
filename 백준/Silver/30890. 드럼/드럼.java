import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringBuilder sb = new StringBuilder();
	    
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		
		int total = left*right;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=right; i<=total; i=i+right) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for(int i=left; i<=total; i=i+left) {
			map.put(i, map.getOrDefault(i, 0) + 2);
		}
		
		List<Integer> keySet = new ArrayList<Integer>(map.keySet());
		Collections.sort(keySet);
		
		for(Integer t : keySet) {
			sb.append(map.get(t));
		}
	    bw.write(sb.toString()); // 최종 결과 출력
	    bw.flush();
	    bw.close();
	}
}