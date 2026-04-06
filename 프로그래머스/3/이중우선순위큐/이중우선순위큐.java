import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        //오름차순 정렬
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        //내림차순
        PriorityQueue<Integer> pqDes = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations){
            String[] arr = s.split(" ");
            String cmd = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            //삽입
            if(cmd.equals("I")){
                pqAsc.offer(num);
                pqDes.offer(num);
                continue; 
            }
            //큐가 비어있으면 연산 무시
            else if(pqAsc.size()==0 && pqDes.size()==0) continue;
            //최소값 삭제
            else if(num==-1){
                int min =pqAsc.poll();
                pqDes.remove(min);
            }else if(num==1){
                int max = pqDes.poll();
                pqAsc.remove(max);
            }
            
        }
        
        if(pqAsc.size()==0 && pqDes.size()==0) return new int[]{0,0};
        else return new int[]{pqDes.poll(), pqAsc.poll()};
    }
}
