package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class FireBag extends BaseGifBag {

    public FireBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
        FireTime=new Random().nextInt(100);


    }


    @Override
    public void drawpath() {

        y+= ShuXin.Speed;
    }
}
