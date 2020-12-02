package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

import xyxgame.gameplane.GL.BTMAP;
import xyxgame.gameplane.R;

import static xyxgame.gameplane.spaceshooter.GameView.METEOR_DESTROYED;
import static xyxgame.gameplane.spaceshooter.GameView.SCORE;

/**
 * Created on   : 8/11/2017
 * 石头
 * Developed by : Hendrawan Adi Wijaya
 * Github       : https://github.com/andevindo
 * Website      : http://www.andevindo.com
 */

public class Meteor {

    private Bitmap mBitmap;
    private int mX;
    private int mY;
    private int mMaxX;
    private int mMinX;
    private int mMaxY;
    private int mMinY;

    private int mSpeed;
    private Rect mCollision;
    private int mScreenSizeX;
    private int mScreenSizeY;
    private int mHP;
    private SoundPlayer mSoundPlayer;

    private boolean isRight;

    public Meteor(Context context, BTMAP btmap, int screenSizeX, int screenSizeY, SoundPlayer soundPlayer){
        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;
        mSoundPlayer = soundPlayer;

       // mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.meteor_1);
        mBitmap = btmap.getBitmaps().get(4);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 3/5, mBitmap.getHeight() * 3/5, false);

        mMaxX = screenSizeX - mBitmap.getWidth();
        mMaxY = screenSizeY - mBitmap.getHeight();
        mMinX = 0;
        mMinY = 0;
        mHP = 10;

        Random random = new Random();
        mSpeed = random.nextInt(3) + 1;
//
        mY = random.nextInt(mMaxY-500);
        mX = 0 ;//- mBitmap.getHeight()

        mCollision = new Rect(mX, mY, mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
        isRight=true;
    }

    public void update(){
        if (isRight) mX += 5 * mSpeed;
        else mX-=5*mSpeed;
        if (mX>=mMaxX){isRight=false;}
        if (mX<=0){mY=mScreenSizeY+1;}


        mCollision.left = mX;
        mCollision.top = mY;
        mCollision.right = mX + mBitmap.getWidth();
        mCollision.bottom = mY + mBitmap.getHeight();
    }

    public Rect getCollision() {
        return mCollision;
    }

    public void hit(){

        if (--mHP <=0){
            SCORE += 20;
            METEOR_DESTROYED++;
            destroy();
        }else{
            //mSoundPlayer.playExplode();//太烫了删除
        }
    }

    public void destroy(){
        //50/1的概率
        if ((new Random().nextInt(10)+1)==1){

        mX =  - getBitmap().getWidth();
        mSoundPlayer.playCrash();}
        else {
            mHP=10;
        }

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
}
