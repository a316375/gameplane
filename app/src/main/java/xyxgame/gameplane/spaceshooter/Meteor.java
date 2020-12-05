package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Random;

import xyxgame.gameplane.GL.BTMAP;

import static xyxgame.gameplane.spaceshooter.GameView.METEOR_DESTROYED;
import static xyxgame.gameplane.spaceshooter.GameView.SCORE;

/**
 * Created on   : 8/11/2017
 * 石头
 * Developed by : Hendrawan Adi Wijaya
 * Github       : https://github.com/andevindo
 * Website      : http://www.andevindo.com
 */

public class Meteor  {

    private Bitmap mBitmap;
    private float mX;



    private float mY;
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

    private double mR;//直径

    private boolean isRight;




    public Meteor(Context context, BTMAP btmap, int screenSizeX, int screenSizeY, SoundPlayer soundPlayer, int mY ){
        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;
        mSoundPlayer = soundPlayer;

        this.mY=mY;





       // mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.meteor_1);
        mBitmap = btmap.getBitmaps().get(6);
        if (!mBitmap.isRecycled())
        mBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 3/5, mBitmap.getHeight() * 3/5, false);

        mMaxX = screenSizeX - mBitmap.getWidth();
        mMaxY = screenSizeY - mBitmap.getHeight();
        mMinX = 0;
        mMinY = 0;
        mHP = 5;


        Random random = new Random();
        mSpeed = random.nextInt(1) + 1;
//
//        mY = random.nextInt(50)+mScreenSizeY/2;
//        mY =  mScreenSizeY/2;

        mX = 0 ;//- mBitmap.getHeight()

        mR=mY/2;

        mCollision = new Rect((int) mX, (int)mY, (int)mX + mBitmap.getWidth(), (int)mY + mBitmap.getHeight());
        isRight=true;





          px1 = 0;//圆心坐标
          py1 = (float) mR;//圆心坐标
          radio= (float) mR;//圆直径

//
        px1 = mScreenSizeX/2;//圆心坐标
        py1 = mScreenSizeY/2;//圆心坐标
        radio=500;//圆直径
        mX=mScreenSizeX/2;
        this.mY=mScreenSizeY/2-radio;



    }

    private double getangle(double b,double c){
        //已知邻边/斜边长度，算角度
        return Math.toDegrees(Math.acos(Math.sqrt(b)/c));
    }

    private float px1  ;
    private float py1  ;

    private float radio ;
    private int RIGHT_LEFT_UP = 2;
    private int LEFT_RIGHT_DOWN = 3;
    private int flag = RIGHT_LEFT_UP;
    int angle=0;//角度
    public void update(int i){



       switch (i){
           //直线运动
           case 0: {//Right代表正在右移
               if (isRight) {

                   // mX += 5 * mSpeed;
                   mY -= 3 * mSpeed;
                   ;
                   mX += 3 * mSpeed;
                   ;
                   if (mY <= mR) isRight = false;

               } else {
                   mSpeed = 2;
                   if (mY <= mR)
                       mY -= 2 * mSpeed;
                   else {
                       mY += 2 * mSpeed;
                   }
                   mX -= 2 * mSpeed;
               }

               if (mX >= mMaxX) {
                   isRight = false;
               }
               //if (mX<=0){mY=mScreenSizeY+1;}


           } break;
           case 1:{


               if (isRight){
                   if (mY<=mR){
                       isRight=false;
                   }
                   mX+=2*mSpeed;
                   mY=py1+(int) Math.sqrt( Math.pow(radio, 2) - Math.pow( (mX - px1),2 ) );

               }else {
                   mX-=2*mSpeed;
                   mY=py1-(int) Math.sqrt( Math.pow(radio, 2) - Math.pow( (mX - px1),2 ) );
               }
           }break;
           case 2:{
               if (flag == RIGHT_LEFT_UP) {//上半圆的运动轨迹方程
                   mX +=6;
                   //y = b + (int) Math.sqrt(r^2 - (x - a)^2);
                   if (mX <= px1+radio) {
                       mY = py1 - (int) Math.sqrt( Math.pow(radio, 2) - Math.pow( (mX - px1),2 ) );
                   }else {
                       mX = px1 + radio;
                       flag = LEFT_RIGHT_DOWN;
                   }
               }else if (flag == LEFT_RIGHT_DOWN) {//下半圆的运动轨迹方程
                   mX -=4;
                   if (mX >= px1 - radio) {
                       mY = py1 + (int) Math.sqrt( Math.pow(radio, 2) - Math.pow( (mX - px1),2 ) );
                   }else{
                       mX = px1 - radio;
                       flag = RIGHT_LEFT_UP;
                   }
               }
           }break;
           case 3:{


               if (mCollision.left<=500){mX-=1;mY-=1;}else {
                   angle++;
                   if (angle >= 360) angle = 0;
                   ;


//               mX = (float) (px1 + radio * Math.cos(angle * 3.14 / 180));
//               mY = (float) (py1 - radio * Math.sin(angle * 3.14 / 180));//-是逆时针+是顺时针
//               mX = (float) (px1 + radio * Math.cos(angle * 3.14 / 180));
//               mY = (float) (py1 - radio * Math.sin(angle * 3.14 / 180));//-是逆时针+是顺时针
                   mX = (float) (px1 + radio * Math.sin(angle * Math.PI / 180));
                   mY = (float) (py1 - radio * Math.cos(angle * Math.PI / 180));//-是逆时针+是顺时针;

                   //Log.e("Collision", mCollision.left + "--" + mCollision.right);

               }
              }break;
           default:break;
       }



        mCollision.set((int)mX,(int)mY,(int)mX + mBitmap.getWidth(),(int)mY + mBitmap.getHeight());


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
        if ((new Random().nextInt(1)+1)!=5){

        mX =  - getBitmap().getWidth();
        mSoundPlayer.playCrash();}
        else {
            mHP=5;
        }

    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public float getX() {
        return mX;
    }

    public float getY() {
        return mY;
    }







}
