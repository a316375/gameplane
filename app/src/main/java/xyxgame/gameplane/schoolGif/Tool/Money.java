package xyxgame.gameplane.schoolGif.Tool;

import java.text.DecimalFormat;

public class Money {

    public int all;
    public int a=0;
    public int b=0;

    public int returnA(){
        if (all<0)return 0;



        if (all>99999999)all=99999999;

        a=all%10000;
        return a;
    }
    public int returnB(){

        if (all<0)return 0;


        if (all>99999999)all=99999999;
        b=all%100000000/10000;
//        b=all%99999999/9999;

        return b;
    }

    public int maxall=99999999;
    public Money(int all) {
        if (all>99999999)all=99999999;
        this.all = all;

    }



    public String stringA(){
        DecimalFormat df=new DecimalFormat("0000");

        return  df.format(returnA());
    }
    public String stringB(){
        DecimalFormat df=new DecimalFormat("0000");

        return  df.format(returnB());

   // return returnB()+"";
    }
}
