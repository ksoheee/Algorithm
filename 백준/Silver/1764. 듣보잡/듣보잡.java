import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(br.readLine(),i);
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(int i=0; i<m; i++){
            String nh= br.readLine();
            if(map.containsKey(nh)){
                cnt++;
                list.add(nh);
                
            }
        }
        Collections.sort(list);
         System.out.println(cnt);
        for(String name : list){
            sb.append(name).append('\n');
        }
        System.out.print(sb);
    }
}