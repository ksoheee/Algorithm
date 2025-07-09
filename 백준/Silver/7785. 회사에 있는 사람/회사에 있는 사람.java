import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        Map<String,String> map = new HashMap<>();
        for(int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String name=st.nextToken();
            String state=st.nextToken();
            
            if(map.containsKey(name)){
                map.remove(name);
            }else{
                map.put(name,state);
            }
        }
        ArrayList<String> arr= new ArrayList<>(map.keySet());
        arr.sort((o1,o2)->o2.compareTo(o1));
        for(String st: arr) System.out.println(st);
   
    }
}