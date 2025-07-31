import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int cnt =0;
        for(int i=0; i<m; i++){
            String t=br.readLine();
            if(set.contains(t)){
                list.add(t);
                cnt++;
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for(int i=0; i<cnt; i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

}
