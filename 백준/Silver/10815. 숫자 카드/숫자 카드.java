import java.io.*;
import java.sql.Array;
import java.util.*;import java.util.Scanner;
public class Main{
    static int N,M; //다른 함수에서도 쓰기 위해
    static int[] Array1; //다른 함수에서 카드 요소 배교하기 위해
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        Array1 = new int[N];

        //한번에 한 줄 전체를 문자열로 읽어옴
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Array1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Array1);
        M=Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            //해당 비교 배열 요소들을 저장하지 않아도 됨 0,1만 필요하므로
            int num= Integer.parseInt(st.nextToken());
            bw.write(BinarySearch(num)+" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    public static int BinarySearch(int num){
        int left=0;
        int right =N-1; //배열의 요소는 0부터 시작하므로 N-1
        int mid=0;
        while(left<=right){ //이진 탐색 규칙 어긋나면 반복문x
            mid=(left+right)/2;
            if(Array1[mid]>num){
                right=mid-1;
            }else if(Array1[mid]<num){
                left=mid+1;
            }else if(Array1[mid]==num){
                return 1;
            }
        }return 0;
    }
}