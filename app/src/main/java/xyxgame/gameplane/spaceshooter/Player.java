package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;

import xyxgame.gameplane.GL.BTMAP;
import xyxgame.gameplane.R;

/**
 * Created on   : 8/11/2017
 * Developed by : Hendrawan Adi Wijaya
 * Github       : https://github.com/andevindo
 * Website      : http://www.andevindo.com
 */

public class Player extends HuDie{

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
    private SoundPlayer mSoundPlayer;
    private Context mContext;
    private int mScreenSizeX, mScreenSizeY;
    int mLevel =0;
    private BTMAP btmap;

    public void setmLevel(int mLevel) {
        this.mLevel = mLevel;
    }

    public int getmLevel() {
        return mLevel;
    }

    public Player(Context context, BTMAP btmap,int screenSizeX, int screenSizeY, SoundPlayer soundPlayer) {
        super(context,btmap,3,8);
        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;
        mContext = context;
        this.btmap=btmap;

        mSpeed = 1;
         mBitmap = getResult(0);


        mMaxX = screenSizeX - mBitmap.getWidth();
        mMaxY = screenSizeY - mBitmap.getHeight();
        mMinX = 0;
        mMinY = 0;

        mX = screenSizeX/2 - mBitmap.getWidth()/2;
        mY = screenSizeY - mBitmap.getHeight() - mMargin-200;

        mLasers = new ArrayList<>();
        mSoundPlayer = soundPlayer;

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

        mCollision.left = mX+ mBitmap.getWidth()*2/5;
        mCollision.top = mY;
        mCollision.right = mX + mBitmap.getWidth()- mBitmap.getWidth()*2/5;
        mCollision.bottom = mY + mBitmap.getHeight()-mBitmap.getHeight()*1/2;
//
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
    public void fire(int level){

        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX, mY, mBitmap, false,0,false));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX-30, mY, mBitmap, false,0,false));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX+30, mY, mBitmap, false,0,false));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX-60, mY, mBitmap, false,0,false));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX+60, mY, mBitmap, false,0,false));
        if (level==1) {

        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX-130, mY, mBitmap, false,1,true));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX+130, mY, mBitmap, false,1,false));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX-160, mY, mBitmap, false,1,true));
        mLasers.add(new Laser(mContext,btmap, mScreenSizeX, mScreenSizeY, mX+160, mY, mBitmap, false,1,false));}
        //mSoundPlayer.playLaser();//这个注释掉，手机发烫严重。太多的线程了
    }



    public Rect getCollision() {
        return mCollision;
    }

    //玩家右边移动
    public void steerRight(){
        mIsSteerLeft = false;
        mIsSteerRight = true;
        mSteerSpeed = Math.abs(getSpeed());
    }

   //玩家左边移动
    public void steerLeft(){
        mIsSteerRight = false;
        mIsSteerLeft = true;
        mSteerSpeed = Math.abs(getSpeed());
    }

    //静止不动
    public void stay(){
        mIsSteerLeft = false;
        mIsSteerRight = false;
        mSteerSpeed = 0;
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
        //确定了坐标
        mX=x;
        mY=y;
        if (mX<mMinX)mX=mMinX;
        if (mY<mMinY)mY=mMinY;
        if (mX>mMaxX)mX=mMaxX;
        if (mY>mMaxY)mY=mMaxY;

    }

    public int getmMaxX() {
        return mMaxX;
    }

    public int getmMinX() {
        return mMinX;
    }

    public int getmMaxY() {
        return mMaxY;
    }

    public int getmMinY() {
        return mMinY;
    }
}
