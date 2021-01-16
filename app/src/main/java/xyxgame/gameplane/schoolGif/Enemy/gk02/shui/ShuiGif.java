package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class ShuiGif extends BaseGifObj {
    public ShuiGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        Time_wait=30;

    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
         ShuiBag shuiBag = new ShuiBag(obj, list);
        shuiBag.setShuiEffect(new Shui(list_shui));
        gifBag =shuiBag ;
    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {


        return allBitmaps.getshui_enemy_08move(obj.oW, obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {

        add();
    }

    public void add() {
        ShuiBag shuiBag = new ShuiBag(obj, list);
        shuiBag.setShuiEffect(new Shui(list_shui));
        // shuiBag.addState(new xiongState());
        bags.add(shuiBag);
    }


}
