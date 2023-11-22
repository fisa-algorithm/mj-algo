class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        //시간초과
        // long r2Num = 0;
        // for(long i=1;i<=r2;i++){
        //     for(long j=1;j<=r2;j++){
        //         if(Math.pow(i,2)+Math.pow(j,2)>=Math.pow(r1,2) && Math.pow(i,2)+Math.pow(j,2)<=Math.pow(r2,2)){
        //             //내부에 있는 점(i,j)
        //             r2Num++;
        //         }
        //     }
        // }
        //4  2 4,3,2
        //x^2+y^2<=r^2
        //시간복잡도 줄이기
        for(int i=1;i<r2;i++){
            double r2Num = Math.floor(Math.sqrt(Math.pow(r2,2)-Math.pow(i,2)));
            double r1Num = Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(i,2)));
            if(i>=r1){
                r1Num = 0;
                answer += r2Num - r1Num;
            }else{
                answer += r2Num - r1Num + 1;
            }
            
            //System.out.println(r2Num);
            //System.out.println(r1Num);
        }
        //System.out.println(answer);
        answer = answer*4;
        answer += (r2-r1+1)*4;
        return answer;
    }
}
//2+4+