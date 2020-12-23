package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class ShuiBag extends BaseGifBag {
    public int showTime;
    public int time=0;



    public BaseGifBag withShowTime(int showTime){
       this.showTime=showTime;
        return this;
    }
    public ShuiBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
       super(obj, list);
       i=0;


    }

    @Override
    public void drawpath() {

    }


}
