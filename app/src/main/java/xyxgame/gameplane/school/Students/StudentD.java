package xyxgame.gameplane.school.Students;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.Random;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentD extends BaseStudent {


    int len;

    public StudentD(BaseBag baseBag) {
        super( baseBag);
        bitmap= Bitmap.createScaledBitmap(bitmap,150,150,false);
        mx_BaseStudent =new Random().nextInt(point.x-400)+200;
        my_BaseStudent =0;

        len=new Random().nextInt(baseBag.activity.point.y/2)+100;

    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }


    boolean beak=false;
    @Override
    public void drawXP() {

        if (beak==false)     my_BaseStudent +=2;
        if (my_BaseStudent >len)  beak=true;
        if (beak==true) my_BaseStudent-=new Random().nextInt(3)+1;




    }


}
