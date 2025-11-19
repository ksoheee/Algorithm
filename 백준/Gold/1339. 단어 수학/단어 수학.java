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
        HashMap<Character, Integer> map = new HashMap<>();
        int value = 1;
        for(int i=0;i<n;i++){
            for(int j=arr[i].length()-1; j>=0;j--){
                map.put(arr[i].charAt(j),map.getOrDefault(arr[i].charAt(j),0) +value);
                value *= 10;
            }
            value = 1;
        }
        //가중치만 리스트로 뽑고 정렬
        List<Integer> list = new ArrayList<>();
        for(Integer i : map.values()){
            list.add(i);
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