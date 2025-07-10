import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
       
        //조건에 따라 다르게 쓰일 두개의 HashMap
        HashMap<Integer, String> hash1 = new HashMap<Integer,String>();
        HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
      
        for(int i=1; i<=n; i++){//포켓몬 도감 입력
            String po = br.readLine();
            hash1.put(i,po);
            hash2.put(po,i);
        }
         StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String test=br.readLine();
            //입력 값이 번호인지 포켓몬 이름인지 
           if(49<=test.charAt(0) && test.charAt(0)<=57){
               sb.append(hash1.get(Integer.parseInt(test))).append("\n");
           }else{
               sb.append(hash2.get(test)).append("\n");
           }
        }System.out.println(sb);
    }
}