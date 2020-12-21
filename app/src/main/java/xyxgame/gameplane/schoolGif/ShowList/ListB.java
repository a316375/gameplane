package xyxgame.gameplane.schoolGif.ShowList;

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
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class ListB {

   public ArrayList<BaseStopBitmap> list;
   public   ArrayList<Rect> rects;
    private final Paint mPaint;
    private final int max;
    private final int may;
    private final Paint mPaint2;



    public ListB(BaseActivity baseActivity) {
//        super(baseActivity, R.drawable.meteor_1, new Point(500,500), 200, 200);
        list=new ArrayList<>();
        rects=new ArrayList<>();

        max = baseActivity.point.x/2;
        may = baseActivity.point.y/2;
        list.add(new BaseStopBitmap(baseActivity, R.drawable.list_a01, new Point(max -50-160*2, may -210), 100, 100).withShuxin(ShuXin.Jin));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.list_a02, new Point(max -50-160, may -210), 100, 100).withShuxin(ShuXin.Mu));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.list_a03, new Point(max -50, may -210), 100, 100).withShuxin(ShuXin.Shui));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.list_a04, new Point(max +50+60, may -210), 100, 100).withShuxin(ShuXin.Huo));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.list_a05, new Point(max +50+60*2+100, may -210), 100, 100).withShuxin(ShuXin.Tu));




        for (BaseStopBitmap baseStopBitmap:list){
            rects.add(baseStopBitmap.rect);
        }


        //设置无锯齿 也可以使用setAntiAlias(true)
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);//设置画笔颜色
        mPaint.setAlpha(100);
        mPaint.setStrokeWidth(1.5f);//设置线宽
        mPaint.setStyle(Paint.Style.FILL);//设置样式：FILL表示颜色填充整个；STROKE表示空心


        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setColor(Color.YELLOW);//设置画笔颜色
        mPaint2.setStyle(Paint.Style.FILL);  // 填充模式 - 描边
        mPaint2.setStrokeWidth(10);
        mPaint2.setTextSize(50);

    }

    public void draws(Canvas canvas){
        if (list.size()<=0)return;
        canvas.drawRoundRect(new RectF(max-430, may-270, max+430, may+270), 50, 50, mPaint);



        canvas.drawText(ShuXin.ListB_title,max-230,may-250,mPaint2);

        for (BaseStopBitmap baseStopBitmap:list){
            baseStopBitmap.draws(canvas);
           }


    }
}
