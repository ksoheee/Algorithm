import java.util.*;
import java.io.*;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch(cmd){
                case 1:
                    int numf = Integer.parseInt(st.nextToken()); 
                    dq.offerFirst(numf);
                    break;
               case 2:
                    int numl = Integer.parseInt(st.nextToken()); 
                    dq.offerLast(numl);
                    break;
                case 3:
                    Integer numfg = dq.pollFirst();
                    if(numfg==null) sb.append(-1+"\n");
                    else     sb.append(numfg+"\n");
                    break;
                case 4:
                    Integer numlg = dq.pollLast();
                    if(numlg==null) sb.append(-1+"\n");
                    else     sb.append(numlg+"\n");
                    break;
                case 5:
                    sb.append(dq.size()+"\n");
                    break;
                case 6:
                    if(dq.isEmpty()) sb.append(1+"\n");
                    else            sb.append(0+"\n");
                    break;
                case 7:
                    Integer numpf= dq.peekFirst();
                    if(numpf==null) sb.append(-1+"\n");
                    else            sb.append(numpf+"\n");
                    break;
               case 8:
                    Integer numfl= dq.peekLast();
                    if(numfl==null) sb.append(-1+"\n");
                    else            sb.append(numfl+"\n");
                    break;                   
            }            
        }System.out.println(sb);
    }
}