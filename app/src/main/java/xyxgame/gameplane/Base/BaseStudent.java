package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class BaseStudent {
    public Bitmap bitmap;
    public int mx,my;
    public BaseStudent(BaseBag baseBag) {
        bitmap=baseBag.bitmap;
        mx=500;
        my=1000;
   }

   public void draw(Canvas canvas){
        if (!bitmap.isRecycled())
        canvas.drawBitmap(bitmap,mx,my,null);
   }

   public void upXY(){
        drawXP();
       if (my<-100||mx<-100)bitmap.recycle();
   }

    public abstract  void drawXP();

}

