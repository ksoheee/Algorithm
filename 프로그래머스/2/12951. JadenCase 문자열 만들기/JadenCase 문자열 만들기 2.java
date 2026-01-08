class Solution {
    public String solution(String s) {
        int len = s.length();
        boolean isStart = true;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            
            if(ch==' '){
                isStart = true;
                sb.append(String.valueOf(ch));
            }
            else{
                String str = String.valueOf(ch);
                if(isStart){
                    sb.append(str.toUpperCase());
                    isStart = false;
                }     
                else   sb.append(str.toLowerCase());
            }
        }
        return sb.toString();
    }
}
