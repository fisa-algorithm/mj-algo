import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	public static ArrayList<Integer> dfs(HashMap<Integer, ArrayList<Integer>> map, int cur_v, ArrayList<Integer> visited){
		visited.add(cur_v);
		for(int v : map.get(cur_v)) {
			if(!visited.contains(v)) {
				visited = dfs(map,v,visited);
			}
		}
		return visited;
	}
	
	public static ArrayList<Integer> bfs(HashMap<Integer, ArrayList<Integer>> map, int cur_v){
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(cur_v);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(cur_v);
		while(queue.size()!=0) {
			cur_v = queue.poll();
			for(int v : map.get(cur_v)) {
				if(!visited.contains(v)) {
					visited.add(v);
					queue.add(v);
				}
			}
		}
		return visited;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());;
	    StringBuilder sb = new StringBuilder();
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    int start = Integer.parseInt(st.nextToken());
	    String answer = "";
	    
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	    
	    for(int i=1; i<=n; i++) {
	    	ArrayList<Integer> list = new ArrayList<Integer>();
	    	map.put(i, list);
	    }
	    
	    
	    
	    for(int i=0; i<k; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int frist = Integer.parseInt(st.nextToken());
	    	int second = Integer.parseInt(st.nextToken());
	    	map.get(frist).add(second);
	    	map.get(second).add(frist);
	    }
	    
	    //System.out.println(map);
	    
	    //value값 오름차순 정렬
	    for(int key : map.keySet()) {
	    	Collections.sort(map.get(key));
	    	//System.out.println("value"+map.get(key));
	    }
	    
	    ArrayList<Integer> visited = new ArrayList<Integer>();
	    
//	    System.out.println(dfs(map, start, visited));
//	    System.out.println(bfs(map, start));
	    
	    ArrayList<Integer> ans = dfs(map, start, visited);
	    ArrayList<Integer> ans2 = bfs(map, start);
	    
	    for(int i=0; i<ans.size(); i++) {
	    	answer += ans.get(i)+" ";
	    }
	    answer += "\n";
	    for(int i=0; i<ans2.size(); i++) {
	    	answer += ans2.get(i)+" ";
	    }
	    
	    sb.append(answer);
	    bw.write(sb.toString()); // 최종 결과 출력
	    bw.flush();
	    bw.close();
	}
}