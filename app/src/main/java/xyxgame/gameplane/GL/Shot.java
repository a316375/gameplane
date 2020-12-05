package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import xyxgame.gameplane.spaceshooter.Player;
import xyxgame.gameplane.spaceshooter.SoundPlayer;

public class Shot   {


    Context context;

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    Bitmap bitmap;

   int mX,mY;
    BTMAP btmap;int screenSizeX;int screenSizeY;SoundPlayer soundPlayer;
    public Shot(Context context, BTMAP btmap, int screenSizeX, int screenSizeY, SoundPlayer soundPlayer) {
        this.context = context;
        this.btmap = btmap;
        this.screenSizeX = screenSizeX;
        this.screenSizeY = screenSizeY;
        this.soundPlayer = soundPlayer;
        bitmap=btmap.getBitmaps().get(7);//7
        mX = screenSizeX/2 - bitmap.getWidth()/2;
        mY = screenSizeY - bitmap.getHeight() -200;

    }

    public int getY() {
        return mY;
    }

    public int getX() {
        return mX;
    }

    public void update(int pointXFix, int pointYFix) {
        mX=pointXFix;
        mY=pointYFix;
    }




    public void draw(Canvas canvas, Paint paint){
        if (!bitmap.isRecycled()){
            canvas.drawBitmap(bitmap,mX,mY,paint);}
    }



}

