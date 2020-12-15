package xyxgame.gameplane.GIf;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MotionListener implements GestureDetector.OnGestureListener {

    //这是针对多方位滑动的
    int FLIP_DISTANCE = 50;

    Bitmaps bitmaps;GIFPlay gifPlay;
    public MotionListener(Bitmaps bitmaps, GIFPlay gifPlay) {
        this.bitmaps=bitmaps;
        this.gifPlay=gifPlay;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float v, float v1) {


        if (e1.getX() - e2.getX() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) > 0.5
                && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) < 2 && e2.getY() - e1.getY() > 0) {
         //   TipUtil.show(this, "左下滑动");
        //    Log.v("----","左下滑动");
         //   gifPlay.upbitmaps(7);
            return true;
        }
        if (e1.getX() - e2.getX() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) > 0.5
                && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) < 2 && e2.getY() - e1.getY() < 0) {
        //    TipUtil.show(this, "左上滑动");
         //   Log.v("----","左上滑动");
        //    gifPlay.upbitmaps(1);
            return true;
        }
        if (e2.getX() - e1.getX() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) > 0.5
                && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) < 2 && e2.getY() - e1.getY() > 0) {
         //   TipUtil.show(this, "右下滑动");
         //   Log.v("----","右下滑动");
         //   gifPlay.upbitmaps(3);
            return true;
        }
        if (e2.getX() - e1.getX() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) > 0.5
                && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) < 2 && e2.getY() - e1.getY() < 0) {
         //   TipUtil.show(this, "右上滑动");
          //  Log.v("----","右上滑动");
         //   gifPlay.upbitmaps(3);
            return true;
        }
        if (e1.getX() - e2.getX() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) > 2) {
        //    TipUtil.show(this, "向左滑动");
        //    Log.v("----","向左滑动");
        //    gifPlay.upbitmaps(1);

            return true;
        }
        if (e2.getX() - e1.getX() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) > 2) {
         //   TipUtil.show(this, "向右滑动");
          //  Log.v("----","向右滑动");
          //  gifPlay.upbitmaps(3);
            return true;
        }
        if (e1.getY() - e2.getY() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) < 0.5) {
        //    TipUtil.show(this, "向上滑动");
        //    Log.v("----","向上滑动");
        //    gifPlay.upbitmaps(2);
            return true;
        }
        if (e2.getY() - e1.getY() > FLIP_DISTANCE && Math.abs(e1.getX() - e2.getX()) / Math.abs(e1.getY() - e2.getY()) < 0.5) {
        //    TipUtil.show(this, "向下滑动");
      //      Log.v("----","向下滑动");
        //    gifPlay.upbitmaps(2);
            return true;
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


        return false;
    }
}


