package xyxgame.gameplane.schoolGif.Tool;

import java.text.DecimalFormat;

public class Int0000 {
    public static String get0000(int i){
         DecimalFormat df=new DecimalFormat("0000");
        if (i>9999)df=new DecimalFormat(    "00000");
        if (i>99999)df=new DecimalFormat(   "000000");
        if (i>999999)df=new DecimalFormat(  "0000000");
        if (i>9999999)df=new DecimalFormat( "00000000");
        if (i>99999999)df=new DecimalFormat("000000000");
      return df.format(i);
    }
    public static String get00(int i){
        DecimalFormat df=new DecimalFormat("00");
        return df.format(i);
    }
}
