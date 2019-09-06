package xyxgame.gameplane.GameActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import xyxgame.gameplane.spaceshooter.Laser;

import java.util.ArrayList;

import xyxgame.gameplane.R;

public class Play {
    private Bitmap mBitmap;

    private int mX;
    private int mY;
    private int mSpeed;
    private int mMaxX;
    private int mMinX;
    private int mMaxY;
    private int mMinY;
    private int mMargin = 16;
    private boolean mIsSteerLeft, mIsSteerRight;
    private float mSteerSpeed;
    private Rect mCollision;
    private ArrayList<Laser> mLasers;

    private Context mContext;
    private int mScreenSizeX, mScreenSizeY;

    public Play(Context context, int screenSizeX, int screenSizeY ) {
        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;
        mContext = context;

        mSpeed = 1;
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.spaceship_1_blue);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 3/5, mBitmap.getHeight() * 3/5, false);

        mMaxX = screenSizeX - mBitmap.getWidth();
        mMaxY = screenSizeY - mBitmap.getHeight();
        mMinX = 0;
        mMinY = 0;

        mX = screenSizeX/2 - mBitmap.getWidth()/2;
        mY = screenSizeY - mBitmap.getHeight() - mMargin-200;

        mLasers = new ArrayList<>();


        mCollision = new Rect(mX, mY, mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
    }

    public void update(){
        //玩家位置更新
        if (mIsSteerLeft){
            mX -= 10 * mSteerSpeed;
            if (mX<mMinX){
                mX = mMinX;
            }
        }else if (mIsSteerRight){
            mX += 10 * mSteerSpeed;
            if (mX>mMaxX){
                mX = mMaxX;
            }
        }

        mCollision.left = mX;
        mCollision.top = mY;
        mCollision.right = mX + mBitmap.getWidth();
        mCollision.bottom = mY + mBitmap.getHeight();

        //武器位置更新
        for (Laser l : mLasers) {
            l.update();
        }

        //武器移除
        boolean deleting = true;
        while (deleting) {
            if (mLasers.size() != 0) {
                if (mLasers.get(0).getY() < 0) {
                    mLasers.remove(0);
                }
            }

            if (mLasers.size() == 0 || mLasers.get(0).getY() >= 0) {
                deleting = false;
            }
        }
    }

    //玩家的武器Laser列表
    public ArrayList<Laser> getLasers() {
        return mLasers;
    }

    //玩家开火
    public void fire(){
        mLasers.add(new Laser(mContext, mScreenSizeX, mScreenSizeY, mX, mY, mBitmap, false));

    }

    public Rect getCollision() {
        return mCollision;
    }

    public void setmX(int mX) {
        this.mX = mX;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }

    //玩家右边移动
    public void steerRight(float speed){
        mIsSteerLeft = false;
        mIsSteerRight = true;
        mSteerSpeed = Math.abs(speed);
    }

    //玩家左边移动
    public void steerLeft(float speed){
        mIsSteerRight = false;
        mIsSteerLeft = true;
        mSteerSpeed = Math.abs(speed);
    }

    //静止不动
    public void stay(){
        mIsSteerLeft = false;
        mIsSteerRight = false;
        mSteerSpeed = 0;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public int getSpeed() {
        return mSpeed;
    }


    public void update(int x, int y) {
        mX=x;
        mY=y;

    }
}
