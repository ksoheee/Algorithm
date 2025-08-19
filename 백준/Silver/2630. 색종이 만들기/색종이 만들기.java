import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] paper;
    public static int bcnt=0;
    public static int wcnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fun(N,0,0);
        System.out.println(wcnt);
        System.out.println(bcnt);
    }
    public static void fun(int v, int row, int col){
        int value = paper[row][col];
        if(colorCheck(v,row,col)){
            if(value == 0){
                wcnt++;
            }
            else{
                bcnt++;
            }
            return;
        }
        int size =v/2;
        //4분할
        fun(size,row,col);                      //2사분면
        fun(size,row,col+size);                 //1
        fun(size,row+size, col);                //3
        fun(size,row+size, col+size);           //4
        
    }
    public static boolean colorCheck(int v, int row, int col){
        int value = paper[row][col];
        for(int i=row; i<v+row; i++){
            for(int j=col; j<v+col; j++){
                if(paper[i][j]!=value) return false;
            }
        }
        return true;
    }
}