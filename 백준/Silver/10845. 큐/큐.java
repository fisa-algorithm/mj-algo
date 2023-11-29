import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int n = Integer.parseInt(st.nextToken());
	    
	    ArrayList<String> method = new ArrayList<String>();
	    
        String line;
        
        for(int i=1; i<=n; i++) {
        	line = br.readLine();
        //while ((line = br.readLine()) != null) {
            if(line.equals("back")) {
            	if(method.size()==0) {
            		System.out.println(-1);
            	}else {
            		System.out.println(method.get(method.size()-1));
            	}	
            }else if(line.equals("front")) {
            	if(method.size()==0) {
            		System.out.println(-1);
            	}else {
            		System.out.println(method.get(0));
            	}	
            }else if(line.equals("pop")) {
            	if(method.size()==0) {
            		System.out.println(-1);
            	}else {
            		System.out.println(method.get(0));
            		method.remove(0);
            	}
            }else if(line.equals("size")) {
            	System.out.println(method.size());
            }else if(line.equals("empty")) {
            	if(method.size()==0) {
            		System.out.println(1);
            	}else {
            		System.out.println(0);
            	}
            }else {
            	method.add(line.substring(5));
            }
        }
        br.close();
	}

}