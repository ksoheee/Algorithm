class Solution {
    public long solution(int w, int h) {
        long totalBox = (long)w*(long)h;        
        
        return totalBox - (w+h - gcd(w,h));
    }
    public long gcd(int w, int h){

        if(h==0) return w;
        return gcd(h,w%h);
    }
    
}