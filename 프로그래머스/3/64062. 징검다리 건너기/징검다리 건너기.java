class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        for(int i=0; i<stones.length; i++){
            right = Math.max(right, stones[i]);
        }
        
        while(left<=right){
            int mid = (left+ right)/2;
            if(stepStone(stones, mid, k)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }
    public boolean stepStone(int[] stones, int mid, int k){
        int stone=0;
        for(int s: stones){
            if(s<mid) stone++;
            else stone=0;
            
            if(stone>=k) return false;
        }
        return true;
    }
}