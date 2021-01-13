package xyxgame.gameplane.schoolGif.Enemy.gk01;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class XiongGif2 extends XiongGif {
    public XiongGif2(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        XiongBags2 xiongBags2 = new XiongBags2(obj, list);
        xiongBags2.addState(new xiongState());
        gifBag=xiongBags2;
    }


    @Override
    protected void add_bags_add_new_obj_list() {


                add(obj.maXx/2-obj.oW/2+obj.maXx*1/8);
              //  add(obj.maXx/2-obj.oW/2-obj.maXx*1/8);







    }

    private void add(int distance_X){
        obj.oX+=distance_X;
        XiongBags xiongBags = new XiongBags2(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);
        obj.oX-=distance_X;
    }
}
