package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.renderscript.BaseObj;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.Model.State;

public class BaseBossGif {

    GifObj obj;
    GifAllBitmaps allBitmaps;

    int state=  State.Stop;
    CopyOnWriteArrayList<Bitmap> bitmaps;
    public BaseBossGif(GifObj obj, GifAllBitmaps allBitmaps) {
        this.obj = obj;
        this.allBitmaps = allBitmaps;
       if (state==State.Stop)     bitmaps=allBitmaps.getxiong8stop(obj.oW,obj.oH);
       if (state==State.Move)     bitmaps=allBitmaps.getxiong8Move(obj.oW,obj.oH);
       if (state==State.Att)     bitmaps=allBitmaps.getxiong8attker(obj.oW,obj.oH);

    }

    public void changState(int state){
        if (state==State.Stop)     bitmaps=allBitmaps.getxiong8stop(obj.oW,obj.oH);
        if (state==State.Move)     bitmaps=allBitmaps.getxiong8Move(obj.oW,obj.oH);
        if (state==State.Att)     bitmaps=allBitmaps.getxiong8attker(obj.oW,obj.oH);
    }

    int time=0;
    int i=0;
    int j=0;
    public void drawCanvas(Canvas canvas){
if (bitmaps.size()==0)return;

        j++;
       i=time%bitmaps.size();
        Iterator<Bitmap> iterator = bitmaps.iterator();
        while (iterator.hasNext()){
            Bitmap next = iterator.next();
           canvas.drawBitmap(bitmaps.get(i),obj.oX,obj.oY,null);
        }
     if (j%10==0) time++;
     if (j%20==0)changState(State.Att);
     if (j%40==0)changState(State.Move);
     if (j%60==0)changState(State.Stop);


    }
}
