package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class BaseStudent {
    public Bitmap bitmap;
    public int mx,my;
    public BaseStudent(Activity activity, int draw) {
        bitmap=BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(),draw,200,200);
        mx=0;
        my=0;
   }

   public void draw(Canvas canvas){
        if (!bitmap.isRecycled())
        canvas.drawBitmap(bitmap,mx,my,null);
   }

    public abstract  void UPXP();

}

