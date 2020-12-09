package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;

public abstract class BaseStudent {


    public Bitmap bitmap;
    public int mx,my;
    public Point point;
    public boolean is_over=false;

    public BaseStudent(BaseBag baseBag) {
        bitmap=baseBag.bitmap;
        point=baseBag.activity.point;
        mx=point.x/2;
        my=point.y-bitmap.getHeight()-200;
   }

   public void draw(Canvas canvas){
        if (!bitmap.isRecycled())
        canvas.drawBitmap(bitmap,mx,my,null);
   }

   public void upXY(){
        drawXP();
      if (my<-100||mx<-100)is_over=true;
   }

    public abstract  void drawXP();

}

