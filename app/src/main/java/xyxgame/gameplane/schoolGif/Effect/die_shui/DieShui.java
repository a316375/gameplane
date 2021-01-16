package xyxgame.gameplane.schoolGif.Effect.die_shui;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;


/**水属性死亡时候的特效**/
public class DieShui extends BaseGifObj {

    public DieShui(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {

        gifBag=new DieShuiBags(obj,list);

    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {


        return allBitmaps.getdie_shui_enemy(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {

//        bags.add(new DieShuiBags(obj,list) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(1) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(2) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(3) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(4) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(5) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(6) );
//        bags.add(new DieShuiBags(obj,list).withPathNum(7) );

    }
    public void add(BaseGifBag enemy_bag){

        int x=enemy_bag.x+(enemy_bag.rect.right-enemy_bag.rect.left)/2;
        int y=enemy_bag.y+(enemy_bag.rect.bottom-enemy_bag.rect.top)/2;


        obj.oX=x;
        obj.oY=y;


        bags.add(new DieShuiBags(obj,list));
        bags.add(new DieShuiBags(obj,list).withPathNum(1));
        bags.add(new DieShuiBags(obj,list).withPathNum(2));
        bags.add(new DieShuiBags(obj,list).withPathNum(3));
        bags.add(new DieShuiBags(obj,list).withPathNum(4));
        bags.add(new DieShuiBags(obj,list).withPathNum(5));
        bags.add(new DieShuiBags(obj,list).withPathNum(6));
        bags.add(new DieShuiBags(obj,list).withPathNum(7));
    }
}
