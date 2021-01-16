package xyxgame.gameplane.schoolGif.Button;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class Button2Gif extends BaseGifObj {
    public Button2Gif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }


    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new Button2Bags(obj,list);
    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {

        return allBitmaps.getbutton2(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new Button2Bags(obj,list));

    }


}
