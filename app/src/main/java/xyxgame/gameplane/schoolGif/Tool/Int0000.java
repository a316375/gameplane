package xyxgame.gameplane.schoolGif.Tool;

import java.text.DecimalFormat;

public class Int0000 {
    public static String get0000(int i){
        DecimalFormat df=new DecimalFormat("0000");
        return df.format(i);
    }
    public static String get00(int i){
        DecimalFormat df=new DecimalFormat("00");
        return df.format(i);
    }
}
