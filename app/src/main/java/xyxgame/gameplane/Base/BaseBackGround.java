package xyxgame.gameplane.Base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import xyxgame.gameplane.R;

public class BaseBackGround {
    private Bitmap bitmap;
    private int y1,y2,screenSizeX,screenSizeY;
    BaseActivity baseActivity;

    public BaseBackGround(BaseActivity baseActivity, int draw ) {
        this.baseActivity=baseActivity;
        this. screenSizeX=baseActivity.point.x;
        this. screenSizeY=baseActivity.point.y;
        this.bitmap  = BitmapUtils.decodeSampledBitmapFromResource(baseActivity.getResources(),draw,screenSizeX,screenSizeY);
        bitmap=Bitmap.createScaledBitmap(bitmap,screenSizeX,screenSizeY+250,false);
        y2 = y1 -bitmap.getHeight();

    }


    public void updataBG(int level){
        //第二地图
        if (level==2){
            this.bitmap  = BitmapUtils.decodeSampledBitmapFromResource(baseActivity.getResources(), R.drawable.bg3,screenSizeX,screenSizeY);
            bitmap=Bitmap.createScaledBitmap(bitmap,screenSizeX,screenSizeY+250,false);
            y2 = y1 -bitmap.getHeight();

        }


    }

    public void drawCanvas(Canvas canvas){

        canvas.drawBitmap(bitmap,0,y1,null);
        canvas.drawBitmap(bitmap,0,y2,null);
        updateXY();
    }

    public void updateXY(){
        y1 +=2;
        y2 +=2;
        if(y1>screenSizeY+250){
            y1 = y2 -bitmap.getHeight();
        }
        if (y2>screenSizeY+250){
            y2 = y1 - bitmap.getHeight();
        }
    }






}
