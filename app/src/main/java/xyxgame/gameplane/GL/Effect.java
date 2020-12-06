package xyxgame.gameplane.GL;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Iterator;

public class Effect {
    Bitmap bitmap;//传入一张Bitmap
    int times;//输入这张Bitmap的分割频数
    Point point;//一个坐标点
    int mX,mY;

    public Effect(Bitmap bitmap, int times, Point point) {
        this.bitmap = bitmap;
        this.times=times;
        this.point=point;
        this.mX=point.x;
        this.mY=point.y;


        bitmaps=new ArrayList<>();
        for (int i = 0; i < times; i++) {
            //横向算法
            Bitmap bitmap1 = Bitmap.createBitmap(this.bitmap,this. bitmap.getWidth() * i / times, 0,
                    this.bitmap.getWidth() / times, this.bitmap.getHeight());
            bitmaps.add( Bitmap.createScaledBitmap(bitmap1,bitmap1.getWidth(),bitmap1.getHeight(),false));
        }
    }

    ArrayList<Bitmap> bitmaps;//开辟一个临时的集合

       //run=循环读取，
        //j定时回收
        int run=0,j=0;

        public  void draw(Canvas canvas){

            run=run%times;
            Iterator<Bitmap> bitmapIterator=bitmaps.iterator();
            if (j<=100) j++;
            if (j>100){

                while (bitmapIterator.hasNext()){
                    bitmapIterator.next().recycle();
                    bitmapIterator.remove();
                }

            }

            if (bitmaps!=null&&bitmapIterator.hasNext()&&!bitmaps.get(run).isRecycled() ){
                canvas.drawBitmap(bitmaps.get(run),mX,mY,new Paint());
            }
            if (j%10==0)     run++;


        }




}
