package xyxgame.gameplane.schoolGif.pan;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifBaseObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class PanGif extends GifBaseObj {
    public PanGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new PanBag(obj,list);

    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        list=allBitmaps.getPan(obj.oW,obj.oH);

    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new PanBag(obj,list));

    }
}
