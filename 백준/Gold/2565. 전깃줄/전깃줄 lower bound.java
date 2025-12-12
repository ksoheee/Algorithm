import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(arr, (o1, o2) -> o1[0]-o2[0]);

        List<Integer> tails = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(tails.isEmpty() || tails.get(tails.size()-1)<arr[i][1]){
                tails.add(arr[i][1]);
            }else{
                int idx = lowerBound(tails, arr[i][1]);
                tails.set(idx,arr[i][1]);
            }
        }
        System.out.print(n-tails.size());
    }
    static int lowerBound(List<Integer> arr, int t){
        int left = 0;
        int right = arr.size();

        while(left<right){
            int mid = (left+right)/2;
            if(arr.get(mid)<t){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
