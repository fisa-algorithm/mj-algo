import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int max = 0;
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     int k = Integer.parseInt(st.nextToken());
	     
	     int[] get = new int[n];
	     
	     st = new StringTokenizer(br.readLine());
	     
	     for(int i=0; i<n; i++) {
	    	 get[i] = Integer.parseInt(st.nextToken());
	     }
	     
	     int head = 0;  //시작 인덱스
	     int tail = 0;  //꼬리 인덱스
	     int cnt = 0;   //홀수의 개수
	     
	     while(true) {
	    	 if(cnt>k) {
	    		 if(get[head]%2==1) {
	    			 //get[head]가 홀수이면 head가 옮겨질 때 cnt--
	    			 cnt--;
	    		 }
	    		 head++;
	    	 }else if(tail==n) {
	    		 //tail이 n과 같아지면 끝
	    		 break;
	    	 }else {
	    		 if(get[tail]%2==1) {
	    			 //get[tail]이 홀수이면 tail이 1 커지면 cnt++
	    			 cnt++;
	    		 }
	    		 tail++;
	    	 }
	    	 if(cnt<=k) {
	    		 //전체 짝수 부분수열의 길이는 tail-head-(홀수의 개수)
	    		 max = Math.max(max, tail-head-cnt);
	    	 }
	     }
	     
	     sb.append(max);
	     bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	}

}