import java.util.*;
import java.io.*;
public class Main {
    //main함수와 check함수에서도 BufferedReader를 사용하니 전역변수로 static으로 선언
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
        int N = Integer.parseInt(br.readLine());
        
        int cnt =0; 
        for(int i=0; i< N; i++){
            if(groupCheck()==true){
                cnt++;
            }      
        }
        System.out.println(cnt);
    }
    public static boolean groupCheck() throws IOException {
        boolean[] alp = new boolean[26]; 
        int prev = 0; //이전 값
        
        String str = br.readLine();
        
        for(int j=0; j<str.length(); j++){
            int now = str.charAt(j);
            
            if(prev != now){  //이전 문자와 현재 문자가 다르다면 
                if(alp[now-'a']==false){  //처음 문자가 나왔다면 
                    alp[now-'a']=true;  //true로 변경
                    prev = now;         //이전값을 현재 값으로 
                }else{//문자가 다른데, 처음 나왔던 문자가 아니라면 그룹문자가 아니므로 return
                    return false;
                }
            }
            else{                        //이전 문자와 같다면
                continue;
            }
            
        }
        return true;
    }
}
	