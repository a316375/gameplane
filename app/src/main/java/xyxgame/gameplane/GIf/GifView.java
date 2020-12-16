package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.GestureDetector;
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
    // final GestureDetector gestureDetector;//方位监听
   Bitmaps bitmaps;



     Laser laser;

    T1 t1;

    public GifView(BaseActivity mActivity)  {
        super(mActivity);
        point=mActivity.point;
        this.mActivity=mActivity;
        fps=new FPS();
        backGround=new BaseBackGround(mActivity, R.drawable.bg5);
     //   textDraw=new TextDraw(mActivity,500,500,500);

        baseGIFObjects =new ArrayList<>();

        bitmaps = new Bitmaps();

        t1=new T1(this);





        GIFA gifa=new GIFA(bitmaps.getxue(mActivity),new Random().nextInt(1000),0,6);
        gifTimeManager=new GifTimeManager(gifa);
        gifPlay=new GIFPlay(bitmaps.getyu5(mActivity),
                (mActivity.point.x-100)/2,
                mActivity.point.y-200,6, bitmaps);


        laser = new Laser(gifPlay);

        //定义手势监听器
      //  gestureDetector = new GestureDetector(mActivity,new MotionListener(bitmaps,gifPlay));

    }




//    int i=0;int j=0;

    @Override
    protected void onThreadDraw(Canvas canvas) {


        t1.postResult();//处理碰撞结果，调整集合-注意不能去这个类里边draw canvas《Canvas是绘画主线程，传参是在子线程》

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

        laser.draw(canvas);





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
       // gestureDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                lastX = (int) event.getX();//保存手指临时值
                lastY = (int) event.getY();
                pointX = gifPlay.xX;//保存飞机按下时候的原始位置
                pointY = gifPlay.xY;



                return true;
            case MotionEvent.ACTION_MOVE:

                pointXFix = (int) (pointX + (event.getX() - lastX));
                pointYFix = (int) (pointY + (event.getY() - lastY));

                gifPlay.moveToXY(pointXFix, pointYFix);


                return false;

//            case MotionEvent.ACTION_UP:
//                gifPlay.upbitmaps(4);
//                break;


        }
        return true;
    }




}
