package xyxgame.gameplane.GIf_v1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;

import java.util.concurrent.CopyOnWriteArrayList;


/**怪物A的路径**/


public class E1 extends BaseGIFObject {
    public E1(CopyOnWriteArrayList<Bitmap> bitmaps, int x, int y, int time) {
        super(  bitmaps, x, y, time);
    }

    @Override
    void drawPath(Canvas canvas) {

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

      //  canvas.drawPath(sPath,pathPaint);

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
}
