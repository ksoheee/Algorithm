class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int posM=getM(pos);
        int posS=getS(pos);
        
        int opStartM=getM(op_start);
        int opStartS=getS(op_start);
        
        int opEndM=getM(op_end);
        int opEndS=getS(op_end);
        
        int lenM=getM(video_len);
        int lenS=getS(video_len);
        
        int[] result = opCheck(posM, posS, opStartM, opStartS, opEndM, opEndS);
        posM = result[0];
        posS = result[1];
        
        int sec=0;
        for(String command: commands){
            int[] checkedBefore = opCheck(posM, posS, opStartM, opStartS, opEndM, opEndS);
            posM = checkedBefore[0];
            posS = checkedBefore[1];
            sec=(posM*60)+posS;
            if(command.equals("prev")){
                if(sec<=10){
                    posM=0; posS=0;
                }else{
                    sec -=10;
                    if (sec < 0){
                        posM=0; posS=0;
                    }
                    else{
                        posM=sec/60;
                        posS=sec%60;
                    }

                }
            }else{
                int totalLenSec = lenM * 60 + lenS;
                if (sec > totalLenSec) sec = totalLenSec;
                else{
                    sec +=10;
                    if (sec > lenM * 60 + lenS){
                        posM=lenM; posS=lenS;
                    }else{
                        posM=sec/60;
                        posS=sec%60;
                    }
                }   

                }
            
                int[] checkedAfter = opCheck(posM, posS, opStartM, opStartS, opEndM, opEndS);
                posM = checkedAfter[0];
                posS = checkedAfter[1];
            
        }

        String posMstr;
        String posSstr;
        if(posM<10) posMstr="0"+String.valueOf(posM);
        else        posMstr=String.valueOf(posM);
        if(posS<10) posSstr="0"+String.valueOf(posS);
        else        posSstr=String.valueOf(posS);

        return posMstr+":"+posSstr;
    }
    private int getM(String str){
        return (str.charAt(0)-'0')*10+(str.charAt(1)-'0');
    }
    private int getS(String str){
        return (str.charAt(3)-'0')*10+(str.charAt(4)-'0');
    }
    private int[] opCheck(int posM, int posS, int opStartM, int opStartS, int opEndM, int opEndS) {
    int posSec = posM * 60 + posS;
    int opStartSec = opStartM * 60 + opStartS;
    int opEndSec = opEndM * 60 + opEndS;

    if (posSec >= opStartSec && posSec <= opEndSec) {
        posM = opEndM;
        posS = opEndS;
    }
    return new int[]{posM, posS};
    }
}