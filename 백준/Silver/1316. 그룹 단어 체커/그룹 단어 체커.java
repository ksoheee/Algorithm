import java.util.*;
import java.io.*;
public class Main {
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
        int prev = 0;
        
        String str = br.readLine();
        
        for(int j=0; j<str.length(); j++){
            int now = str.charAt(j);
            
            if(prev != now){
                if(alp[now-'a']==false){
                    alp[now-'a']=true;
                    prev = now;
                }else{
                    return false;
                }
            }
            else{
                continue;
            }
            
        }
        return true;
    }
}
	