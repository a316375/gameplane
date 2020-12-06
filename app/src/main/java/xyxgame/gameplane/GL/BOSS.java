package xyxgame.gameplane.GL;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import xyxgame.gameplane.spaceshooter.Laser;

public class BOSS    {

    Bitmap bitmap;
    int mX,mY;
    int MoveX1,MoveX2;
    Rect rect;

    ArrayList<Bitmap> bitmaps;
    private  int times=5;





    public BOSS(BTMAP btmap,Point point) {
        this.bitmap = btmap.getBitmaps().get(10);
        bitmap=Bitmap.createScaledBitmap(bitmap,400*times,400,false);
        this.mX=point.x;
        this.mY=point.y;
        rect=new Rect(mX,mY,mX+bitmap.getWidth(),mY+bitmap.getHeight());


        bitmaps=new ArrayList<>();
        for (int i = 0; i < times; i++) {
            Bitmap bitmap1 = Bitmap.createBitmap(this.bitmap,this. bitmap.getWidth() * i / times, 0,
                    this.bitmap.getWidth() / times, this.bitmap.getHeight());
             bitmaps.add( Bitmap.createScaledBitmap(bitmap1,bitmap1.getWidth(),bitmap1.getHeight(),false));
        }

    }


    //run=循环读取，
    //j定时回收
    int run=0,j=0;

    public  void draw(Canvas canvas){

           run=run%times;
            Iterator<Bitmap> bitmapIterator=bitmaps.iterator();
            if (j<=times*200) j++;
            if (j>times*200){

                while (bitmapIterator.hasNext()){
                    bitmapIterator.next().recycle();
                    bitmapIterator.remove();
                 }

            }

            if (bitmaps!=null&&bitmapIterator.hasNext()&&!bitmaps.get(run).isRecycled() ){
                canvas.drawBitmap(bitmaps.get(run),mX,mY,new Paint());
            }

        if (j%10==0)   run++;


      }




}



