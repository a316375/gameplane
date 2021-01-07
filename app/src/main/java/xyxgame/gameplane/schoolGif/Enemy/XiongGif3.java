package xyxgame.gameplane.schoolGif.Enemy;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class XiongGif3 extends XiongGif {
    public XiongGif3(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new XiongBags3(obj,list).addState(new xiongState());
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new XiongBags3(obj,list).addState(new xiongState()));

    }
}
