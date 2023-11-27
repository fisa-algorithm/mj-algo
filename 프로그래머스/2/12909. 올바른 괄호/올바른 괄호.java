import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(")");
            }else{
                if(!stack.empty()){
                    stack.pop();
                }else{
                    return false;
                } 
            }
        }
        if(!stack.empty()){
            return false;
        }
        return answer;
    }
}