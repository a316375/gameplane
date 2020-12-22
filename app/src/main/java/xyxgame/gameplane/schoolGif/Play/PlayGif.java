package xyxgame.gameplane.schoolGif.Play;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import androidx.core.view.MotionEventCompat;

import java.util.ArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.ShowList.ListB;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class PlayGif extends BaseGifObj {


    public PlayGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        F5_GIf=10;


    }


    @Override
    public void add_drawCanvas(Canvas canvas) {
        super.add_drawCanvas(canvas);

    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new PlayBags(obj,list);

    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        list=allBitmaps.getyu2(obj.oW,obj.oH);

    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new PlayBags(obj,list));

    }



//    private int lastX, lastY;//手指的位置
//    private float pointX, pointY;//飞机的位置
//    private int pointXFix, pointYFix;//最终飞机的位置
    //按下屏幕触摸事件


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//
//        // Use the pointer ID to find the index of the active pointer
//
//
//
//        // gestureDetector.onTouchEvent(event);
//        switch (event.getActionMasked()) {
//            case MotionEvent.ACTION_DOWN:
//
//                lastX = (int) event.getX();//保存手指临时值
//                lastY = (int) event.getY();
//                if (bags.size()<=0)return true;
//                pointX = bags.get(0).x;//保存飞机按下时候的原始位置
//                pointY = bags.get(0).y;
//
//
//
//                return true;
//            case MotionEvent.ACTION_MOVE:
//
//                pointXFix = (int) (pointX + (event.getX() - lastX));
//                pointYFix = (int) (pointY + (event.getY() - lastY));
//
//                if (bags.size()<=0)return true;
//                BaseGifBag baseGifBag = bags.get(0);
//                baseGifBag.moveToXY(pointXFix, pointYFix,obj.maXx,obj.maXy);
//
//
//                return false;
//
////            case MotionEvent.ACTION_UP:
////                gifPlay.upbitmaps(4);
////                break;
//
//
//        }
//        return true;
//    }
//
//    private int mActivePointerId;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // Get the pointer ID
//        mActivePointerId = event.getPointerId(0);
//
//        // ... Many touch events later...
//
//        // Use the pointer ID to find the index of the active pointer
//        // and fetch its position
//        int pointerIndex = event.findPointerIndex(mActivePointerId);
//
//
//        switch (event.getActionMasked()) {
//            case MotionEvent.ACTION_DOWN:
//                if (event.getPointerId(event.getActionIndex()) == 0){
//                    lastX = (int) event.getX();//保存手指临时值
//                lastY = (int) event.getY();
//                if (bags.size()<=0)return true;
//                pointX = bags.get(0).x;//保存飞机按下时候的原始位置
//                pointY = bags.get(0).y;
//                    Log.v("-------","---coming");
//                return true;
//                }
//
//                case MotionEvent.ACTION_MOVE:
//                    if (event.getPointerId(event.getActionIndex()) == 0){
//                        pointXFix = (int) (pointX + (event.getX() - lastX));
//                         pointYFix = (int) (pointY + (event.getY() - lastY));
//
//                         if (bags.size()<=0)return true;
//                         BaseGifBag baseGifBag = bags.get(0);
//                         baseGifBag.moveToXY(pointXFix, pointYFix,obj.maXx,obj.maXy);
//
//
//                 } return true;
//
//
//            case MotionEvent.ACTION_POINTER_DOWN:
//                if (event.getPointerId(event.getActionIndex()) == 1){
//                    if (pointerIndex == -1) { return true; }
//                    Log.v("-------","---coming1");
//
//
//                }
//
//
//                return true;
//
//        }
//        return true;
//
//
//    }



//    // Given an action int, returns a string description
//    public static String actionToString(int action) {
//        switch (action) {
//
//            case MotionEvent.ACTION_DOWN: return "Down";
//            case MotionEvent.ACTION_MOVE: return "Move";
//            case MotionEvent.ACTION_POINTER_DOWN: return "Pointer Down";
//            case MotionEvent.ACTION_UP: return "Up";
//            case MotionEvent.ACTION_POINTER_UP: return "Pointer Up";
//            case MotionEvent.ACTION_OUTSIDE: return "Outside";
//            case MotionEvent.ACTION_CANCEL: return "Cancel";
//        }
//        return "";
//    }
}
