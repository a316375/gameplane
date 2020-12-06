package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import xyxgame.gameplane.GL.BTMAP;
import xyxgame.gameplane.R;

public class BG {
    private Bitmap bitmap;
    private int y1,y2,screenSizeX,screenSizeY;


    public BG(Context context, BTMAP btmap,int screenSizeX, int screenSizeY) {
        this.bitmap  =btmap.getBitmaps().get(8);
       bitmap=Bitmap.createScaledBitmap(bitmap,screenSizeX,screenSizeY,false);
        y2 = y1 -bitmap.getHeight();
        this. screenSizeX=screenSizeX;
        this. screenSizeY=screenSizeY;
    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,0,y1,new Paint());
        canvas.drawBitmap(bitmap,0,y2,new Paint());
        update();
    }

    public void update(){
        y1 +=2;
        y2 +=2;
        if(y1>screenSizeY){
            y1 = y2 -bitmap.getHeight();
        }
        if (y2>screenSizeY){
            y2 = y1 - bitmap.getHeight();
        }
    }






}
