import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	//노드와 비용을 포함하는 객체를 미리 만든다
	static public class Node {
		//연결되는 정점
		int end;
		//비용
		int cost;
		
		Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
//		@Override
//		public String toString() {
//			return "["+end+", "+cost+"]";
//		}
	}
	
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     
	     int V = Integer.parseInt(st.nextToken());  //정점의 개수
	     int E = Integer.parseInt(st.nextToken());  //간선의 개수
	     
	     st = new StringTokenizer(br.readLine()); 
	     int start = Integer.parseInt(st.nextToken());  //시작점 위치
	     
	     //1. 1차원 리스트 만들기
	     //인덱스의 번호 = 노드의 번호이므로 1차원 리스트의 크기를 1 늘려서 정의하면 편하다
	     List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	     for(int i=0; i<V+1; i++) {
	    	graph.add(new ArrayList<Node>());
	     }
	     
	     for(int i=0; i<E; i++) {
		     st = new StringTokenizer(br.readLine()); 
	    	 int u = Integer.parseInt(st.nextToken());  //정점의 개수
		     int v = Integer.parseInt(st.nextToken());  //간선의 개수
		     int w = Integer.parseInt(st.nextToken());  //정점의 개수
		     
		     graph.get(u).add(new Node(v,w));
		     //만일 무향 그래프라면 반대의 상황도 추가해준다
		     //graph.get(v).add(new Node(u,w));
		     
	     }
	     
	     //인접리스트 출력
	     //System.out.println(graph);
	     
	     //2. 방문여부를 확인할 boolean 배열, start 노드부터 end 노드까지의 최소 거리를 저장할 배열을 만든다
	     boolean[] visited = new boolean[V+1];
	     int[] dist = new int[V+1];
	     
	     //3. 최소거리 정보를 담을 배열을 초기화
	     for(int i=0; i<V+1; i++) {
	    	 //출발지점 외 나머지 지점까지의 최소비용은 최대로 지정한다
	    	 dist[i] = Integer.MAX_VALUE;
	     }
	     
	     PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
	     
	     q.offer(new Node(start, 0));
	     
	     //출발 지점의 비용은 0으로 시작
	     dist[start] = 0;
	     
	     while(!q.isEmpty()) {
	    	 Node curNode = q.poll();
	    	 if(dist[curNode.end] < curNode.cost) {
	    		 //다음 노드가 이미 더 작은 가중치로 방문됨
	    		 continue;
	    	 }
	    	 
	    	 for(int i=0; i<graph.get(curNode.end).size(); i++) {
	    		 Node nxtNode = graph.get(curNode.end).get(i);
	    		 if(dist[nxtNode.end] > curNode.cost + nxtNode.cost) {
	    			 //다음노드까지 cost가 최소거리 저장한 배열의 값보다 작으면 업데이트하고 q에 담기
	    			 dist[nxtNode.end] = curNode.cost + nxtNode.cost;
	    			 q.offer(new Node(nxtNode.end, dist[nxtNode.end]));
	    		 }
	    	 }
	     }
	    
	     for(int i=1; i<V+1; i++) {
	    	 if(dist[i] < 2147483647) {
	    		 System.out.println(dist[i]);
	    	 }else {
	    		 System.out.println("INF");
	    	 }
	    	 
	     }
	}
}

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

0
2
3
7
INF
*/