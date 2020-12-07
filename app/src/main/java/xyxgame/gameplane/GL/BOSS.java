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

    public void setmX(int mX) {
        this.mX = mX;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }

    int mX,mY;
    int MoveX1,MoveX2;
    Rect rect;

    ArrayList<Bitmap> bitmaps;
    private  int times=10;



    GameSurfaceView gameSurfaceView;

    public BOSS(GameSurfaceView gameSurfaceView,Point point) {
        this.gameSurfaceView=gameSurfaceView;
        this.bitmap = gameSurfaceView.getBtmap().getBitmaps().get(12);
        bitmap=Bitmap.createScaledBitmap(bitmap,500*times,500,false);
        this.mX=point.x;
        this.mY=point.y;
        rect=new Rect(mX,mY,mX+bitmap.getWidth(),mY+bitmap.getHeight());

          try {
              bitmaps=new ArrayList<>();
              for (int i = 0; i < times; i++) {
                  Bitmap bitmap1 = Bitmap.createBitmap(this.bitmap,this. bitmap.getWidth() * i / times, 0,
                          this.bitmap.getWidth() / times, this.bitmap.getHeight());
//                  bitmaps.add( Bitmap.createScaledBitmap(bitmap1,bitmap1.getWidth(),bitmap1.getHeight(),false));
                  bitmaps.add(bitmap1);
              }

          }finally {
              bitmap.recycle();
              bitmap=null;

             }


    }


    //run=循环读取，
    //j定时回收
    int run=0;int j=0,m=5;


    public boolean isIsover() {
        return isover;
    }

    public void setIsover(boolean isover) {
        this.isover = isover;
    }

    private boolean isover=false;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public  void draw(Canvas canvas) {

        if (gameSurfaceView.ismIsRun()) {
            if (gameSurfaceView.isBossboo()) {
                run = run % times;
                Iterator<Bitmap> bitmapIterator = bitmaps.iterator();
            if (j<=times*m*5) {j++;}
            if (j > times*m*5) {j = 0; setIsover(true);run=0;}
//                mY-=2;
//                if (mY<=0)mY=2000;
//            }
                // if (j>times*m*10){//这个帧动画循环了10次播放量所以*10

//                while (bitmapIterator.hasNext()){
//                    bitmapIterator.next().recycle();
//                    bitmapIterator.remove();
//                 }

                //   }

                if (bitmaps != null && bitmapIterator.hasNext() && !bitmaps.get(run).isRecycled()) {
                    canvas.drawBitmap(bitmaps.get(run), mX, mY, new Paint());
                }


                if (j % m == 0) run++;//每间隔m循环才去刷新帧动画


            }
        }
    }

    public void resetXY( Point point) {
        mX=point.x;
        mY=point.y;
    }
}



