package xyxgame.gameplane.schoolGif.Laser;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public  class LaserBags extends BaseGifBag {


    public LaserBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public   void drawpath() {
        y-=obj.speed;
    }
}