package xyxgame.gameplane.schoolGif.Enemy;

import android.graphics.Rect;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class XiongBoss extends XiongGif{
    public XiongBoss(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        // setWaitTime(60000);


        if (full>=obj.max){go=false;
//            resetWaitTime(10000);//不要出现了
        }
        else add(obj.maXx/2-obj.oW/2);

    }

    private void add(int distance_X){

        obj.oX+=distance_X;
        XiongBags xiongBags = new XiongBossBags(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);
        obj.oX-=distance_X;
    }

    @Override
    public void initgo() {
        go=false;
    }
}
