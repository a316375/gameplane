package xyxgame.gameplane.schoolGif.Button;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class ButtonGif extends BaseGifObj {
    public ButtonGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }


    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new ButtonBags(obj,list);
    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {

        return allBitmaps.getfb01(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new ButtonBags(obj,list));

    }


}
