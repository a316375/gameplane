package xyxgame.gameplane.GIf_v1;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.concurrent.CopyOnWriteArrayList;


//**玩家的类，不需要实现抽象方法**//
public class GIFPlay extends BaseGIFObject {

    Bitmaps bitmapsS;
    CopyOnWriteArrayList<Bitmap> fblist;
    public GIFPlay(CopyOnWriteArrayList<Bitmap> bitmaps, int x, int y, int time, Bitmaps bitmapsS) {
        super(bitmaps, x, y, time);
        this.bitmapsS=bitmapsS;
        fblist =bitmapsS.getfb03(bitmapsS.activity);
        mMaxX=bitmapsS.activity.point.x-200;
        mMaxY=bitmapsS.activity.point.y-200;

    }




    int i=0;int j=0;
    @Override
    public void drawBG(Canvas canvas) {
        super.drawBG(canvas);

        if (fblist.size()==0)return;
        j++;
        i=i% fblist.size();
        canvas.drawBitmap(fblist.get(i),xX-60,xY-20,null);
       if (j%5==0)i++;
       if (j>=500)j=0;




    }

   int mMinX=-20,mMinY=200,mMaxX,mMaxY;
    @Override
    public void moveToXY(int pointXFix, int pointYFix) {
        super.moveToXY(pointXFix, pointYFix);
        if (xX<mMinX)xX=mMinX;
        if (xY<mMinY)xY=mMinY;
        if (xX>mMaxX)xX=mMaxX;
        if (xY>mMaxY)xY=mMaxY;
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
