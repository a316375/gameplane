package xyxgame.gameplane.schoolGif.Effect.die;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class DieEnemyGif extends BaseGifObj {
    public DieEnemyGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new DieEnemyBag(obj,list);

    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        return allBitmaps.getdie_enemy(obj.oW,obj.oW);
    }

    @Override
    protected void add_bags_add_new_obj_list() {

    }

    public void add(int x,int y){
        bags.add(new DieEnemyBag(obj,list).moveToXY(x,y));
    }
}
