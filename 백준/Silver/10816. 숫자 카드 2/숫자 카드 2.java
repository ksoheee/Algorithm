//HashMap 2
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        
        int cnt=0;
        for(int i=0; i<n; i++){
            int num=Integer.parseInt(st.nextToken());
            //getOrDefault(key, defaultValue):key에 저장된 map에 저장된 value를 반환한다.
            //만약 없을 경우 defaultValue값을 반환한다. 
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int num=Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num,0)).append(" ");
        }System.out.print(sb);     
    }
}