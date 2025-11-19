import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }

        //가중치 계산
        int[] weight = new int[26];
        for(int i=0; i<n; i++){
            String word = arr[i];
            int length = word.length();
            int value = 1;
            for(int j=length-1; j>=0; j--){
                char ch = word.charAt(j);
                int idx = ch - 'A';
                weight[idx] += value;
                value *= 10;
            }
        }
        //가중치만 리스트로 뽑고 정렬
        List<Integer> list = new ArrayList<>();
        for(int i : weight){
            if(i>0) list.add(i);
        }
        Collections.sort(list, Collections.reverseOrder());
        int num = 9;
        int answer = 0;
        for(Integer i : list){
            answer += num * i;
            num--;
        }
        System.out.println(answer);

    }

}