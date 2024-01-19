import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] xmove = {-1,0,0,1};
	static int[] ymove = {0,-1,1,0};
	
	public static int move(int size, int howManyEat, int[][] map) {
		int time = 0;
		
		int x = -1;  //상어 위치 x
		int y = -1;  //상어 위치 y
	
		for(int i=0; i<map.length; i++) {
	    	 for(int j=0; j<map.length; j++) {
	    		 if(map[i][j] == 9) {
	    			 x = i;
	    			 y = j;
	    		 }
	    	 }
		}
		
		int[] list = bfs(map, size);
		
		//먹을 수 있는 물고기가 없으면 끝
		if(list[0] == -1 || list[1] == -1 || list[2] == -1) {
			//먹을 수 없음
			return time;
		}else {
			//먹을 수 있음
			howManyEat = howManyEat+1;
			
			time += list[0];
			if(size == howManyEat) {
				size++;
				howManyEat = 0;
			}
			//System.out.println("먹으려는 애 좌표:"+list[1]+","+list[2]);
			map[x][y] = 0;
			map[list[1]][list[2]] = 9;
			time += move(size, howManyEat, map);
		}
		return time;
	}
	
	//다음에 먹을 먹이 위치와 걸린 시간 반환
	public static int[] bfs(int[][] map, int size) {
		int[] ans = new int[3];
		
		//초기화
		ans[0] = -1;
		ans[1] = -1;
		ans[2] = -1;
		
		int x = -1;  //상어 위치 x
		int y = -1;  //상어 위치 y
		
		int[][] graph = new int[map.length][map[0].length];  //몇칸 이동했는지 표시하는 배열
		
		loop:
		for(int i=0; i<map.length; i++) {
	    	 for(int j=0; j<map.length; j++) {
	    		 if(map[i][j] == 9) {
	    			 x = i;
	    			 y = j;
	    			 break loop;
	    		 }
	    	 }
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				//시간이 같을 때
				if(Integer.compare(a[0],b[0])==0) {
					//x좌표 같을 때
					if(Integer.compare(a[1],b[1])==0) {
						//y좌표 같을 때
						return Integer.compare(a[2],b[2]);
					}
					return Integer.compare(a[1],b[1]);
				}
				return Integer.compare(a[0],b[0]);
			}
		});
		
		queue.offer(new int[] {0, x, y});
		
		while(!queue.isEmpty()) {
			int[] data = queue.poll();
			int cur_i = data[1];
			int cur_j = data[2];
			
			if(map[cur_i][cur_j]>0 && map[cur_i][cur_j] < size && map[cur_i][cur_j] != 9) {
				//먹을 수 있음
				return data;
			}
			
			for(int i=0; i<4; i++) {
				int next_i = cur_i + xmove[i];
				int next_j = cur_j + ymove[i];
				
				if(next_i<0 || next_i>=map.length || next_j<0 || next_j>=map[0].length || map[next_i][next_j] > size || graph[next_i][next_j] != 0) {
					continue;
				}
				
				//이동 가능
				graph[next_i][next_j] = graph[cur_i][cur_j] + 1;
				queue.offer(new int[] {graph[next_i][next_j], next_i, next_j});
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());

	     int n = Integer.parseInt(st.nextToken());
	     
	     int[][] map = new int[n][n];
	     
	     int size = 2;  //아기상어 크기
	     
	     int howManyEat = 0;  //먹은 먹이 개수
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 for(int j=0; j<n; j++) {
	    		 int k = Integer.parseInt(st.nextToken());
	    		 map[i][j] = k;
	    	 }
	     }
	     
	     System.out.println(move(size, howManyEat, map));
	    
	}

}