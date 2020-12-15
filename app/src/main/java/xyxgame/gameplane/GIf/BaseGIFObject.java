package xyxgame.gameplane.GIf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
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

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.BezierUtil;
import xyxgame.gameplane.R;



/***一个基类，默认放置在顶部，不会移动，需要实现抽象方法去更新xx，xy等坐标**/
public abstract class BaseGIFObject {

    abstract void drawPath(Canvas canvas);
    public void setBitmaps(CopyOnWriteArrayList<Bitmap> bitmaps) {
        this.bitmaps = bitmaps;
    }

    public CopyOnWriteArrayList<Bitmap>  bitmaps;

    public BaseGIFObject(CopyOnWriteArrayList<Bitmap>  bitmaps, int x, int y, int time) {
        this.xX=x;
        this.xY=y;
        this.time=time;
        this. bitmaps =bitmaps;


    }

    public int j =0;private int i=0; int time;

    int xX,xY;



    boolean drawOk=true;
   int iCurStep =0; int stopx=new Random().nextInt(1000);int stopy=new Random().nextInt(1000);
    public void draw(Canvas canvas){
        if (bitmaps.size()==0||drawOk==false)return;


        drawPath(canvas);

        j++;
         i=i%bitmaps.size();

      canvas.drawBitmap((Bitmap) bitmaps.get(i),xX,xY,null);

        if (j %time==0)i++;
        if (j >1000) j =0;




    }


    public   void moveToXY(int pointXFix, int pointYFix){
        xX=pointXFix;
        xY=pointYFix;
    };








    private void patha(Canvas canvas) {

        //以下是路径，待封装，负责计算坐标
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
            xX= (int) afP[0];xY= (int) afP[1];
            if (j %time==0)   iCurStep++;
            // invalidate();
        } else {
            iCurStep = 300;
        };
    }



     private void pathPF(Canvas canvas){
         Paint pathPaint = new Paint();
         pathPaint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
         pathPaint.setStrokeWidth(1);
         pathPaint.setColor(Color.BLUE);

         PointF a = new PointF(0,0);
         PointF b= new PointF(0,500);
         PointF c= new PointF(500,1000);
         PointF d= new PointF(1000,1000);
         PointF pointF = BezierUtil.calculateBezierPointForCubic(0.5f, a, b, c, d);
         Log.v("---","--"+pointF.x+"--"+pointF.y);

         canvas.drawCircle(pointF.x,pointF.y,2,pathPaint);
     }

    private void pathb(Canvas canvas) {

//        if (stopy>200)stopy-=2;
//        if (stopy<200)stopy+=2;
       // stopy+=2;

        //以下是路径，待封装，负责计算坐标
        Point a=new Point(xX,xY);
        Point b=new Point(stopx,stopy);





        Path sPath = new Path();

        sPath.moveTo(a.x, a.y);
        sPath.cubicTo(a.x,500,b.x, b.y,500,200);


        PathMeasure pm = new PathMeasure(sPath, false);
        Paint pathPaint = new Paint();
        pathPaint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
        pathPaint.setStrokeWidth(1);
        pathPaint.setColor(Color.BLUE);

        canvas.drawPath(sPath,pathPaint);

        float fSegmentLen = pm.getLength() / 2000;//we'll get 20 points from path to animate the circle
        float afP[] = {0f, 0f};

        if (iCurStep <=2000) {

//            stopx=new Random().nextInt(1000);
//            stopy=new Random().nextInt(1000)+500;
            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
            xX= (int) afP[0];xY= (int) afP[1];
            if (j %time!=0)    iCurStep++;
            // invalidate();
        } else {
            iCurStep = 2000;
            drawOk=false;
        };
    }



}
