package xyxgame.gameplane.schoolGif.Pan;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class PanGif extends BaseGifObj {
    public PanGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new PanBag(obj,list);

    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {


        return allBitmaps.getPan(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new PanBag(obj,list));

    }
}
