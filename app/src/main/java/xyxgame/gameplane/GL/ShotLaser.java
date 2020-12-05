package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import xyxgame.gameplane.spaceshooter.SoundPlayer;

public class ShotLaser extends Shot {
    public ShotLaser(Context context, BTMAP btmaps, int screenSizeX, int screenSizeY, SoundPlayer soundPlayer) {
        super(context, btmaps, screenSizeX, screenSizeY, soundPlayer);
        setBitmap(btmaps.getBitmaps().get(2));//2
        setBitmap( Bitmap.createScaledBitmap(bitmap,getBitmap().getWidth()/2,getBitmap().getHeight()/2,false));;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas, paint);
        upXY();
    }

    public void upXY() {

        mY-=20;
        if (mY<0)mY=screenSizeY;

    }
}
