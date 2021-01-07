package xyxgame.gameplane.schoolGif.Enemy;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class XiongGif2 extends XiongGif {
    public XiongGif2(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
         gifBag=new XiongBags2(obj,list).addState(new xiongState());
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new XiongBags2(obj,list).addState(new xiongState()));

    }
}
