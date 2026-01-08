class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        
        int empty = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            
            if(ch==' '){
                empty++;
                sb.append(String.valueOf(ch));
            }
            //문자열의 첫 문자
            else if(empty!=0 && ch !=' '){
                String str = String.valueOf(ch);
                if('0'<= ch && ch <= '9')   sb.append(str);
                else                        sb.append(str.toUpperCase());
                empty=0;
            }
            else if(empty==0 && ch !=' '){
                String str = String.valueOf(ch);
                if('A'<= ch && ch<= 'Z')    sb.append(str.toLowerCase());
                else                        sb.append(str);
            }
        }
        return sb.toString();
    }
}