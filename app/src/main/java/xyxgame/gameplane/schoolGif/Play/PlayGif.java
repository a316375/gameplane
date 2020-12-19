package xyxgame.gameplane.schoolGif.Play;

import android.view.MotionEvent;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class PlayGif extends BaseGifObj {
    public PlayGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        F5_GIf=10;

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
                if (bags.size()<=0)return true;
                pointX = bags.get(0).x;//保存飞机按下时候的原始位置
                pointY = bags.get(0).y;



                return true;
            case MotionEvent.ACTION_MOVE:

                pointXFix = (int) (pointX + (event.getX() - lastX));
                pointYFix = (int) (pointY + (event.getY() - lastY));

                if (bags.size()<=0)return true;
                BaseGifBag baseGifBag = bags.get(0);
                baseGifBag.moveToXY(pointXFix, pointYFix,obj.maXx,obj.maXy);


                return false;

//            case MotionEvent.ACTION_UP:
//                gifPlay.upbitmaps(4);
//                break;


        }
        return true;
    }






}
