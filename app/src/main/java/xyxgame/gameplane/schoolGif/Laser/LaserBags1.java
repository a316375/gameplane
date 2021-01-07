package xyxgame.gameplane.schoolGif.Laser;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public  class LaserBags1 extends BaseGifBag implements BaseGifBagPath {


    public LaserBags1(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);


    }

    @Override
    public void setRect(int x, int y, int w, int h) {
       // super.setRect(x, y, w, h);
        rect.set(x+this.w/3, y+this.h/2, w-this.w/3, h-this.h/4);
    }

    @Override
    public   void drawpath() {
        x+=obj.speed/5;
        y-=obj.speed;
    }



}