import java.util.*;
import java.io.*;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd){
                case "push":
                    int num = Integer.parseInt(st.nextToken()); 
                    q.offer(num);
                    break;
                case "pop":
                    Integer num2 = q.poll();
                    if(num2==null) sb.append(-1+"\n");
                    else     sb.append(num2+"\n");
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1+"\n");
                    else            sb.append(0+"\n");
                    break;
                case "front":
                    Integer num3= q.peek();
                    if(num3==null) sb.append(-1+"\n");
                    else            sb.append(num3+"\n");
                    break;
               case "back":
                    Integer num4= q.peekLast();
                    if(num4==null) sb.append(-1+"\n");
                    else            sb.append(num4+"\n");
                    break;                   
            }            
        }System.out.println(sb);
    }
}