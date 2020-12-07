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



    int finish=1,unfinish=0;
    int lock=unfinish;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public  void draw(Canvas canvas) {


        if (gameSurfaceView.ismIsRun()) {

           if (gameSurfaceView.isBossboo()) {
               run = run % times;


           if ( bitmaps != null &&  !bitmaps.get(run).isRecycled())
           {
               if (lock==unfinish)canvas.drawBitmap(bitmaps.get(run), mX, mY, new Paint());}
             if (j %5== 0) run++;//每间隔m循环才去刷新帧动画

            }
            j++;
            if (j > 50) {j = 0; lock=finish; gameSurfaceView.setBossboo(false); run=0;}


        }
    }

    public void resetXY( Point point) {
        if (lock==finish){
        mX=point.x;
        mY=point.y;
        }
    }
}



