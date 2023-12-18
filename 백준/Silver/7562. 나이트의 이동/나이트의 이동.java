import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int whereIs(int x, int y, int[][] graph, int end_x, int end_y) {
		
		int[] dx = {-1, 1, 2, -2, 2, 1, -2, -1};
		int[] dy = {2, 2, 1, 1, -1, -2, -1, -2};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] list = {x,y};
		queue.add(list);
		
		while(queue.size()!=0) {
			int[] data = queue.poll();
			int cur_i = data[0];
			int cur_j = data[1];
			for(int r=0; r<8; r++) {
				int next_i = cur_i + dx[r];
				int next_j = cur_j + dy[r];
				
				if(next_i>=0 && next_i<graph.length && next_j>=0 && next_j<graph[0].length) {
					if(graph[next_i][next_j] < 0) {
						graph[next_i][next_j] = graph[cur_i][cur_j]+1;
						int[] next_list = {next_i, next_j};
						queue.add(next_list);
					}
				}
			}
		}
//	    for(int j=0; j<graph.length; j++) {
//	    	System.out.println(Arrays.toString(graph[j]));
//	    }
		return graph[end_x][end_y];
	}
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 int k = Integer.parseInt(st.nextToken());  //k * k
	    	 
	    	 int[][] graph = new int[k][k];  //초기화값 = 0
	    	 
	    	 for(int j=0; j<k; j++) {
	    		 for(int p=0; p<k; p++) {
	    			 graph[j][p] = -1;
	    		 }
	    	 }
	    	 
	    	 st = new StringTokenizer(br.readLine());
	    	 
	    	 int x = Integer.parseInt(st.nextToken());
	    	 int y = Integer.parseInt(st.nextToken());
	    	 
	    	 graph[x][y] = 0;
	    	 
	    	 st = new StringTokenizer(br.readLine());
	    	 int end_x = Integer.parseInt(st.nextToken());
	    	 int end_y = Integer.parseInt(st.nextToken());
	    	 
	    	 sb.append(whereIs(x, y, graph, end_x, end_y)+"\n");
	    	 
	     }
	     
	     bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	}

}