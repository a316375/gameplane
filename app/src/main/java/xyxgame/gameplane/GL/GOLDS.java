package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class GOLDS {
    Bitmap bitmap;
    Point point;
    int mX,mY;

    public GOLDS(Context context,BTMAP btmap,int mX,int mY) {
        this.bitmap = btmap.getBitmaps().get(7);
        this.bitmap=Bitmap.createScaledBitmap(bitmap,100,100,false);
        this.mX=mX;
        this.mY=mY;
    }

    public void draw(Canvas canvas, Paint paint){
        if (!bitmap.isRecycled()) {
            canvas.drawBitmap(bitmap,mX,mY,paint);
        }
        mY+=10;
        if (mY>2500)bitmap.recycle();
    };

    public Bitmap getBitmap() {
        return bitmap;
    }
}
