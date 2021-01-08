package xyxgame.gameplane.schoolGif.Enemy;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;
import xyxgame.gameplane.schoolGif.Model.State;

public class XiongGif extends BaseGifObj {
    public XiongGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        F5_GIf=10;
        Time_wait=100;

    }


    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        XiongBags xiongBags = new XiongBags(obj, list);
        xiongBags. setShuiEffect(new Shui(allBitmaps));
        gifBag= xiongBags.addState(new xiongState());//注意：赋予其状态属性

    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {


      list=allBitmaps.getxiong8Move(obj.oW,obj.oH);


    }




    @Override
    protected void add_bags_add_new_obj_list() {
        XiongBags xiongBags = new XiongBags(obj, list);
        xiongBags. setShuiEffect(new Shui(allBitmaps));
        bags.add(xiongBags.addState(new xiongState()));
    }
}
