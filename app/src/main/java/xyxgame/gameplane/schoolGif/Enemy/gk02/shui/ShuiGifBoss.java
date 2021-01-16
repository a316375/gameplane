package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBags;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBoss;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBossBags;
import xyxgame.gameplane.schoolGif.Enemy.gk01.xiongState;

public class ShuiGifBoss extends XiongBoss {
    public ShuiGifBoss(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        Time_wait=50;


    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        list=allBitmaps.getupxiong08_move(obj.oW,obj.oH);
    }

    public void add(int distance_X){


        obj.oX+=distance_X;

        XiongBags xiongBags_bg = new ShuiBossBag(obj, bg_list);
        bags.add(xiongBags_bg);

        XiongBags xiongBags = new ShuiBossBag(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);


        obj.oX-=distance_X;


    }




}
