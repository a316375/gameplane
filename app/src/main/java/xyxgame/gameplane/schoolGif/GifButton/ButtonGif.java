package xyxgame.gameplane.schoolGif.GifButton;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifBaseObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class ButtonGif extends GifBaseObj {
    public ButtonGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }


    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new ButtonBags(obj,list);
    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
     if (obj.giflist==1)  list=allBitmaps.getfb01(obj.oW,obj.oH);
     if (obj.giflist==2)  list=allBitmaps.getfb02(obj.oW,obj.oH);

    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new ButtonBags(obj,list));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (bags.size()<=0)return true;
                if (bags.get(0).rect.contains((int) event.getX(),(int) event.getY())){
                    Log.v("-------","------O-nClickListener---obj--"+obj.giflist);
                }
        return true;}

        return true;
    }
}
