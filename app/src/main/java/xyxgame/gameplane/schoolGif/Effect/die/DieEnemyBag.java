package xyxgame.gameplane.schoolGif.Effect.die;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class DieEnemyBag extends BaseGifBag {
    public DieEnemyBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
    }

    @Override
    public void drawpath() {
        y+= ShuXin.Speed;

    }
}
