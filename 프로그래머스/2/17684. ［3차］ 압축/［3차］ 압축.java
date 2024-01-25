import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        String[] arr = msg.split("");
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        HashMap<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);
        map.put("F",6);
        map.put("G",7);
        map.put("H",8);
        map.put("I",9);
        map.put("J",10);
        map.put("K",11);
        map.put("L",12);
        map.put("M",13);
        map.put("N",14);
        map.put("O",15);
        map.put("P",16);
        map.put("Q",17);
        map.put("R",18);
        map.put("S",19);
        map.put("T",20);
        map.put("U",21);
        map.put("V",22);
        map.put("W",23);
        map.put("X",24);
        map.put("Y",25);
        map.put("Z",26);
        
        int index = 27;  //추가할 값
        
        boolean flag = false;  //마지막 도달했는지
        
        //시작 인덱스
        for(int i=0; i<arr.length; i++){
        	String newString = arr[i];
            
        	for(int j=i+1; j<arr.length; j++) {
        		newString += arr[j]+"";
        		if(map.get(newString) == null) {
                    i=j-1;
        			answerList.add(map.get(newString.substring(0, newString.length()-1)));
        			map.put(newString, index);
        			index++;
        			break;
        		}
                if(map.get(newString) != null && j == arr.length-1){
                     flag = true;
                }
        	}
            
            
            if(i == arr.length-1){
                //한글자로 끝날 때 
                answerList.add(map.get(arr[i]));
                break;
            }else{
                if(flag){
                    //여러글자로 끝날 때
                    String last = arr[i];
                    for(int k=i+1; k<arr.length; k++){
                        last += arr[k];
                    }
                    answerList.add(map.get(last));
                    break;
                }
            }
        }
      
        return answerList;
    }
}