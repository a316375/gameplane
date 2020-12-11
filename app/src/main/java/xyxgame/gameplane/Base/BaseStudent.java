package xyxgame.gameplane.Base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public abstract class BaseStudent {


    public Bitmap bitmap;
    public float mx_BaseStudent, my_BaseStudent;
    public Point point;
    public boolean is_over=false;
    BaseBag baseBag;

    public  BaseStudent onBuildXY(BaseStudent baseStudent){
        mx_BaseStudent=baseStudent.mx_BaseStudent+baseBag.bitmap.getWidth();
        my_BaseStudent=baseStudent.my_BaseStudent-baseBag.bitmap.getHeight();
        return this;
    };

    public BaseStudent(BaseBag baseBag) {
        this.baseBag=baseBag;
        bitmap=baseBag.bitmap;
        point=baseBag.activity.point;
        mx_BaseStudent =point.x/2;
        my_BaseStudent =point.y-bitmap.getHeight()-200;
   }

   public void draw(Canvas canvas){
        if (!bitmap.isRecycled())
        canvas.drawBitmap(bitmap, mx_BaseStudent, my_BaseStudent,null);
   }

   public void upXY(){
        drawXP();
      if (my_BaseStudent <-100|| mx_BaseStudent <-100|| mx_BaseStudent >point.x|| my_BaseStudent >point.y)is_over=true;
   }

    public abstract  void drawXP();


    public void  moveToXY(int x, int y){
        mx_BaseStudent =x;
        my_BaseStudent =y;

    }

}

