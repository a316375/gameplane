package xyxgame.gameplane.schoolGif.Play;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class PlayBags extends BaseGifBag implements BaseGifBagPath {
    public PlayBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public void drawpath() {

    }


}
