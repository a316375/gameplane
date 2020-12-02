package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Shot {
    int x;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Bitmap bitmap;

    public Shot(Context context,int x, int y, int draw) {
        this.x = x;
        this.y = y;
        bitmap = BitmapFactory.decodeResource(context.getResources(),draw);
    }


    public void upXY(){
        setX(x+1);
        setY(y+1);
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

}
