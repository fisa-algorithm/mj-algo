class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String a = "";
        int num_p = 0;
        int num_y = 0;
        for(int i=0; i<s.length(); i++){
            a = s.substring(i,i+1);
            if(a.equals("p") || a.equals("P")){
                num_p++;
            }else if(a.equals("y") || a.equals("Y")){
                num_y++;
            }
        }
        
        if(num_p != num_y){
            answer = false;
        }
        
        return answer;
    }
}