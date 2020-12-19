package xyxgame.gameplane.schoolGif.Blast;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class BlastGif extends BaseGifObj {
    public BlastGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new BlastBags(obj,list);

    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        list=allBitmaps.getfb06(obj.oW,obj.oH);

    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new BlastBags(obj,list));

    }
}
