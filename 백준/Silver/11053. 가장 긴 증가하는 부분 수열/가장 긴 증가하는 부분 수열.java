import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        List<Integer> tails = new ArrayList<>();
        for(int x: arr){
            if(tails.isEmpty() || tails.get(tails.size()-1)<x)
                tails.add(x);
            else{
                int idx = lowerBound(tails, x);
                tails.set(idx, x);
            }
        }
        System.out.println(tails.size());
    }
    static int lowerBound(List<Integer> arr, int target){
        int left = 0;
        int right = arr.size();

        while(left<right){
            int mid = (left+right)/2;
            if(arr.get(mid)<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}