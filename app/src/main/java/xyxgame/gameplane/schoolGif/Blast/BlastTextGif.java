package xyxgame.gameplane.schoolGif.Blast;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.Base.BaseActivity;



////****绘制伤害****/////



public class BlastTextGif  {



    public  CopyOnWriteArrayList<BlastBag> bags;
    public void addBag(int hit,int x,int y){
           bags.add(new BlastBag(hit,new Point(x,y)));
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
//        typeFace = Typeface.createFromAsset(baseActivity.getAssets(),"fzktj.ttf");
        paint.setTypeface(typeFace);
  }


    public void draws(Canvas canvas){
        if (bags.size()<=0)return;



        Iterator<BlastBag> iterator = bags.iterator();
        while (iterator.hasNext()){
            BlastBag next = iterator.next();
            next.size+=5;

            paint.setTextSize(next.size);
            canvas.drawText("-"+ next.hit,next.point.x,next.point.y,paint);
            next.point.y--;
            if (next.size>100){next.size=0;bags.remove(next);}

           // next.point.y-=2;
        }







    }


}
