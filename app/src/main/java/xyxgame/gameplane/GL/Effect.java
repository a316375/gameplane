package xyxgame.gameplane.GL;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Effect {
   public ArrayList<Bitmap> bitmaps;//传入一张Bitmap

    Point point;//一个坐标点
    int mX,mY;

    public Effect(ArrayList<Bitmap> bitmaps,  Point point) {
        this.bitmaps = bitmaps;

        this.point=point;
        this.mX=point.x;
        this.mY=point.y;




    }



       //run=循环读取，
        //j定时回收
        int run=0,j=0;

        public  void draw(Canvas canvas){

            run=run%10;

             if (j<=30)
                j++;
            if (j>30){j=0;
//            mX=new Random().nextInt(1000);
//            mY=new Random().nextInt(1500);
            }

            if (bitmaps!=null&&!bitmaps.get(run).isRecycled() ){
                canvas.drawBitmap(bitmaps.get(run),mX,mY,new Paint());
            }
            if (j%3==0)     run++;


        }




}
