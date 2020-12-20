package xyxgame.gameplane.schoolGif.Blast;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class BlastBags   {

    int hit;
    Point point;

    int size=0;

    public BlastBags(int hit, Point point) {

        this.hit = hit;
        this.point = point;

    }


}
