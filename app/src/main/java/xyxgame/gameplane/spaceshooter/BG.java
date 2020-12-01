package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import xyxgame.gameplane.R;

public class BG {
    private Bitmap bitmap;
    private int y1,y2,screenSizeX,screenSizeY;


    public BG(Context context,int screenSizeX, int screenSizeY) {
        this.bitmap  = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg2);
        y2 = y1 -bitmap.getHeight();
        this. screenSizeX=screenSizeX;
        this. screenSizeY=screenSizeY;
    }



    public void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(bitmap,0,y1,paint);
        canvas.drawBitmap(bitmap,0,y2,paint);
        update();
    }

    public void update(){
        y1 +=1;
        y2 +=1;
        if(y1>screenSizeY){
            y1 = y2 -bitmap.getHeight();
        }
        if (y2>screenSizeY){
            y2 = y1 - bitmap.getHeight();
        }
    }






}
