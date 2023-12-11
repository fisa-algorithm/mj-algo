import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     StringBuilder sb = new StringBuilder();
	    
	     String[] str = st.nextToken().split("");
	    
	     //System.out.println(Arrays.toString(str));
	    
	     int count = 0;
	    
	     String answer = "";
	    
	     String[] ans = new String[str.length];
	    
	     Stack<Integer> stack = new Stack<>();
	    
	     boolean tr = false;
	    
	     for(int i=0; i<str.length; i++) {
	    	 if(str[i].equals("X")) {
	    		 stack.push(i);
	    		 count++;
	    	 }else {
	    		 ans[i] = ".";
	    		 while(stack.size()>0) {
	    	    	 //System.out.println("count: "+count);
	    			 if(count > 4 && count%4 != 0 && count%2 == 0) {
	    				 //System.out.println("index: "+index);
	        			 //여기에 XXXX|XX 처리
	        			 //index%4+1거 만큼 루프 돌려서 pop
	        			 for(int j=count; j>count-(count%4); j--) {
	        				 ans[stack.pop()] = "B";
	        			 }
	        			 
	        			 while(stack.size()>0) {
	        				 ans[stack.pop()] = "A";
	        			 }
	        			 
	        		 }else if(count%4 == 0) {
	        			 ans[stack.pop()] = "A";
	        		 }else if(count < 4 && count%2 == 0) {
	        			 ans[stack.pop()] = "B";
	        		 }else {
	        			 answer = "-1";
	        			 tr = true;
	        			 break;
	        		 }
	    		 }
	    		 count=0;
	    	 }
	    	 if(tr) {
	    		 stack.clear();
	    		 break;
	    	 }
	     }
	    
	     while(stack.size()>0) {
	    	 //System.out.println("count: "+count);
			 if(count > 4 && count%4 != 0 && count%2 == 0) {
				 //System.out.println("index: "+index);
    			 //여기에 XXXX|XX 처리
    			 //index%4+1거 만큼 루프 돌려서 pop
    			 for(int j=count; j>count-(count%4); j--) {
    				 ans[stack.pop()] = "B";
    			 }
    			 
    			 while(stack.size()>0) {
    				 ans[stack.pop()] = "A";
    			 }
    			 
    		 }else if(count%4 == 0) {
    			 ans[stack.pop()] = "A";
    		 }else if(count < 4 && count%2 == 0) {
    			 ans[stack.pop()] = "B";
    		 }else {
    			 answer = "-1";
    			 tr = true;
    			 break;
    		 }
		 }
	    
	     //System.out.println(Arrays.toString(ans));
	     
	     if(!answer.equals("-1")) {
	    	 for(String s :ans) {
		    	 answer += s;
		     }
	     }
	     
	    
	     sb.append(answer);
	     bw.write(sb.toString()); // 최종 결과 출력
	     bw.flush();
	     bw.close();
	}
}