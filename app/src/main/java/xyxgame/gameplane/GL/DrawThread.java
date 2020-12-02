package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import java.util.ArrayList;
import java.util.Iterator;

import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.BG;
import xyxgame.gameplane.spaceshooter.Laser;
import xyxgame.gameplane.spaceshooter.Meteor;
import xyxgame.gameplane.spaceshooter.Player;
import xyxgame.gameplane.spaceshooter.SoundPlayer;

public class DrawThread extends Thread {

   // private  Shot shot;//你需要声明一个对象
    private BG bg;
    private Player play;
    private int mCounter;//控制
    private ArrayList<Meteor> meteor;

    private BTMAP btmap;

    private void getObjs() {
        //这个对象是gamesurfaceview就已经声明出来的了,并且赋值
      //  shot = gameSurfaceView.getShot();
        bg=gameSurfaceView.getBg();
        play=gameSurfaceView.getmPlay();
        mCounter=gameSurfaceView.getmCounter();
        meteor=gameSurfaceView.getMeteor();
        btmap=gameSurfaceView.getBtmap();

    }

    private void upClear() {
        //判断后清除对象逻辑以释放内存
      //  if (shot.getX()>gameSurfaceView.getmScreenSizeX()) {shot.bitmap.recycle();}
        mCounter++;
        if (mCounter>600)mCounter=0;

        //特例：需要先创建对象赋值给集合
        if (mCounter%10==0&&meteor.size()<3)meteor.add(
                new Meteor(gameSurfaceView.getContext(),btmap,gameSurfaceView.getmScreenSizeX(),gameSurfaceView.getmScreenSizeY(),new SoundPlayer(gameSurfaceView.getContext()))
        );



            for (Meteor m : meteor) {

                if (m.getX() < 0) {
                    m.getBitmap().recycle();
                    meteor.remove(m);
                    break;//清除自己
                }

                if (gameSurfaceView.isShotLine()){
                //跟子弹碰撞的逻辑
                for (Laser l : play.getLasers()) {
                    if (Rect.intersects(m.getCollision(), l.getCollision())) {
                        m.hit();
                        l.getBitmap().recycle();
                    }
                }}
            }


        if (mCounter%5==0)play.fire(0);
        //子弹清理
        for (Laser l:play.getLasers()) {  if (l.getY()<-l.getBitmap().getHeight()){ l.getBitmap().recycle();   meteor.remove(l); break;} }


    }

    private void upXY(){
        //刷新位置
      //  shot.upXY();
        bg.update();
        play.update();
        for (Meteor m:meteor){
            m.update();
        }
    }
    private void updraw(Canvas canvas, Paint paint) {
        bg.draw(canvas,paint);
        //把他绘制到画布上
      //  if (!shot.bitmap.isRecycled()) canvas.drawBitmap(shot.bitmap, shot.x, shot.y, paint);

        for (Meteor m:meteor){
            if (!m.getBitmap().isRecycled()) canvas.drawBitmap(m.getBitmap(), m.getX(), m.getY(), paint);
        }

        for (Laser l : play.getLasers()) {
            if (!l.getBitmap().isRecycled())   canvas.drawBitmap(l.getBitmap(), l.getX(), l.getY(), paint);
        }

        if (!play.getResult(mCounter).isRecycled()) canvas.drawBitmap(play.getResult(mCounter), play.getX(), play.getY(), paint);

    }

    //以后需要更新可在上面修改代码
    //以下是逻辑编辑






    SurfaceHolder  holder;



    GameSurfaceView gameSurfaceView;

    public DrawThread(GameSurfaceView gameSurfaceView, SurfaceHolder holder) {

        this.holder = holder;

        this.gameSurfaceView=gameSurfaceView;

        getObjs();


    }



    @Override
    public void run() {
        //upThread.start();

        // 不停绘制界面
        while (gameSurfaceView.ismIsRun()) {

              upXY();//刷新位置
              upClear();//判断后清除对象逻辑以释放内存
              drawUI();//绘制对象
        }

    }





    /**
     * 界面绘制
     */
    public void drawUI() {

        if (holder.getSurface().isValid()&&gameSurfaceView.isDrawOK()) {

            Canvas canvas = holder.lockCanvas();

            try {
                 join(1);
                 drawCanvas(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            }

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


            updraw(canvas,paint);

            canvas.drawText("FPS:"+(int)gameSurfaceView.getFps().fps(), 100, 100, paint);




    }


}
