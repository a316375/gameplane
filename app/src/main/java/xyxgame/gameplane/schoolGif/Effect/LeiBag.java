package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class LeiBag extends BaseGifBag {


    public LeiBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);

        showMaxtime=10;

    }


    @Override
    public void drawpath() {

        y-= ShuXin.Speed*2;

    }
}
