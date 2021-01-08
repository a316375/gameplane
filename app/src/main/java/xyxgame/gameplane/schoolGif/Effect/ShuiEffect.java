package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.renderscript.BaseObj;
import android.util.Log;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathMu;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UIPaint;
import xyxgame.gameplane.schoolGif.Tool.UiThead;

public interface ShuiEffect {
    void draw(Canvas canvas);
    void add(BaseGifBag gifBag,int time);
    void stop_shui();
    void reset_time();

}