package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class ShuiGif extends BaseGifObj {
    public ShuiGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);

    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
         ShuiBag shuiBag = new ShuiBag(obj, list);
        shuiBag.setShuiEffect(new Shui(list_shui));
        gifBag =shuiBag ;
    }

    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        list = allBitmaps.getshui_enemy_08move(obj.oW, obj.oH);

    }

    @Override
    protected void add_bags_add_new_obj_list() {

        add();
    }

    private void add() {
        ShuiBag shuiBag = new ShuiBag(obj, list);
        shuiBag.setShuiEffect(new Shui(list_shui));
        // shuiBag.addState(new xiongState());
        bags.add(shuiBag);
    }


}
