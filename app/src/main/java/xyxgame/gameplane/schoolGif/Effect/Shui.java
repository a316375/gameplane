package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;

public class Shui implements ShuiEffect{
    public  GifAllBitmaps bitmaps;

    public CopyOnWriteArrayList<Bitmap> list;
    public   BaseGifBag baseGifBag;
    private Matrix matrix;

//    public Shui(GifAllBitmaps bitmaps) {
//        this.bitmaps = bitmaps;
//
//        list=bitmaps.getlaser08(100,50);
//
//
//    }


    public Shui(CopyOnWriteArrayList<Bitmap> list) {
        this.list = list;
        matrix = new Matrix();
    }

    @Override
    public void draw(Canvas canvas) {
        if (list.size()==0||baseGifBag==null)return;

        if (time>Maxtime)ok=false;
       if (ok){
//           canvas.drawBitmap(list.get(0),x,y,null);
           canvas.drawBitmap(list.get(i%list.size()),matrix,null);
        if (time%3==0)  i++;
           time++;}

    }


   public int Maxtime,i=0,time=0;

    boolean ok;

    int x;
    int y;
    @Override
    public void add(BaseGifBag baseGifBag, int time) {
        this.baseGifBag=baseGifBag;
        this.Maxtime=time;
        ok=true;
        x=baseGifBag.x+baseGifBag.obj.oW/2-50;
        y=baseGifBag.y+baseGifBag.obj.oH-50;


        if (baseGifBag.obj.oH>100){
        // 根据传入的参数设置缩放比例
        matrix.setScale(2, 2);
        y-=50;
        x-=50;

        }else  { matrix.setScale(1, 1);}
        matrix.postTranslate(x,y);
    }

    @Override
    public void stop_shui() {
       ok=false;


    }

    @Override
    public void reset_time() {
        time=0;


    }
}
