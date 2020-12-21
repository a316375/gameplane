package xyxgame.gameplane.schoolGif.Blast;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class BlastTextGif  {



    public  CopyOnWriteArrayList<BlastBags> bags;
    public void addBags(BlastBags bag){
           bags.add(bag);
           }
    Paint paint;
    private Typeface typeFace;
    BaseActivity baseActivity;
    public BlastTextGif(BaseActivity baseActivity) {
        this.baseActivity=baseActivity;
          bags=new CopyOnWriteArrayList<>();

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);  // 填充模式 - 描边
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setTextSize(150);
        typeFace = Typeface.createFromAsset(baseActivity.getAssets(),"xyx.ttf");
        paint.setTypeface(typeFace);
  }


    public void draws(Canvas canvas){
        if (bags.size()<=0)return;



        Iterator<BlastBags> iterator = bags.iterator();
        while (iterator.hasNext()){
            BlastBags next = iterator.next();
            next.size+=5;

            paint.setTextSize(next.size);
            canvas.drawText("-"+ next.hit,next.point.x,next.point.y,paint);
            next.point.y--;
            if (next.size>100){next.size=0;bags.remove(next);}

           // next.point.y-=2;
        }







    }


}
