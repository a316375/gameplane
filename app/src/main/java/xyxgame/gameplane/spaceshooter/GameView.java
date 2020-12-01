package xyxgame.gameplane.spaceshooter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import xyxgame.gameplane.effects.Ea;

import static java.lang.Thread.sleep;

/**
 * Created on   : 8/11/2017
 * Developed by : Hendrawan Adi Wijaya
 * Github       : https://github.com/andevindo
 * Website      : http://www.andevindo.com
 */

public class GameView extends SurfaceView implements Runnable {

    private SurfaceHolder mSurfaceHolder;
    private Canvas mCanvas;
    private Thread mGameThread;
    private Paint mPaint;

    private volatile boolean mIsPlaying;

    private BG mBackground;
    private Player mPlayer;
    private ArrayList<Laser> mLasers;
    private ArrayList<Meteor> mMeteors;
    private ArrayList<Enemy> mEnemies;
    private ArrayList<Star> mStars;
    private int mScreenSizeX, mScreenSizeY;
    private int mCounter = 0;//控制
    private SoundPlayer mSoundPlayer;
    private SharedPreferencesManager mSP;
    public static int SCORE = 0;
    public static int METEOR_DESTROYED = 0;
    public static int ENEMY_DESTROYED = 0;
    private volatile boolean mIsGameOver;
    private volatile boolean mNewHighScore;

    private Ea mEa;


    //**绘制帧率**//
    LinkedList<Long> times = new LinkedList<Long>(){{
        add(System.nanoTime());
    }};
    private final int MAX_SIZE = 100;
    private final double NANOS = 1000000000.0;

    /** Calculates and returns frames per second */
    private double fps() {
        long lastTime = System.nanoTime();
        double difference = (lastTime - times.getFirst()) / NANOS;
        times.addLast(lastTime);
        int size = times.size();
        if (size > MAX_SIZE) {
            times.removeFirst();
        }
        return difference > 0 ? times.size() / difference : 0.0;
    }
    //绘制帧率完毕**/

    public GameView(Context context, int screenSizeX, int screenSizeY) {
        super(context);

        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;
        mSP = new SharedPreferencesManager(context);

        mSoundPlayer = new SoundPlayer(context);
        mPaint = new Paint();
        mSurfaceHolder = getHolder();

        reset();

    }

    void reset() {
        SCORE = 0;
        mBackground=new BG(getContext(),mScreenSizeX,mScreenSizeY);
        mPlayer = new Player(getContext(), mScreenSizeX, mScreenSizeY, mSoundPlayer);
        mEa =new Ea(getContext());
        mLasers = new ArrayList<>();
        mMeteors = new ArrayList<>();
        mEnemies = new ArrayList<>();
        mStars = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            mStars.add(new Star(getContext(), mScreenSizeX, mScreenSizeY, true));
        }
        mIsGameOver = false;
        mNewHighScore = false;
    }

    @Override
    public void run() {
        while (mIsPlaying) {
            if (!mIsGameOver) {
                update();//刷新数据
                draw();//绘制界面
                control();//控制自增
            }
        }
        Log.d("GameThread", "Run stopped");
    }

    public void update() {


        mPlayer.update();
        //玩家开火频率
        if (mCounter % 7 == 0) {
           mPlayer.fire(mPlayer.getmLevel());//开火

        }


        //数障碍物
        for (Meteor m : mMeteors) {
            m.update();

            if (Rect.intersects(m.getCollision(), mPlayer.getCollision())) {
                m.destroy();
                mIsGameOver = true;//游戏结束了,碰撞死亡
                if (SCORE > mSP.getHighScore()) {
                    mNewHighScore = true;
                    mSP.saveHighScore(SCORE, METEOR_DESTROYED, ENEMY_DESTROYED);
                }
            }

            for (Laser l : mPlayer.getLasers()) {
                if (Rect.intersects(m.getCollision(), l.getCollision())) {
                    m.hit();
                    l.destroy();
                }
            }
        }
        //消除障碍物
        boolean deleting = true;
        while (deleting) {
            if (mMeteors.size() != 0) {
                if (mMeteors.get(0).getY() > mScreenSizeY) {
                    mMeteors.remove(0);
                }
            }

            if (mMeteors.size() == 0 || mMeteors.get(0).getY() <= mScreenSizeY) {
                deleting = false;
            }
        }
        //障碍物数量产出频率
        if (mCounter % 30== 0) {
            mMeteors.add(new Meteor(getContext(), mScreenSizeX, mScreenSizeY, mSoundPlayer));
        }

        //数敌机
        for (Enemy e : mEnemies) {
            e.update();
            if (Rect.intersects(e.getCollision(), mPlayer.getCollision())) {
                e.destroy();
                mIsGameOver = true;
                if (SCORE >= mSP.getHighScore()) {
                    mSP.saveHighScore(SCORE, METEOR_DESTROYED, ENEMY_DESTROYED);
                }
            }

            for (Laser l : mPlayer.getLasers()) {
                if (Rect.intersects(e.getCollision(), l.getCollision())) {
                    e.hit();
                    l.destroy();
                }
            }
        }
        //消除敌机
        deleting = true;
        while (deleting) {
            if (mEnemies.size() != 0) {
                if (mEnemies.get(0).getY() > mScreenSizeY) {
                    mEnemies.remove(0);
                }
            }

            if (mEnemies.size() == 0 || mEnemies.get(0).getY() <= mScreenSizeY) {
                deleting = false;
            }
        }

        //敌机数量产出频率
        if (mCounter % 40 == 0) {
            mEnemies.add(new Enemy(getContext(), mScreenSizeX, mScreenSizeY, mSoundPlayer));
        }


        //数星星
        for (Star s : mStars) {
            s.update();
        }
        deleting = true;
        //移除星星
        while (deleting) {
            if (mStars.size() != 0) {
                if (mStars.get(0).getY() > mScreenSizeY) {
                    mStars.remove(0);
                }
            }

            if (mStars.size() == 0 || mStars.get(0).getY() <= mScreenSizeY) {
                deleting = false;
            }
        }

        // 星星数量产出频率
        if (mCounter % 100== 0) {
            Random random = new Random();
            for (int i = 0; i < random.nextInt(3) + 1; i++) {
                mStars.add(new Star(getContext(), mScreenSizeX, mScreenSizeY, false));
            }

        }


        if (mEa !=null) {
            mEa.update();
            if (mEa.getmY() >= mScreenSizeY) mEa = null;
            if (mEa !=null&&Rect.intersects(mEa.getmCollision(), mPlayer.getCollision())) {
                mPlayer.setmLevel(1);
            }
        }

    }

    public void draw() {
        if (mSurfaceHolder.getSurface().isValid()) {
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.BLACK);

            mCanvas.drawBitmap(mBackground.getmBitmap(),0,0,mPaint);

            //绘制帧率位置
            mPaint.setAntiAlias(true);
            mPaint.setFakeBoldText(true);               // if you like bold
            mPaint.setShadowLayer(5, 5, 5, Color.GRAY); // add shadow
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(30);
            mCanvas.drawText("FPS: " + (int)fps(), mScreenSizeX-200, 50, mPaint);

            if (mEa !=null) mCanvas.drawBitmap(mEa.getResult(), mEa.getmX(), mEa.getmY(),mPaint);

            mCanvas.drawBitmap(mPlayer.getBitmap(), mPlayer.getX(), mPlayer.getY(), mPaint);




            for (Star s : mStars) {
                mCanvas.drawBitmap(s.getBitmap(), s.getX(), s.getY(), mPaint);
            }
            for (Laser l : mPlayer.getLasers()) {
                mCanvas.drawBitmap(l.getBitmap(), l.getX(), l.getY(), mPaint);
            }


            for (Meteor m : mMeteors) {
                mCanvas.drawBitmap(m.getBitmap(), m.getX(), m.getY(), mPaint);
            }
            for (Enemy e : mEnemies) {
                mCanvas.drawBitmap(e.getBitmap(), e.getX(), e.getY(), mPaint);
            }
            drawScore();
            if (mIsGameOver) {
                drawGameOver();
            }
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }


    void drawScore() {
        Paint score = new Paint();
        score.setTextSize(30);
        score.setColor(Color.WHITE);
        mCanvas.drawText("Score : " + SCORE, 100, 50, score);
    }

    //游戏结束
    void drawGameOver() {
        Paint gameOver = new Paint();
        gameOver.setTextSize(100);
        gameOver.setTextAlign(Paint.Align.CENTER);
        gameOver.setColor(Color.WHITE);
        mPlayer.pause();
        mCanvas.drawText("GAME OVER", mScreenSizeX / 2, mScreenSizeY / 2, gameOver);
        Paint highScore = new Paint();
        highScore.setTextSize(50);
        highScore.setTextAlign(Paint.Align.CENTER);
        highScore.setColor(Color.WHITE);
        if (mNewHighScore) {
            mCanvas.drawText("New High Score : " + mSP.getHighScore(), mScreenSizeX / 2, (mScreenSizeY / 2) + 60, highScore);
            Paint enemyDestroyed = new Paint();
            enemyDestroyed.setTextSize(50);
            enemyDestroyed.setTextAlign(Paint.Align.CENTER);
            enemyDestroyed.setColor(Color.WHITE);
            mCanvas.drawText("Enemy Destroyed : " + mSP.getEnemyDestroyed(), mScreenSizeX / 2, (mScreenSizeY / 2) + 120, enemyDestroyed);
            Paint meteorDestroyed = new Paint();
            meteorDestroyed.setTextSize(50);
            meteorDestroyed.setTextAlign(Paint.Align.CENTER);
            meteorDestroyed.setColor(Color.WHITE);
            mCanvas.drawText("Meteor Destroyed : " + mSP.getMeteorDestroyed(), mScreenSizeX / 2, (mScreenSizeY / 2) + 180, meteorDestroyed);
        }
//
    }

    //玩家左边移动（距离）
    public void steerLeft(float speed) {
        mPlayer.steerLeft(speed);
    }

    //玩家右边移动（距离）
    public void steerRight(float speed) {
        mPlayer.steerRight(speed);
    }

    //静止不动
    public void stay() {
        mPlayer.stay();
    }

    //控制
    public void control() {
        try {
            if (mCounter == 601) {
                mCounter = 0;
            }
            sleep(60/100);//25为30帧率，15为40帧，10为60帧率
            mCounter += 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //响应Acitivity暂停
    public void pause() {
        Log.d("GameThread", "Main");
        mIsPlaying = false;
        try {
            mGameThread.join();
            mSoundPlayer.pause();
            mPlayer.pause();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //响应Acitivity恢复
    public void resume() {
        mIsPlaying = true;
        mSoundPlayer.resume();
        mGameThread = new Thread(this);
        mGameThread.start();
        mPlayer.start();
    }


    private int lastX, lastY;//手指的位置
    private int pointX, pointY;//飞机的位置
    private int pointXFix, pointYFix;//最终飞机的位置


    //按下屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if (mIsGameOver) {
                    ((Activity) getContext()).finish();
                    getContext().startActivity(new Intent(getContext(), MainMenuActivity.class));
                } else {
                    lastX = (int) event.getX();//保存手指临时值
                    lastY = (int) event.getY();
                    pointX = mPlayer.getX();//保存飞机按下时候的原始位置
                    pointY = mPlayer.getY();
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (!mIsGameOver) {
                    pointXFix = (int) (pointX + (event.getX() - lastX));
                    pointYFix = (int) (pointY + (event.getY() - lastY));
                    mPlayer.update(pointXFix, pointYFix);

                }
                break;


        }
        return true;
    }
}
