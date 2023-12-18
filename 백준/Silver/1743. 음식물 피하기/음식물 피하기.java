import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static int numIsMany(int[][] graph) {
		int count = 0;
		boolean[][] visited = new boolean[graph.length][graph[0].length];
	     
	    for(int i=0; i<graph.length; i++) {
	    	for(int j=0; j<graph[0].length; j++) {
	    		 if(graph[i][j] == 1 && !visited[i][j]) {
	    			 count = Math.max(count, bfs(i, j, graph, visited)+1);
	    		 }
	    	}
	    }
		return count;
	}
	
	public static int bfs(int i, int j, int[][] graph, boolean[][] visited){
		visited[i][j] = true;
		int count = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] list = {i,j};
		queue.add(list);
		while(queue.size()!=0) {
			int[] data = queue.poll();
			int cur_i = data[0];
			int cur_j = data[1];
			for(int r=0; r<4; r++) {
				int next_i = cur_i + dx[r];
				int next_j = cur_j + dy[r];
				if(next_i>=0 && next_i<visited.length && next_j>=0 && next_j<visited[0].length) {
					if(graph[next_i][next_j] == 1 && !visited[next_i][next_j]) {
						count++;
						visited[next_i][next_j] = true;
						int[] next_list = {next_i, next_j};
						queue.add(next_list);
					}
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     int m = Integer.parseInt(st.nextToken());
	     
	     int k = Integer.parseInt(st.nextToken());
	  
	     int[][] graph = new int[n][m];
	     
	     for(int i=0; i<k; i++) {
	    	 st = new StringTokenizer(br.readLine());	
	    	 int r = Integer.parseInt(st.nextToken());
	    	 int c = Integer.parseInt(st.nextToken());
	    	 graph[r-1][c-1] = 1;
	     }
	     
	     sb.append(numIsMany(graph));
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}

}