package xyxgame.gameplane.schoolGif.Enemy.shui;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class ShuiBag extends BaseGifBag {
    public ShuiBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }


    @Override
    public void drawpath() {
        y+=10;

    }

    @Override
    public void setRect(int x, int y, int w, int h) {
          rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);

    }
}
