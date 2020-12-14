package xyxgame.gameplane.GIf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.R;

public class BaseGIF {

    public void setBitmaps(CopyOnWriteArrayList<Bitmap> bitmaps) {
        this.bitmaps = bitmaps;
    }

    public CopyOnWriteArrayList<Bitmap>  bitmaps;

    public BaseGIF(Activity mActivity,CopyOnWriteArrayList<Bitmap>  bitmaps,int x,int y,int time) {
        this.xX=x;
        this.xY=y;
        this.time=time;
        this. bitmaps =bitmaps;


    }

    private int j =0;private int i=0; int time;

    int xX,xY;



   int iCurStep =0; int stopx=new Random().nextInt(1000);int stopy=new Random().nextInt(1000);
    public void draw(Canvas canvas){
        if (bitmaps.size()==0)return;
        j++;
         i=i%bitmaps.size();

       canvas.drawBitmap((Bitmap) bitmaps.get(i),xX,xY,null);

        if (j %time==0)i++;
        if (j >1000) j =0;




        //以下是路径，待封装

        Point a=new Point(xX,xY);
        Point b=new Point(stopx,stopy);
        xY+=2;
        stopy+=2;

        Path sPath = new Path();
        sPath.moveTo(a.x, a.y);
        sPath.lineTo(b.x, b.y);
        PathMeasure pm = new PathMeasure(sPath, false);
        Paint pathPaint = new Paint();
        pathPaint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
        pathPaint.setStrokeWidth(1);
        pathPaint.setColor(Color.BLUE);

        canvas.drawPath(sPath,pathPaint);

        float fSegmentLen = pm.getLength() / 2000;//we'll get 20 points from path to animate the circle
        float afP[] = {0f, 0f};

        if (iCurStep <=300) {
            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
           //canvas.drawBitmap((Bitmap) bitmaps.get(i),xX,xY,null);
          xX= (int) afP[0];xY= (int) afP[1];
          if (j %time==0)   iCurStep++;
            // invalidate();
        } else {
            iCurStep = 300;
        };







    }
}
