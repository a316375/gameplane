package xyxgame.gameplane.schoolGif.Enemy;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class XiongGif extends BaseGifObj {
    public XiongGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        F5_GIf=10;
        Time_wait=100;

    }


    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        XiongBags xiongBags = new XiongBags(obj, list);
        xiongBags. setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());//注意：赋予其状态属性
        gifBag=xiongBags;

    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {

      list=allBitmaps.getxiong8Move(obj.oW,obj.oH);

    }








    @Override
    protected void add_bags_add_new_obj_list() {
       // setWaitTime(60000);


        if (full>=obj.max){go=false;
            resetWaitTime(10000);}
       else add(obj.maXx/2-obj.oW/2);

    }




    private void add(int distance_X){

        obj.oX+=distance_X;
        XiongBags xiongBags = new XiongBags(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);
        obj.oX-=distance_X;
    }
}