package xyxgame.gameplane.schoolGif.Enemy;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class XiongBossBags extends XiongBags implements BaseGifBagPath {
    public XiongBossBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public void drawpath() {

        if (y<500)y+=2;

    }

    @Override
    public void setRect(int x, int y, int w, int h) {
        if (y<=450)  rect.set(-100, -100, -100, -100);//不可攻击
        if (y>450)   rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);
    }
}
