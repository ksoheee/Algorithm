class Solution {
    public String solution(int[] numbers, String hand) {
        int L= 10;
        int R=12;
        String answer="";
        
        for(int target: numbers){
            if(target ==0) target=11;
            
            if(target==1||target==4||target==7){
                answer+="L"; L=target; continue;
            }
            else if(target==3||target==6||target==9){
                answer+="R"; R=target; continue;
            }
            
            int leftMove=Math.abs(target-L)/3+Math.abs(target-L)%3;
            int rightMove=Math.abs(target-R)/3+Math.abs(target-R)%3;
            
            if(leftMove<rightMove){
                answer+="L"; L=target;
            }
            else if(leftMove>rightMove){
                answer+="R"; R=target;
            }
            else if(leftMove==rightMove){
                if(hand.equals("right")){
                    answer+="R"; R=target;
                }else{
                    answer+="L"; L=target;
                }
            }
        }
        return answer;
    }
    
}