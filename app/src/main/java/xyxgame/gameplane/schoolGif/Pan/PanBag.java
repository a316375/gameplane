package xyxgame.gameplane.schoolGif.Pan;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class PanBag extends BaseGifBag implements BaseGifBagPath {
    public PanBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public void drawpath() {

    }
}
