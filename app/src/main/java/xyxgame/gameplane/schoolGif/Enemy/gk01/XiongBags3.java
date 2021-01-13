package xyxgame.gameplane.schoolGif.Enemy.gk01;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class XiongBags3 extends XiongBags {
    public XiongBags3(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public void drawpath() {
        y+=obj.speed;
        // x-=2;
    }
}
