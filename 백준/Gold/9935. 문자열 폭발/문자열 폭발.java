import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        int boomLen = boom.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            sb.append(str.charAt(i));

            if(sb.length()>=boomLen){
                boolean isBoom = true;
                for(int j=0; j<boomLen; j++){
                    if(sb.charAt(sb.length()-boomLen+j) != boom.charAt(j)){
                        isBoom = false;
                        break;
                    }
                }
                if(isBoom){
                    sb.delete(sb.length()-boomLen,sb.length());
                }
            }
        }
        if(sb.length()==0)  System.out.println("FRULA");
        else                System.out.println(sb);
    }
}
