package xyxgame.gameplane.school;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.GL.BTMAP;

public class BackGround {
    private Bitmap bitmap;
    private int y1,y2,screenSizeX,screenSizeY;


    public BackGround(BaseActivity baseActivity, int draw ) {
        this. screenSizeX=baseActivity.point.x;
        this. screenSizeY=baseActivity.point.y;
        this.bitmap  = BitmapUtils.decodeSampledBitmapFromResource(baseActivity.getResources(),draw,screenSizeX,screenSizeY);
        bitmap=Bitmap.createScaledBitmap(bitmap,screenSizeX,screenSizeY,false);
        y2 = y1 -bitmap.getHeight();

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
