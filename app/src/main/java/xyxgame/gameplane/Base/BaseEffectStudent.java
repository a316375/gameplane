package xyxgame.gameplane.Base;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BaseEffectStudent extends BaseStudent {

    public ArrayList<Bitmap> bitmaps;//传入一堆Bitmap
    public   Point point;//一个坐标点
    public  int mX,mY;

    public boolean bitmaps_is_over=false;
    public BaseEffectStudent(BaseBag baseBag,ArrayList<Bitmap> bitmaps, Point point) {
        super(baseBag);
        this.bitmaps = bitmaps;

        this.point=point;
        this.mX=point.x;
        this.mY=point.y;


    }



       //run=循环读取，
        //j定时回收
        int run=0,j=0;


    @Override
    public  void draw(Canvas canvas){

            run=run%10;

             if (j<30)
             {
                 j++;
                 if (bitmaps!=null&&!bitmaps.get(run).isRecycled() ){
                        canvas.drawBitmap(bitmaps.get(run),mX,mY,new Paint());
                        }
        }
            if (j>=30){j=0;
//            mX=new Random().nextInt(1000);
//            mY=new Random().nextInt(1500);
//                Iterator<Bitmap> iterator = bitmaps.iterator();
//                while (iterator.hasNext()){
//                    iterator.next().recycle();
//                }
                bitmaps=null;
                bitmaps_is_over=true;
            }


            if (j%3==0)     run++;


        }

    @Override
    public void drawXP() {

    }


}
