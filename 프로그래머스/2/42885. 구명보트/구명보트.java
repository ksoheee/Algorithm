import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        int left=0; int right=people.length-1;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }else if(people[left]+people[right]>limit){
                right--;
            }
            answer++;
        }
        return answer;
    }
}