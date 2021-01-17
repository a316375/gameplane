package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBags;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBoss;
import xyxgame.gameplane.schoolGif.Enemy.gk01.xiongState;

public class UpxiongGifBoss extends XiongBoss {
    public UpxiongGifBoss(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        Time_wait=50;


    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {

        return allBitmaps.getupxiong08_move(obj.oW,obj.oH);
//        return null;
    }

    public void add(int distance_X){


        obj.oX+=distance_X;

        XiongBags xiongBags_bg = new UpxiongBossBag(obj, bg_list);
        bags.add(xiongBags_bg);

        XiongBags xiongBags = new UpxiongBossBag(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);


        obj.oX-=distance_X;


    }




}
