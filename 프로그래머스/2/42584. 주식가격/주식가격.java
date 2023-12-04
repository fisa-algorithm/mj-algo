import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<Integer[]>();
       
        for(int i=0; i<prices.length; i++){
            Integer[] info = {prices[i],i};
            
            while(stack.size()!=0 && stack.peek()[0] > prices[i]){
                //온도 떨어짐
                answer[stack.peek()[1]] = i-stack.peek()[1];
                //System.out.println(i-1+"번째,"+(i-stack.peek()[1]));
                stack.pop();
               
            }
            stack.push(info);
        }
        for(int i=0; i<answer.length-1; i++){
            if(answer[i]==0){
                answer[i] = prices.length-i-1;
            }
        }
        
        return answer;
    }
}