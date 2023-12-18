import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	     
	     int answer = 0;
	     
	     int n = Integer.parseInt(st.nextToken());
	     
	     int minIndex = n; //양수 중 가장 작은 수의 인덱스
	     
	     int maxIndex = -1; //음수 중 가장 큰 수의 인덱스
	     
	     int count0 = 0;
	     boolean exist0 = false;  //0이 존재하면 true
	     
	     int count1 = 0;
	     boolean exist1 = false;  //1이 존재하면 true
	     
	     ArrayList<Integer> list = new ArrayList<>();
	     
	     for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 int num = Integer.parseInt(st.nextToken());
	    	 list.add(num);
	    	 
	    	 if(num == 0) {
	    		 //0의 개수
	    		 count0++;
	    		 exist0 = true;
	    	 }
	    	 if(num == 1) {
	    		 //1의 개수
	    		 count1++;
	    		 exist1 = true;
	    	 }
	     }
	     
	     Collections.sort(list);  //오름차순 정렬
	     
	     boolean find = false;  //양수 만나면 true
	     
	     for(int i=0; i<n; i++) {
	    	 if(list.get(i)<0) {
	    		 maxIndex = Math.max(maxIndex, i);  //음수 중 가장 큰 수의 인덱스
	    	 }else if(list.get(i)>0) {
	    		 minIndex = i;  //양수 중 가장 작은 수의 인덱스
	    		 find = true;
	    		 break;
	    	 }
	     }
	     
	     //System.out.println(maxIndex+","+minIndex);
	     
	     int numPositive = n - minIndex;  //양수 개수
	     
	     int numNegative = maxIndex + 1;  //음수 개수
	     
	     
	     //양수 더하기
	     if(exist1) {
	    	 //1이 존재하면 answer에 그냥 더하기
	    	 numPositive -= count1;
	    	 answer += count1;
	    	 if(numPositive != 0 && numPositive % 2 == 0) {
		    	 for(int i = minIndex+count1; i<n-1; i++) {
		    		 answer += list.get(i)*list.get(i+1);
		    		 i++;
		    	 }
		     }else if(numPositive % 2 == 1){
		    	 answer += list.get(minIndex+count1);
		    	 for(int i = minIndex+count1+1; i<n-1; i++) {
		    		 answer += list.get(i)*list.get(i+1);
		    		 i++;
		    	 }
		     }
	     }else {
	    	 if(numPositive != 0 && numPositive % 2 == 0) {
		    	 for(int i = minIndex; i<n-1; i++) {
		    		 answer += list.get(i)*list.get(i+1);
		    		 i++;
		    	 }
		     }else if(numPositive % 2 == 1){
		    	 answer += list.get(minIndex);
		    	 for(int i = minIndex+1; i<n-1; i++) {
		    		 answer += list.get(i)*list.get(i+1);
		    		 i++;
		    	 }
		     }
	     }
	     
	     
	     //음수 더하기
	     if(numNegative != 0 && numNegative % 2 == 0) {
	    	 for(int i=0; i<maxIndex; i++) {
	    		 answer += (list.get(i))*(list.get(i+1));
	    		 i++;
	    	 }
	     }else if(numNegative % 2 == 1) {
	    	 if(count0 > 0) {
	    		 //0 있음
	    		 for(int i=0; i<maxIndex-1; i++) {
	    			 answer += (list.get(i))*(list.get(i+1));
	    			 i++;
	    		 }
	    	 }else {
	    		 //0 없음
	    		 answer += list.get(maxIndex);
	    		 for(int i=0; i<maxIndex-1; i++) {
	    			 answer += (list.get(i))*(list.get(i+1));
	    			 i++;
	    		 }
	    	 }
	     }
	     
	     
	     sb.append(answer);
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}
}