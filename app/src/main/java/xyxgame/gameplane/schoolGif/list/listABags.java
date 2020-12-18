package xyxgame.gameplane.schoolGif.list;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class listABags extends BaseGifBag {
    public listABags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public void drawpath() {

        //x+=5;
    }
}
