package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBackGround;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;

public class GifView extends BaseSurfaceVIEW {

    FPS fps;
    BaseBackGround backGround;



    ArrayList<BaseGIFObject> baseGIFObjects;

    GifTimeManager gifTimeManager;


    GIFPlay gifPlay;


    BaseActivity mActivity;


    Point point;


    public GifView(BaseActivity mActivity)  {
        super(mActivity);
        point=mActivity.point;
        this.mActivity=mActivity;
        fps=new FPS();
        backGround=new BaseBackGround(mActivity, R.drawable.bg5);

        baseGIFObjects =new ArrayList<>();

        Bitmaps bitmaps=new Bitmaps();



        GIFA gifa=new GIFA(bitmaps.getxue(mActivity),new Random().nextInt(1000),0,6);
        gifTimeManager=new GifTimeManager(gifa);
        gifPlay=new GIFPlay(bitmaps.getniu(mActivity),
                (mActivity.point.x-100)/2,
                mActivity.point.y-200,6,bitmaps.getplay_bg(mActivity));

    }




//    int i=0;int j=0;

    @Override
    protected void onThreadDraw(Canvas canvas) {



        backGround.draw(canvas);

        gifTimeManager.draw(canvas,point);
//
//        i++;
//        if (i>1000)i=1;
//        if (i%10==0)j++;
//        if (i%100==0)baseGIFS.add(new GIFA(mActivity,Bitmaps.getxue(mActivity),new Random().nextInt(1000),0,6));
//
//        Iterator<BaseGIF> iterator = baseGIFS.iterator();
//        while (iterator.hasNext()){
//            iterator.next().draw(canvas);
//        }
//





        gifPlay.draw(canvas);
        fps.draw(canvas);
    }

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw() {

    }


    @Override
    public void startT() {
        super.startT();
        //重新唤醒屏幕，唤醒线程
      gifTimeManager.startHandler();;

    }

    @Override
    public void stopT() {
        super.stopT();
        gifTimeManager.stopHandler();
    }










    private int lastX, lastY;//手指的位置
    private float pointX, pointY;//飞机的位置
    private int pointXFix, pointYFix;//最终飞机的位置
    //按下屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                lastX = (int) event.getX();//保存手指临时值
                lastY = (int) event.getY();
                pointX = gifPlay.xX;//保存飞机按下时候的原始位置
                pointY = gifPlay.xY;



                break;
            case MotionEvent.ACTION_MOVE:

                pointXFix = (int) (pointX + (event.getX() - lastX));
                pointYFix = (int) (pointY + (event.getY() - lastY));

                gifPlay.moveToXY(pointXFix, pointYFix);


                break;


        }
        return true;
    }




}
