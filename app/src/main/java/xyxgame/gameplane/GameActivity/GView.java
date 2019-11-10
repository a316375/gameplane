package xyxgame.gameplane.GameActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
//
public class GView extends SurfaceView implements Runnable{

    private   SurfaceHolder mSurfaceHolder;
    private  Canvas mCanvas;
    private Paint mPaint;
    private  Thread mThread;

    private volatile int mControl=0;

    boolean mIsplaying=true;
    private int mScreenSizeX, mScreenSizeY;

    Play mPlay;


    public GView(Context context, int screenSizeX, int screenSizeY) {
        super(context);
       this.mScreenSizeX = screenSizeX;
        this.mScreenSizeY = screenSizeY;
        mSurfaceHolder = getHolder();
        mPaint=new Paint();

        reset();

    }

    private void reset() {
        mPlay=new Play(getContext(),mScreenSizeX,mScreenSizeY);
    }


    @Override
    public void run() {
        while (mIsplaying){
        update();
        draw();
        control();}
    }

    private void update() {
        mPlay.update();

    }

    private void draw() {
        if (mSurfaceHolder.getSurface().isValid()) {
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.WHITE);

            mCanvas.drawBitmap(mPlay.getBitmap(),mPlay.getX(),mPlay.getY(),mPaint);
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }
    private void control() {
        if (mControl==1000)mControl=0;
        try {
            mThread.sleep(20);
            mControl+=20;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //响应Acitivity暂停
    public void pause() {
        Log.d("GameThread", "Main");
        mIsplaying = false;
        try {
            mThread.join();
            //mSoundPlayer.pause();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //响应Acitivity恢复
    public void resume() {
        mIsplaying = true;
        //mSoundPlayer.resume();
        mThread = new Thread(this);
        mThread.start();
    }


    //按下屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                 mPlay.update(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量


                break;
        }
        return super.onTouchEvent(event);
    }



}
