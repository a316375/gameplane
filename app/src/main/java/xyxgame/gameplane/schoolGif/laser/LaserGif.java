package xyxgame.gameplane.schoolGif.laser;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifBaseObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class LaserGif extends GifBaseObj {
    public LaserGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
    }




    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag= new LaserBags(obj,  list);
      }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
//        list=allBitmaps.getlaser03(obj.oW,obj.oH);
        list=allBitmaps.getlaser03(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        bags.add(new LaserBags(obj, list) );
    }


}
