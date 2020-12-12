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


    private float[]  afP = new float[]{0f, 0f};;
    private Path path;
    private Paint paint;
    private PathMeasure pm;
    private float fSegmentLen;

   public int stoplen=new Random().nextInt(point.x);


    public StudentB withLen(int startx,int stopx){

        this.startx=startx;
        this.stopx=stopx;
        mx_BaseStudent =startx;
        my_BaseStudent =starty;
        stoplen=new Random().nextInt(point.x/3)+point.x/3;//屏幕的终点就是1/3-2/3的位置
        leftOrRight=new Random().nextInt(2);//生成随机看是左边还是右边



        return this;
    }

    public StudentB(BaseBag baseBag) {
        super(  baseBag);
//        mx_BaseStudent =point.x/2;
        mx_BaseStudent =startx;
        my_BaseStudent =starty;

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);

        //小球跟随路径移动
        pm = new PathMeasure(path, false);


    }

    int startx=0, starty=0, stopx=point.x ,stopy=0;




    int leftOrRight=0 ;

    @Override
    public void draw(Canvas canvas) {


    if (is_over==true) return;
        path = new Path();
    if (leftOrRight==0){
        path.moveTo(startx, starty);
        path.lineTo(stopx, stopy);}
    else
       {

           path.moveTo(stopx-bitmap.getWidth(), stopy);
           path.lineTo(startx, starty);
       }

       //  canvas.drawPath(path, paint);

        pm = new PathMeasure(path, false);

        //we'll get 200 points from path to animate the circle
     if (leftOrRight==0)  fSegmentLen = pm.getLength() / 2000;
    else   fSegmentLen = pm.getLength() / 1000;

        if (afP[0]!=0)
       //canvas.drawBitmap(bitmap, afP[0], afP[1], paint);
       super.draw(canvas);
    }

    int iCurStep = 0;// current animation step
    @Override
    public void drawXP() {

        starty+=2;stopy+=2;



//让他移动到屏幕随机的地方停下来
        if (iCurStep <= stoplen) {
            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
            iCurStep++;
            // invalidate();
        } else {
            iCurStep = stoplen;
            isEating=true;
        }


      if (iCurStep!=0){
         mx_BaseStudent=afP[0];
         my_BaseStudent=afP[1];}

        // if (mx_BaseStudent>point.x)is_over=true;





    }


}
