package xyxgame.gameplane.GL;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import xyxgame.gameplane.spaceshooter.Laser;

public class BOSS    {

    Bitmap bitmap;
    int mX,mY;
    int MoveX1,MoveX2;

    public BOSS(BTMAP btmap,Point point) {
        this.bitmap = btmap.getBitmaps().get(6);
        bitmap=Bitmap.createScaledBitmap(bitmap,250,250,false);
        this.mX=point.x;
        this.mY=point.y;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,mX,mY,new Paint());
    }
}



