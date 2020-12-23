package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

public interface BaseState {
    //**修改状态**///
    void changState(int state,BaseGifBag baseGifBag,GifAllBitmaps gifAllBitmaps) ;
}
