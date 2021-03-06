package xyxgame.gameplane.schoolGif.Enemy.gk02.upXiong;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongGif3;

public class UpXiongGif extends XiongGif3 {
    public UpXiongGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        F5_GIf=8;
        move_X =obj.maXx/2-obj.oW/2;


    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        super.lodebitmaps_list__allBitmaps_get_objow_obj_oh();

        return allBitmaps.getupxiong08_move(obj.oW,obj.oH);
//        return null;
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        super.creatBags_gifbag_newxx_obj_list();
        UpXiongBags xiongBags3 = new UpXiongBags(obj, list);
        xiongBags3. setShuiEffect(new Shui(list_shui));
        //xiongBags3.addState(new xiongState());
        gifBag=xiongBags3;
    }

    @Override
    protected void add_bags_add_new_obj_list() {


        add(move_X);
        add(move_X-obj.maXx/3);
        add(move_X+obj.maXx/3);
    }

    public void add(int distance_X){

        obj.oX+=distance_X;
        UpXiongBags xiongBags = new UpXiongBags(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
      //  xiongBags.addState(new xiongState());
        bags.add(xiongBags);
        obj.oX-=distance_X;
    }
}
