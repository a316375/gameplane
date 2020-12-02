package xyxgame.gameplane.GL;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import xyxgame.gameplane.R;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {


    private  boolean drawOK;
    private Context mcontext;
    private int mScreenSizeX; private int mScreenSizeY;

    private   SurfaceHolder holder;
    private DrawThread drawThread;
    private   Shot shot;

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public Shot getShot() {
        return shot;
    }

    public boolean isDrawOK() {
        return drawOK;
    }

    public boolean ismIsRun() {
        return mIsRun;
    }

    boolean mIsRun;


    public GameSurfaceView(Context  context, int screenSizeX, int screenSizeY) {
        super(context);  mcontext=context;  mScreenSizeX = screenSizeX;  mScreenSizeY = screenSizeY;

        intview();
        holder = getHolder();
        holder.addCallback(this);
        setResource();//设置加载的类有哪些并提供get方法,必须在此处声明初始化的数据，并且Thread 要从这里拿数据，否则会出错

    }

    private void setResource() {
        shot = new Shot(mcontext, 100, 200, R.drawable.blue_button01);
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
}
