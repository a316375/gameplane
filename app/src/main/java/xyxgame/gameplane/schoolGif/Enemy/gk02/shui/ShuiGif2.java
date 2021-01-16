package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;

public class ShuiGif2 extends ShuiGif{
    public ShuiGif2(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        Time_wait=25;


    }

    @Override
    public void add() {
        ShuiBag2 shuiBag = new ShuiBag2(obj, list);
        shuiBag.setShuiEffect(new Shui(list_shui));
        // shuiBag.addState(new xiongState());
        bags.add(shuiBag);
    }
}
