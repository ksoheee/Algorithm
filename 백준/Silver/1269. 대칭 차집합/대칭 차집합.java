import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
             set1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
             set2.add(Integer.parseInt(st.nextToken()));
        }
        int cnt=0;
        for(int num : set1){
            if(!set2.contains(num)) cnt++;
        }
        for(int num : set2){
            if(!set1.contains(num)) cnt++;
        }
        System.out.println(cnt);
    }
}