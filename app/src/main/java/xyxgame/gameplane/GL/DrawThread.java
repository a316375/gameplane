package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//  BUG障碍物M出厂时候会
// 2020-12-03 18:34:01.943 20080-25146/xyxgame.gameplane W/ExtendedACodec: Failed to get extension for extradata parameter
//        2020-12-03 18:34:01.948 20080-25146/xyxgame.gameplane W/AMessage: the pointer from->u.stringValue and to->u is not null
//        2020-12-03 18:34:01.955 20080-25146/xyxgame.gameplane W/AMessage: failed to deliver message as target handler 2210 is gone.
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.BG;
import xyxgame.gameplane.spaceshooter.Laser;
import xyxgame.gameplane.spaceshooter.Meteor;
import xyxgame.gameplane.spaceshooter.Player;
import xyxgame.gameplane.spaceshooter.SoundPlayer;

public class DrawThread extends Thread {

   // private  Shot shot;//你需要声明一个对象
    private BG bg;

    private volatile int mCounter;//控制

    private Shot mshot;

    private BTMAP btmap;

    private ArrayList<GOLDS> golds;



     private ArrayList<ShotLaser> shotLasers;

    // private BOSS boss;
    private ArrayList<SpriteManager> sprites;

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    private void getObjs() {
        //这个对象是gamesurfaceview就已经声明出来的了,并且赋值

        bg=gameSurfaceView.getBg();

//        mCounter=gameSurfaceView.getThread().getmCounter();
          mCounter=0;
        btmap=gameSurfaceView.getBtmap();

        mshot=gameSurfaceView.getMshot();
        shotLasers=new ArrayList<>();


         sprites=new ArrayList<>();
         golds=new ArrayList<>();



        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {



                if (gameSurfaceView.ismIsRun()) {
                    w.lock();
                    try {
                        if (golds.size()<5){
                            golds.add(new GOLDS(gameSurfaceView.getContext(),btmap,500,0));
                        }

                        if (shotLasers.size() <20) {
                            shotLasers.add(new ShotLaser(gameSurfaceView.getContext(), btmap,
                                    gameSurfaceView.getmScreenSizeX(), gameSurfaceView.getmScreenSizeY(), null, mshot));
                        }
                        if (sprites.size() <5) {
                            sprites.add(new SpriteManager(btmap, 4, new Point(0, 0), new Point(0, 1000)));
                        }

                    }finally {
                        w.unlock();
                    }


                }
                if (gameSurfaceView.ismIsRun())  handler.postDelayed(this,300);
                }

        };
        handler.postDelayed(runnable,300);




    }

    private   synchronized void upClear() {
        //判断后清除对象逻辑以释放内存

        w.lock();
        try {

        for (Iterator<ShotLaser> ls = shotLasers.iterator(); ls.hasNext();){
            while (ls.hasNext()){
                if (ls.next().getBitmap().isRecycled())
                    ls.remove();}
        }

        for (Iterator<SpriteManager> ls = sprites.iterator(); ls.hasNext();){
            while (ls.hasNext()){
                if (ls.next().getBitmap().isRecycled())
                    ls.remove();}
        }

        for (Iterator<GOLDS> ls = golds.iterator(); ls.hasNext();){
            while (ls.hasNext()){
                if (ls.next().bitmap.isRecycled())
                    ls.remove();}
        }

        }finally {
            w.unlock();
        }




    }


    private synchronized   void updraw(Canvas canvas, Paint paint) {
        w.lock();
        try {
        bg.draw(canvas,paint);
        //把他绘制到画布上

       mshot.draw(canvas,paint);


           for (ShotLaser s : shotLasers) {
               if (!s.getBitmap().isRecycled() && shotLasers.size() > 0) s.draw(canvas, paint);
           }
           for (SpriteManager s : sprites) {
               if (!s.getBitmap().isRecycled() && sprites.size() > 0) s.draw(canvas, paint);
           }

           for (GOLDS g : golds) {
               if (!g.getBitmap().isRecycled() && golds.size() > 0) g.draw(canvas, paint);
           }

}finally {
    w.unlock();
}



        new Thread(new Runnable() {
               @Override
               public void run() {
                   if (gameSurfaceView.ismIsRun()) {
                       //spriteManager.destory(play.getLasers());//消除碰撞的逻辑,由于改写了play以及子弹类，此处待续
                   }
               }
           }).start();






    }

    //以后需要更新可在上面修改代码
    //以下是逻辑编辑






    SurfaceHolder  holder;

     Runnable timeRunnable;

    GameSurfaceView gameSurfaceView;

    public DrawThread(final GameSurfaceView gameSurfaceView, SurfaceHolder holder) {

        this.holder = holder;

        this.gameSurfaceView=gameSurfaceView;


        getObjs();



    }



    @Override
    public void run() {
        //upThread.start();


            // 不停绘制界面
            while (gameSurfaceView.ismIsRun()) {

          upClear();//判断后清除对象逻辑以释放内存

          drawUI();//绘制对象


        }
    }





    /**
     * 界面绘制
     */
    public void drawUI() {

        if (holder.getSurface().isValid()&&gameSurfaceView.isDrawOK()&&!rwl.isWriteLockedByCurrentThread()) {

            Canvas canvas = holder.lockCanvas();

            try {
                //join(1);
              drawCanvas(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            canvas.save();
//            canvas.restore();
           holder.unlockCanvasAndPost(canvas);

        }
    }

    private void drawCanvas(Canvas canvas) {
        // 在 canvas 上绘制需要的图形

            Paint paint = new Paint();

            paint.setAntiAlias(true);
            paint.setFakeBoldText(true);               // if you like bold
            paint.setShadowLayer(5, 5, 5, Color.GRAY); // add shadow
            paint.setColor(Color.WHITE);
            paint.setTextSize(30);

             canvas.drawColor(Color.BLACK);


            updraw(canvas,paint);

            canvas.drawText("FPS:"+(int)gameSurfaceView.getFps().fps(), 100, 100, paint);

//          if (sprites.size()>0) {
//
//              for (int i = 0; i < sprites.size(); i++) {
//                 canvas.drawRect(sprites.get(i).rect, paint);
//              }
//          }

    }




}
