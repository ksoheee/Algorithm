import java.util.*;
class Solution {
    class File{
        String original;
        String head;
        int number;
        String tail;
        
        public File(String original){
            this.original = original;
            parse();
        }
        
        private void parse(){
            int i=0; 
            int len = original.length();
            
            //head: 숫자가 나오기 전까지
            while(i<len && !(0<=original.charAt(i)-'0' && original.charAt(i)-'0' <= 9)){
                i++;
            }
            head = original.substring(0, i);
            
            //number : 연속된 숫자
            int start = i;
            while(i<len && (0<=original.charAt(i)-'0' && original.charAt(i)-'0' <= 9)){
                i++;
            }
            number = Integer.parseInt(original.substring(start, i));
        }
            
    }
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        
        for(int i=0; i<files.length; i++){
            list.add(new File(files[i]));
        }
        
        Collections.sort(list, new Comparator<File>(){
            @Override
            public int compare(File o1, File o2){
                //대소문자 구분 없이 비교 
                int compareH = o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
                if(compareH != 0) return compareH;
                
                return o1.number - o2.number;
            }
        });
        
        String[] answer = new String[files.length];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).original;
        }
        
    
        return answer;
    }
}