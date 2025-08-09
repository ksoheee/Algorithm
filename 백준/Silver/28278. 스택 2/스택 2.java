import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        int num1; int num2;
        for(int i=0; i<n; i++){
            num1= sc.nextInt();
            switch(num1){
                case 1:
                    num2 = sc.nextInt();
                    stack.push(num2);
                    break;
                case 2:
                    if(stack.isEmpty())  sb.append(-1+"\n");
                    else                 sb.append(stack.pop()+"\n");
                    break;
                case 3:
                    sb.append(stack.size()+"\n");
                    break;
                case 4:
                    if(stack.isEmpty()) sb.append(1+"\n");
                    else                sb.append(0+"\n");
                    break;
                case 5:
                    if(stack.isEmpty()) sb.append(-1+"\n");
                    else                sb.append(stack.peek()+"\n");
                    break;                    
            }
        }
        System.out.println(sb);
    }
}