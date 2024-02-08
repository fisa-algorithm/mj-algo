import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StairDownDP {
	//DP
	public static int[][] down(int[][] stair, int cur_x, int cur_y, int[][] memo) {
		for(int i=1; i<stair.length; i++) {
			for(int j=0; j<3; j++) {
				if(stair[i][j] == 0) {
					 int min = Math.min(memo[i-1][j%3], memo[i-1][(j+2)%3]+Math.abs(j-(j+2)%3));
					 memo[i][j] = Math.min(memo[i-1][(j+1)%3]+Math.abs(j-(j+1)%3), min);
					//memo[i-1][j%3] 그대로
					//memo[i-1][(j+2)%3]+Math.abs(j-(j+2)%3) 옆쪽
					//memo[i-1][(j+1)%3]+Math.abs(j-(j+1)%3) 옆쪽
					//j=0,1,2 일 경우 각각에 이동 횟수 더하기
				}
			}
		}
		
		return memo;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] stair = new int[n+1][3];
		
		int[][] memo = new int[n+1][3];  //dp
		
		for(int i=0; i<memo.length; i++) {
			for(int j=0; j<memo[0].length; j++) {
				memo[i][j] = memo.length*2;
			}
		}
		
		memo[0][1] = 0;
		
		stair[0][0] = 1;
		stair[0][1] = 0;
		stair[0][2] = 1;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				stair[i+1][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] newMemo = down(stair, 0, 1, memo);
		
		int minNum = Math.min(newMemo[n][0], newMemo[n][1]);
		minNum = Math.min(minNum, newMemo[n][2]);
		
		System.out.println(minNum);
	}

}
