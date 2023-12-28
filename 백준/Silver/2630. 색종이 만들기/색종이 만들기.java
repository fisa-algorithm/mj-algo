import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	//색종이 받아서 모두 다 0 또는 1 이면 ans 더해서 반환. 아니면 재귀로 자르기
	public static int[] cut(int[][] paper) {
		int[] ans = new int[2];
		if(paper.length==1) {
			if(paper[0][0] == 0) {
				ans[0]++;
			}else {
				ans[1]++;
			}
			return ans;
		}
		
		boolean t = true;
		int frist = paper[0][0];
		
		for(int i=0; i<paper.length; i++) {
			for(int j=0; j<paper[0].length; j++) {
				if(frist != paper[i][j]) {
					t = false;
				}
			}
		}
		
		if(t) {
			//전부다 1 또는 0
			if(frist == 0) {
				ans[0]++;
			}else {
				ans[1]++;
			}
			return ans;
		}else {
			//전부다 1 또는 0이 아님. 잘라야함.
			
			int[][] paper1 = new int[paper.length/2][paper.length/2];
			int[][] paper2 = new int[paper.length/2][paper.length/2];
			int[][] paper3 = new int[paper.length/2][paper.length/2];
			int[][] paper4 = new int[paper.length/2][paper.length/2];
			
			for(int i=0; i<paper.length/2; i++) {
				for(int j=0; j<paper.length/2; j++) {
					paper1[i][j] = paper[i][j];
				}
			}
			for(int i=0; i<paper.length/2; i++) {
				for(int j=0; j<paper.length/2; j++) {
					paper2[i][j] = paper[i][j+paper.length/2];
				}
			}
			for(int i=0; i<paper.length/2; i++) {
				for(int j=0; j<paper.length/2; j++) {
					paper3[i][j] = paper[i+paper.length/2][j];
				}
			}
			for(int i=0; i<paper.length/2; i++) {
				for(int j=0; j<paper.length/2; j++) {
					paper4[i][j] = paper[i+paper.length/2][j+paper.length/2];
				}
			}
			
			ans[0] = cut(paper1)[0]+cut(paper2)[0]+cut(paper3)[0]+cut(paper4)[0];
			ans[1] = cut(paper1)[1]+cut(paper2)[1]+cut(paper3)[1]+cut(paper4)[1];
			
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	   
	     int n = Integer.parseInt(st.nextToken());
	     
	     int[][] paper = new int[n][n];
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 for(int j=0; j<n; j++) {
	    		 paper[i][j] = Integer.parseInt(st.nextToken());
	    	 }
	     }
	     
	     int[] ans = new int[2]; 
	     
	     int[] answer = cut(paper);
	     
	     sb.append(answer[0]+"\n");
	     sb.append(answer[1]);
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}

}