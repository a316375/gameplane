package xyxgame.gameplane.schoolGif.laser;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifBaseObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Play.PlayGif;

public class LaserGif extends GifBaseObj {
    PlayGif playGif;
    public LaserGif with(PlayGif playGif){
        this.playGif=playGif;
        return this;}

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


        if (playGif.bags.size()<=0)return;
        if (playGif!=null) {
            obj.oX=playGif.bags.get(0).x+playGif.bags.get(0).w/2-obj.oW/2;
            obj.oY=playGif.bags.get(0).y;
        }



        LaserBags e = new LaserBags(obj, list);

        bags.add(e);

    }


}
