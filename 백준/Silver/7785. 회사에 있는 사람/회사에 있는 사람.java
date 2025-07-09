import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String,String> map = new HashMap<String,String>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
                   
            String name = st.nextToken();
            String state = st.nextToken();
            if(map.containsKey(name)){
                map.remove(name);
            }else{
                map.put(name,state);
            }
        }
        ArrayList<String> arr = new ArrayList<String>(map.keySet());
        Collections.sort(arr, Collections.reverseOrder());
        for(var a:arr){
            System.out.println(a+" ");
        }
    }
}