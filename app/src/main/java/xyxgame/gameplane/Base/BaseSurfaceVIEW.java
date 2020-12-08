package xyxgame.gameplane.Base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class BaseSurfaceVIEW extends SurfaceView implements SurfaceHolder.Callback {
    public static final int DEFAULT_FRAME_DURATION_MILLISECOND =20;
    //用于计算帧数据的线程
    private HandlerThread handlerThread;
    private Handler handler;
    //帧刷新频率
    private int frameDuration = DEFAULT_FRAME_DURATION_MILLISECOND;
    //用于绘制帧的画布
    private Canvas canvas;
    private boolean isAlive;

    private Thread mDrawThread;boolean isGameing;

    public BaseSurfaceVIEW(Context context, NUMManager numManager) {
        super(context);
        init();
    }

    protected void init() {
        getHolder().addCallback(this);
        //设置透明背景，否则SurfaceView背景是黑的
        setBackgroundTransparent();

    }

    private void setBackgroundTransparent() {
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        setZOrderOnTop(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startT();
        startDrawThread();
    }



    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopT();
     }

    public   void startT(){
        isAlive = true;
        isGameing=true;};

    //停止帧绘制线程
    public void stopT() {
        isAlive = false;
        handlerThread.quit();
        handler = null;
        isGameing=false;

    }

    //启动帧绘制线程
    private void startDrawThread() {
        handlerThread = new HandlerThread("SurfaceViewThread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
         handler.post(new DrawRunnable());

        runable=new ThreadRunable();
        mDrawThread=new Thread(runable);
        mDrawThread.start();

    }

    protected abstract void onThreadDraw(Canvas canvas);
    private ThreadRunable runable;
    private class ThreadRunable implements Runnable{
        @Override
        public void run() {
            synchronized (this){
            while (isGameing&&getHolder().getSurface().isValid()) {

                try {
                    //1.获取画布
                    canvas = getHolder().lockCanvas();
                    //2.绘制一帧
                    onThreadDraw(canvas);
                    //3.将帧数据提交
                    getHolder().unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    //4.一帧绘制结束
                    onFrameDrawFinish();
                }
            }

        }
    }
    }


    private class DrawRunnable implements Runnable {

        @Override
        public void run() {
            if (!isAlive) {
                return;
            }
            try {
                //1.获取画布
              //  canvas = getHolder().lockCanvas();
                //2.绘制一帧
                onFrameDraw();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //3.将帧数据提交
             //   getHolder().unlockCanvasAndPost(canvas);
                //4.一帧绘制结束
             //   onFrameDrawFinish();
            }
            //不停的将自己推送到绘制线程的消息队列以实现帧刷新
            handler.postDelayed(this, frameDuration);
        }
    }

    protected abstract void onFrameDrawFinish();

    protected abstract void onFrameDraw();


}
