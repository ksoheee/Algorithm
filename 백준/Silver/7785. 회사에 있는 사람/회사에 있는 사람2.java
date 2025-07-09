//BufferedReader + StringTokenizer
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);       
        int n= sc.nextInt();sc.nextLine();
        Map<String,String> map = new HashMap<>();
        for(int i=0; i<n; i++){           
            String name=sc.next();
            String state=sc.next();          
            
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
