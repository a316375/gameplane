package xyxgame.gameplane.GIf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;


import java.util.Random;

import xyxgame.gameplane.Base.BaseActivity;

public class TextDraw  {
    private BaseActivity baseActivity;


    private int hit;private int pointx;private int pointy;
    private Typeface typeFace;

    public TextDraw(BaseActivity baseActivity,int hit,int pointx,int pointy) {
        this.baseActivity=baseActivity;
        this.hit=hit;
        this.pointx=pointx;
        this.pointy=pointy;
        typeFace = Typeface.createFromAsset(baseActivity.getAssets(),"xyx.ttf");

    }


    private int j=0;


    private boolean over=false;

    public void draw(Canvas canvas){
        if (!baseActivity.start)return;

        if (over)return;


         j+=5;

        if (j>150){j=0;over=true;}

        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);  // 填充模式 - 描边
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setTextSize(j);


        paint.setTypeface(typeFace);

        canvas.drawText("-"+hit,pointx,pointy,paint);
        pointx+=2;
        pointy--;





    }
}
