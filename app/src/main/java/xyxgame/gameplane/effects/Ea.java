package xyxgame.gameplane.effects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import xyxgame.gameplane.GL.BTMAP;
import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.HuDie;

public class Ea  extends HuDie {

    public void setmX(int mX) {
        this.mX = mX;
    }

    private int mX;

    public void setmY(int mY) {
        this.mY = mY;
    }

    private int mY;
    private int mSpeed=1;

    public Rect getmCollision() {
        return mCollision;
    }

    private Rect mCollision;

    public Ea(Context context, BTMAP btmap) {
        super(context,btmap,5,13);
        mX = 200;

        mCollision = new Rect(mX, mY, mX + getResult(1).getWidth(), mY + getResult(1).getHeight());

    }

    public void update(){
        mY += 5 * mSpeed;//下落动画

        mCollision.left = mX;
        mCollision.top = mY;
        mCollision.right = mX + getResult(1).getWidth();
        mCollision.bottom = mY + getResult(1).getHeight();


    }

    public int getmX() {
        return mX;
    }

    public int getmY() {
        return mY;
    }

    
}
