package xyxgame.gameplane.school.Students;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Log;
import android.view.View;

import java.util.Random;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentB extends BaseStudent {


    private float[] afP;
    private Path path;

    public StudentB(BaseBag baseBag) {
        super(  baseBag);
        mx_BaseStudent =point.x/2;
        my_BaseStudent =0;


    }


    int starty=50,stopy=50;
    int iCurStep = 0;// current animation step

    int j=0,m=0;

    @Override
    public void draw(Canvas canvas) {


if (is_over==false) {
    Paint paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
    paint.setStrokeWidth(5);
    paint.setColor(Color.RED);
    path = new Path();

    path.moveTo(0, starty);
    path.lineTo(point.x*2, stopy);


    canvas.drawPath(path, paint);

    //小球跟随路径移动
    PathMeasure pm = new PathMeasure(path, false);
    float fSegmentLen = pm.getLength() / 1000;//we'll get 200 points from path to animate the circle
    afP = new float[]{0f, 0f};


    if (iCurStep <= 1000) {
        boolean posTan = pm.getPosTan(fSegmentLen * iCurStep, afP, null);
        // canvas.drawCircle(afP[0], afP[1],20,paint);
        canvas.drawBitmap(bitmap, afP[0], afP[1], paint);
        if (j < afP[0]) j++;
        if (m < afP[1]) j++;

        iCurStep++;
        // invalidate();
    } else {
        Log.e("draw: ", j + "---" + m);

        iCurStep = 0;
    }
    ;
}
       // super.draw(canvas);
    }

    @Override
    public void drawXP() {

         starty+=2;stopy+=2;

         mx_BaseStudent=afP[0];
         my_BaseStudent=afP[1];

         if (mx_BaseStudent>point.x)is_over=true;





    }


}
