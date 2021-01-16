package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBossBags;

public class ShuiBossBag extends XiongBossBags {
    public ShuiBossBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);

        //matrix_degress=180;
    }

    @Override
    public void drawpath() {

        y+=obj.speed;
    }

    @Override
    public void setRect(int x, int y, int w, int h) {
        rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);
    }


}
