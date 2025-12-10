import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        int len = cmd.length;
        
        //삭제된 행을 저장할 스택
        Deque<Integer> saveDelete = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            result.add("O");
        }
        //현재 위치
        int idx = k; int r = n;
        
        for(int i=0; i<len; i++){
            String tmp = cmd[i];
            //1글자일때
            if(tmp.length()==1){
               if(tmp.equals("Z")){
                   //스택에서 불러오고 행 길이 늘림
                   int d = saveDelete.pop();
                   if(idx>=d) idx++;
                   r++;
               }else if(tmp.equals("C")){
                   //삭제한 행위위치 저장
                   saveDelete.push(idx);
                   r--;
                   //삭제하면 전체 길이 -1
                   //만약에 삭제 하고나서 길이를 줄였는데 인덱스가 길이와 같아지면 현재인덱스-1
                   if(idx==r) idx--;
               }
            }else{
                String[] arr = tmp.split(" ");
                if(arr[0].equals("U")){
                    idx -= Integer.parseInt(arr[1]);
                    if(idx<0) idx = 0;
                }else if(arr[0].equals("D")){
                    idx += Integer.parseInt(arr[1]);
                    if(idx>r-1) idx = r-1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r; i++){
            sb.append("O");
        }
        while(!saveDelete.isEmpty()){//삭제된게 있으면
            sb.insert(saveDelete.pop(),"X");
        }
        return sb.toString();
    }
    
}
