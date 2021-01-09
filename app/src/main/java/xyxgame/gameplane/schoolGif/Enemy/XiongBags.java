package xyxgame.gameplane.schoolGif.Enemy;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;
import xyxgame.gameplane.schoolGif.Effect.ShuiBag;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class XiongBags extends BaseGifBag implements BaseGifBagPath {



    public XiongBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list ) {
        super(obj, list);

    }


    @Override
    public void drawpath() {

        y+= obj.speed;
    }



    @Override
    public void setRect(int x, int y, int w, int h) {
        rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);

    }
}
