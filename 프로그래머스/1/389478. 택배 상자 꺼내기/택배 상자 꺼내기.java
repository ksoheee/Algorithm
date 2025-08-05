
class Solution {
    public int solution(int n, int w, int num) {    
        //전체
        int nf= getF(n-1,w);
        int nIndex=getIndex(n-1,w,nf);//마지막층 
        
        int numf=getF(num-1,w);
        int numIndex=getIndex(num-1,w,numf);
        int cnt = nf-numf;
        if(nf%2==0){
            cnt += numIndex<=nIndex? 1:0;
        }else{
            cnt += numIndex>=nIndex? 1:0;
        }
        
        return cnt;
    }
    private int getF(int n, int w){
        return n/w;
    }
    private int getIndex(int n, int w, int f){
        if(f%2==0){
            return n%w;
        }else{
            return (w-1)-n%w;
        }
    }
}