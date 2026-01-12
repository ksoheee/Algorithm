import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<Integer, String> num = new HashMap<>();
        Map<String, Integer> word = new HashMap<>();
        
        //영어 -> 숫자로 바꾸면 됨
        char[] chr = s.toCharArray();
        StringBuilder sbword = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if('0'<= chr[i] && chr[i]<='9'){
                for(int j=0; j<10; j++){
                    if(sbword.toString().equals(english[j])){
                        sb.append(String.valueOf(j));
                        break;
                    }   
                }
                sbword = new StringBuilder();
                sb.append(chr[i]);
            } 
            else{
                boolean change = false;
                for(int j=0; j<10; j++){
                    if(sbword.toString().equals(english[j])){
                        sb.append(String.valueOf(j));
                        change = true;
                        break;
                    }   
                }
                if(change) sbword = new StringBuilder();
                sbword.append(chr[i]);
                //System.out.println(sbword.toString());
            }
        }
        for(int j=0; j<10; j++){
            if(sbword.toString().equals(english[j])){
                sb.append(String.valueOf(j));
                break;
            }   
        }
        
        return Integer.parseInt(sb.toString());
    }
}