package xyxgame.gameplane.GL;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.BG;
import xyxgame.gameplane.spaceshooter.MainMenuActivity;
import xyxgame.gameplane.spaceshooter.Meteor;
import xyxgame.gameplane.spaceshooter.Player;
import xyxgame.gameplane.spaceshooter.SoundPlayer;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {




    private void setResource() {
        shotLine=true;
        fps=new FPS();
        btmap=new BTMAP(mcontext);
        mshot = new Shot(mcontext,btmap,mScreenSizeX,mScreenSizeY,null);
        bg=new BG(mcontext,btmap,mScreenSizeX,mScreenSizeY);




    }







   // private BOSS boss;

//    public BOSS getBoss() {
//        return boss;
//    }






    private BTMAP btmap;

    public BTMAP getBtmap() {
        return btmap;
    }

    public void setShotLine(boolean shotLine) {
        this.shotLine = shotLine;
    }

    private boolean shotLine;

    public boolean isShotLine() {
        return shotLine;
    }


    public Shot getMshot() {
        return mshot;
    }

    private Shot mshot;
    private  boolean drawOK;
    private Context mcontext;

    public int getmScreenSizeX() {
        return mScreenSizeX;
    }

    public int getmScreenSizeY() {
        return mScreenSizeY;
    }

    private int mScreenSizeX; private int mScreenSizeY;

    private   SurfaceHolder holder;
    private DrawThread drawThread;


    public BG getBg() {
        return bg;
    }

    private BG bg;


    public boolean isDrawOK() {
        return drawOK;
    }

    public boolean ismIsRun() {
        return mIsRun;
    }

    boolean mIsRun;
    private FPS fps;

    public FPS getFps() {
        return fps;
    }

    public GameSurfaceView(Context  context, int screenSizeX, int screenSizeY) {
        super(context);  mcontext=context;  mScreenSizeX = screenSizeX;  mScreenSizeY = screenSizeY;

        intview();
        holder = getHolder();
        holder.addCallback(this);
        setResource();//设置加载的类有哪些并提供get方法,必须在此处声明初始化的数据，并且Thread 要从这里拿数据，否则会出错
       // upResource();//更新资源，刷新怪物出现，设置时间

    }


    private void intview() {
        //设置一些参数方便后面绘图
        setFocusable(true);
        setKeepScreenOn(true);
        setFocusableInTouchMode(true);
    }


    public void resume() {
        drawOK=true;
        mIsRun=true;
       //  getHolder().addCallback(this);
    }

    public void pause() {
        mIsRun=false;
        //getHolder().removeCallback(this);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        drawThread = new DrawThread(this,holder);
         mIsRun=true;
         drawOK=true;
        drawThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        drawOK=false;
         mIsRun=false;
        // holder.removeCallback(this);

    }

    private int lastX, lastY;//手指的位置
    private int pointX, pointY;//飞机的位置
    private int pointXFix, pointYFix;//最终飞机的位置
    //按下屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if (mIsRun==false) {
                    ((Activity) getContext()).finish();
                    getContext().startActivity(new Intent(getContext(), MainMenuActivity.class));
                } else {
                    lastX = (int) event.getX();//保存手指临时值
                    lastY = (int) event.getY();
                    pointX = mshot.getX();//保存飞机按下时候的原始位置
                    pointY = mshot.getY();
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsRun==true) {
                    pointXFix = (int) (pointX + (event.getX() - lastX));
                    pointYFix = (int) (pointY + (event.getY() - lastY));

                    mshot.update(pointXFix, pointYFix);

                }
                break;


        }
        return true;
    }
}
