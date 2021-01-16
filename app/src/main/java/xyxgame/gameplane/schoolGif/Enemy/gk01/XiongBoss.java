package xyxgame.gameplane.schoolGif.Enemy.gk01;

import android.graphics.Bitmap;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class XiongBoss extends XiongGif{

public boolean die=false;
    public CopyOnWriteArrayList<Bitmap> bg_list;//添加光环背景
    public XiongBoss(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        bg_list=allBitmaps.getxiong_boss_bg(obj.oW,obj.oH);

    }

    @Override
    public void After_draw() {
        super.After_draw();
        Iterator<BaseGifBag> iterator = bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            BaseGifBag baseGifBag = it.next();
            if (baseGifBag.isDie==true)die=true;
        }

    }

    @Override
    protected void add_bags_add_new_obj_list() {
        // setWaitTime(60000);

            add(obj.maXx/2-obj.oW/2);

    }

    public void add(int distance_X){


        obj.oX+=distance_X;

        XiongBags xiongBags_bg = new XiongBossBags(obj, bg_list);
        bags.add(xiongBags_bg);

        XiongBags xiongBags = new XiongBossBags(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);


        obj.oX-=distance_X;


    }





}
