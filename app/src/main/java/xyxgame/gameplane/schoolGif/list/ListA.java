package xyxgame.gameplane.schoolGif.list;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.ArrayList;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;

public class ListA   {

   public ArrayList<BaseStopBitmap> list;
   public   ArrayList<Rect> rects;
    private final Paint mPaint;
    private final int max;
    private final int may;

    public ListA(BaseActivity baseActivity) {
//        super(baseActivity, R.drawable.meteor_1, new Point(500,500), 200, 200);
        list=new ArrayList<>();
        rects=new ArrayList<>();

        max = baseActivity.point.x/2;
        may = baseActivity.point.y/2;
        list.add(new BaseStopBitmap(baseActivity, R.drawable.c1, new Point(max -50-160*2, may -210), 100, 100,1));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.meteor_1, new Point(max -50-160, may -210), 100, 100,2));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.meteor_1, new Point(max -50, may -210), 100, 100,3));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.meteor_1, new Point(max +50+60, may -210), 100, 100,4));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.meteor_1, new Point(max +50+60*2+100, may -210), 100, 100,5));

        for (BaseStopBitmap baseStopBitmap:list){
            rects.add(baseStopBitmap.rect);
        }


        //设置无锯齿 也可以使用setAntiAlias(true)
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);//设置画笔颜色
        mPaint.setAlpha(100);
        mPaint.setStrokeWidth(1.5f);//设置线宽
        mPaint.setStyle(Paint.Style.FILL);//设置样式：FILL表示颜色填充整个；STROKE表示空心

    }

    public void draws(Canvas canvas){
        if (list.size()<=0)return;
        canvas.drawRoundRect(new RectF(max-430, may-270, max+430, may+270), 50, 50, mPaint);
        for (BaseStopBitmap baseStopBitmap:list){
            baseStopBitmap.draws(canvas);
           }


    }
}
