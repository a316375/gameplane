package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import xyxgame.gameplane.spaceshooter.Laser;
import xyxgame.gameplane.spaceshooter.SoundPlayer;

public class ShotLaser extends Shot {

      Rect rect;
      private Bitmap bitmap;

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    public ShotLaser(Context context, BTMAP btmaps, int screenSizeX, int screenSizeY, SoundPlayer soundPlayer, Shot shot) {
        super(context, btmaps, screenSizeX, screenSizeY, soundPlayer);
        mX=shot.mX+shot.getBitmap().getWidth()/2;
        mY=shot.mY;




        bitmap=btmaps.getBitmaps().get(2);

        bitmap= Bitmap.createScaledBitmap(bitmap,100,200,false);;
        rect = new Rect(mX,mY,mX+bitmap.getWidth(),mY+bitmap.getHeight());

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        if (!bitmap.isRecycled()){
            canvas.drawBitmap(bitmap,mX,mY,paint);
            upXY();
         }

    }


    public void upXY() {

         mY-=20;
        rect.set(mX,mY,mX+bitmap.getWidth(),mY+bitmap.getHeight());
        if (mY<0){bitmap.recycle();}
    }


    public void destory(ArrayList<SpriteManager> spriteManagers){
        {
            if (!bitmap.isRecycled()){

                if (rect.left<0||rect.right<0)bitmap.recycle();


                if (spriteManagers!=null&&!bitmap.isRecycled()){

                    for (Iterator<SpriteManager> it = spriteManagers.iterator(); it.hasNext(); ) {
                        SpriteManager s = (SpriteManager) it.next();
                        if (Rect.intersects(s.rect,rect)){
                            if (new Random().nextInt(100)==8) { bitmap.recycle();}
                            it.remove();
                        }
                    }


                }
            }
        }
    }
}
