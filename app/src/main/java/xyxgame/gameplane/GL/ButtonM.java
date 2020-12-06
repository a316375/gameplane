package xyxgame.gameplane.GL;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class ButtonM {
    Bitmap bitmap;
    int mX,mY;
    Onclick onclick;
    ButtonM buttonM;
    Point point;

    Rect rect;
    public ButtonM(Point point, BTMAP btmap) {
        this.point=point;
        this.mX = point.x;
        this.mY = point.y;
        this.bitmap = btmap.getBitmaps().get(7);
        this.bitmap= Bitmap.createScaledBitmap(bitmap,100,100,false);
        this.buttonM=this;
        rect=new Rect(mX,mY,mX+bitmap.getWidth(),mY+bitmap.getHeight());

    }

    public void draw(Canvas canvas, Paint paint){
        if (!bitmap.isRecycled()) {
            canvas.drawBitmap(bitmap,mX,mY,paint);
        }
    }

    public void setOnclickListener(Onclick onclick){
        this.onclick=onclick;
    }

    interface Onclick{
        void setOnClickLister(boolean success);
    }
}
