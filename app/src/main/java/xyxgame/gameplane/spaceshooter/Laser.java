package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;

import xyxgame.gameplane.GL.BTMAP;
import xyxgame.gameplane.R;

/**
 * Created on   : 8/11/2017
 * Developed by : Hendrawan Adi Wijaya
 * Github       : https://github.com/andevindo
 * Website      : http://www.andevindo.com
 */

public class Laser {


    //
    private Bitmap mBitmap;
    private int mX;
    private int mY;
    private Rect mCollision;
    private int mScreenSizeX;
    private int mScreenSizeY;
    private boolean mIsEnemy;
    private int mLevel;
    private boolean mleft;



    public Laser(Context context, BTMAP btmap,int screenSizeX, int screenSizeY, int spaceShipX,
                 int spaceShipY, Bitmap spaceShip, boolean isEnemy, int level, boolean left){
        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;
        mIsEnemy = isEnemy;
        mLevel=level;
        mleft=left;



//        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.laser_1);
        if (level==0)     {
            mBitmap = btmap.getBitmaps().get(2);
             mBitmap = Bitmap.createScaledBitmap(mBitmap, 15, 150 , false);

             }
        if (level==1)     {
            mBitmap =btmap.getBitmaps().get(1);
//        mBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() /2, mBitmap.getHeight() , false);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, 10, 100 , false);

        if (left==false){ roatate(mBitmap,5);//右侧
        }else {roatate(mBitmap,-5);//左侧
        }
        }



        mX = spaceShipX + spaceShip.getWidth()/2 - mBitmap.getWidth()/2;
        if (mIsEnemy){
            mY = spaceShipY + mBitmap.getHeight() + 20;
        }else{
            mY = spaceShipY - mBitmap.getHeight() - 20;
        }

        mCollision = new Rect(mX, mY, mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
    }

    //坐标移动
    public void update(){
        if (mIsEnemy){
              mY += mBitmap.getHeight() + 20;

            mCollision.left = mX;
            mCollision.top = mY;
            mCollision.right = mX + mBitmap.getWidth();
            mCollision.bottom = mY + mBitmap.getHeight();
        }else{
             mY -= mBitmap.getHeight() - 20;
             if (mLevel==1){
                 mY -= mBitmap.getHeight() - 10;
             if (mleft==false){//右侧
                 mX+=mBitmap.getWidth()+1;}
             else {//左侧
                 mX-=mBitmap.getWidth()+1;}

             }

            mCollision.left = mX;
            mCollision.top = mY;
            mCollision.right = mX + mBitmap.getWidth();
            mCollision.bottom = mY + mBitmap.getHeight();
        }

    }

    public boolean isEnemy() {
        return mIsEnemy;
    }

    //碰撞
    public Rect getCollision() {
        return mCollision;
    }

    public void destroy(){
        if (mIsEnemy){
            mY = mScreenSizeY;
        }else{
            mY = 0 - mBitmap.getHeight();

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


    private void roatate(Bitmap bitmap,int degrees){ //旋转角度
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        mBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, true);
    }

}
