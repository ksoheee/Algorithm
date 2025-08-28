class Solution {
    public long solution(int w, int h) {
        long x = (long)w;
        long y = (long)h;
        long answer = 0;
        for(int i=1; i<w; i++){
            answer += y*i/x;
        }
        return answer*2;
    }
}
