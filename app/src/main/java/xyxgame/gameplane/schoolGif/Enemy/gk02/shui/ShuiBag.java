package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;
import android.graphics.Path;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk02.GK2_XiongBags2;

public class ShuiBag extends GK2_XiongBags2 {
    public ShuiBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
        Beser_path = new Path();
        Beser_path.moveTo(x, y);
        Beser_path.quadTo(obj.maXx*3/4, obj.maXy/2, obj.maXx, 0);
        Beser_path.quadTo(0,  obj.maXy/2, -obj.oW-10, 0);
        beser_speed=400;
    }




    @Override
    public void setRect(int x, int y, int w, int h) {
          rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);

    }
}
