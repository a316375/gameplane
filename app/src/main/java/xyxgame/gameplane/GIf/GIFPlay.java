package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.concurrent.CopyOnWriteArrayList;


//**玩家的类，不需要实现抽象方法**//
public class GIFPlay extends BaseGIFObject {
    public GIFPlay(CopyOnWriteArrayList<Bitmap> bitmaps, int x, int y, int time) {
        super(bitmaps, x, y, time);
    }

    @Override
    void drawPath(Canvas canvas) {

    }


}
