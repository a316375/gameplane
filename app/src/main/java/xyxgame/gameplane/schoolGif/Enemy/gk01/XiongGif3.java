package xyxgame.gameplane.schoolGif.Enemy.gk01;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class XiongGif3 extends XiongGif {

    public XiongGif3(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        move_X =obj.maXx/2-obj.oW/2+obj.maXx*2/8;
    }


    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        XiongBags3 xiongBags3 = new XiongBags3(obj, list);
        xiongBags3. setShuiEffect(new Shui(list_shui));
        xiongBags3.addState(new xiongState());
        gifBag=xiongBags3;
    }

    @Override
    protected void add_bags_add_new_obj_list() {



                add(move_X);
//                add(obj.maXx/2-obj.oW/2+obj.maXx*3/8);
//
//                add(obj.maXx/2-obj.oW/2-obj.maXx*2/8);
//                add(obj.maXx/2-obj.oW/2-obj.maXx*3/8);






    }

    public void add(int distance_X){
        obj.oX+=distance_X;
        XiongBags xiongBags = new XiongBags3(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);
        obj.oX-=distance_X;
    }
}
