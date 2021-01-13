package xyxgame.gameplane.schoolGif.Enemy.gk01;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseState;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.Model.State;

public class xiongState implements BaseState {




    @Override
    public void changState(int state,BaseGifBag baseGifBag,GifAllBitmaps gifAllBitmaps) {

//        Log.v("-----","---熊状态----"+state);
//        if (gifAllBitmaps==null)return;
        if (state== State.Stop){baseGifBag.state=State.Stop;baseGifBag.list=gifAllBitmaps.getxiong8stop(baseGifBag.w,baseGifBag.h);}
        if (state== State.Move){baseGifBag.state=State.Move;baseGifBag.list=gifAllBitmaps.getxiong8Move(baseGifBag.w,baseGifBag.h);}
        if (state== State.Att){baseGifBag.state=State.Att;baseGifBag.list=gifAllBitmaps.getxiong8attker(baseGifBag.w,baseGifBag.h);}
    }
}
