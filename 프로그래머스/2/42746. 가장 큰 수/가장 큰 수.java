import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            str[i]=String.valueOf(numbers[i]);
        }
        
        //내림차순 정렬
        Arrays.sort(str, (a,b)-> (b+a).compareTo(a+b));
        
        //가장 큰 수가 0인경우
        if(str[0].equals("0")) return "0";
           
        StringBuilder sb = new StringBuilder();
        for(String s: str)  sb.append(s);
        return sb.toString();
    }
}