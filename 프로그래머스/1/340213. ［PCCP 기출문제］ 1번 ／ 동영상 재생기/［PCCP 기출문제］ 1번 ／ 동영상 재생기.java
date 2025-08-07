class Solution {
    public String solution(String video_len, String position, String op_start, String op_end, String[] commands) {
        int s = Integer.parseInt(video_len.split(":")[0])*60+ Integer.parseInt(video_len.split(":")[1]);
        int pos = Integer.parseInt(position.split(":")[0])*60+ Integer.parseInt(position.split(":")[1]);
        int ops = Integer.parseInt(op_start.split(":")[0])*60+ Integer.parseInt(op_start.split(":")[1]);
        int ope = Integer.parseInt(op_end.split(":")[0])*60+ Integer.parseInt(op_end.split(":")[1]);
        
        //오프닝 체크
        if(ops<= pos && pos<=ope){
            pos=ope;
        }
        for(String command: commands){
            if(command.equals("prev")){
                if(pos<10)  pos=0;
                else        pos-=10;
            }else{
                if(s-pos<10)    pos=s;
                else            pos+=10;
            }
                    if(ops<= pos && pos<=ope){
            pos=ope;
        }
        }

        return String.format("%02d:%02d",pos/60,pos%60);
    }       
}