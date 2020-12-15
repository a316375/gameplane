package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.concurrent.CopyOnWriteArrayList;


//**玩家的类，不需要实现抽象方法**//
public class GIFPlay extends BaseGIFObject   {

    Bitmaps bitmapsS;
    CopyOnWriteArrayList<Bitmap> bitmapCopyOnWriteArrayList;
    public GIFPlay(CopyOnWriteArrayList<Bitmap> bitmaps, int x, int y, int time, Bitmaps bitmapsS) {
        super(bitmaps, x, y, time);
        this.bitmapsS=bitmapsS;
        bitmapCopyOnWriteArrayList=bitmapsS.getplay_bg(bitmapsS.activity);

    }


    int i=0;int j=0;
    @Override
    public void drawBG(Canvas canvas) {
        super.drawBG(canvas);

        if (bitmapCopyOnWriteArrayList.size()==0)return;
        j++;
        i=i%bitmapCopyOnWriteArrayList.size();
        canvas.drawBitmap(bitmapCopyOnWriteArrayList.get(i),xX-60,xY-20,null);
       if (j%5==0)i++;
       if (j>=500)j=0;
    }

    @Override
    void drawPath(Canvas canvas) {

    }



    public  void upbitmaps(int i){

//        if (i==1){bitmaps=bitmapsS.getyu1(bitmapsS.activity);}
//        if (i==2){bitmaps=bitmapsS.getyu2(bitmapsS.activity);}
//        if (i==3){bitmaps=bitmapsS.getyu3(bitmapsS.activity);}
//        if (i==4){bitmaps=bitmapsS.getyu4(bitmapsS.activity);}
//        if (i==5){bitmaps=bitmapsS.getyu5(bitmapsS.activity);}
//        if (i==6){bitmaps=bitmapsS.getyu6(bitmapsS.activity);}
//        if (i==7){bitmaps=bitmapsS.getyu7(bitmapsS.activity);}
//        if (i==8){bitmaps=bitmapsS.getyu8(bitmapsS.activity);}
//        if (i==9){bitmaps=bitmapsS.getyu9(bitmapsS.activity);}



    };



















}
