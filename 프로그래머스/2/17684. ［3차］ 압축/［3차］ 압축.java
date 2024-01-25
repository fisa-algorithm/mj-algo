import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        String[] arr = msg.split("");
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=1; i<27; i++){
            map.put(((char)(64+i))+"",i);  //알파벳 A~Z 넣기
        }
        
        int index = 27;  //추가할 값
        
        boolean flag = false;  //마지막 도달했는지
        
        //시작 인덱스
        for(int i=0; i<arr.length; i++){
        	String newString = arr[i];
            
        	for(int j=i+1; j<arr.length; j++) {
        		newString += arr[j]+"";
        		if(map.get(newString) == null) {
                    i=j-1;
        			answerList.add(map.get(newString.substring(0, newString.length()-1)));  //사전에 있는 단어의 index를 정답 배열에 add
        			map.put(newString, index);  //사전에 추가할 단어
        			index++;
        			break;
        		}
                if(map.get(newString) != null && j == arr.length-1){
                     flag = true;  //여러글자로 끝날 때
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