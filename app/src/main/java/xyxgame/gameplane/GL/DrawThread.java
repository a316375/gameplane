package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.BG;

public class DrawThread extends Thread {

    private  Shot shot;//你需要声明一个对象

    private void getObjs() {//这个对象是gamesurfaceview就已经声明出来的了,并且赋值
        shot = gameSurfaceView.getShot();
    }

    private void upClear() {
        //判断后清除对象逻辑以释放内存
        if (shot.getX()>250) {shot.bitmap.recycle();}
    }

    private void upXY(){
        //刷新位置
        shot.upXY();
    }
    private void updraw(Canvas canvas, Paint paint) {
        //把他绘制到画布上
        if (!shot.bitmap.isRecycled()) canvas.drawBitmap(shot.bitmap, shot.x, shot.y, paint);
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
            canvas.drawColor(Color.argb(255, 0, 0, 0));
            paint.setAntiAlias(true);
            paint.setFakeBoldText(true);               // if you like bold
            paint.setShadowLayer(5, 5, 5, Color.GRAY); // add shadow
            paint.setColor(Color.WHITE);
            paint.setTextSize(30);
            canvas.drawText("Test", 100, 100, paint);

            updraw(canvas,paint);




    }


}
