package xyxgame.gameplane.schoolGif;

import android.graphics.Canvas;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GIf.GIFPlay;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.EnemyGIf;
import xyxgame.gameplane.schoolGif.GifButton.ButtonGif;
import xyxgame.gameplane.schoolGif.Play.PlayGif;
import xyxgame.gameplane.schoolGif.laser.LaserGif;
import xyxgame.gameplane.spaceshooter.Enemy;

public class SchoolGifView extends BaseSurfaceVIEW {


    GifBG gifBG;
    FPS fps;
    GifObj gifObj;
    GifAllBitmaps allBitmaps;
    private final LaserGif laserGif;
    private final ButtonGif buttonGif01;
    private final ButtonGif buttonGif02;
    private final EnemyGIf xiong;
    private final PlayGif gifPlay;

    public SchoolGifView(BaseActivity mBaseActivity) {
        super(mBaseActivity);
        gifBG=new GifBG(mBaseActivity, R.drawable.bg5);
        fps=new FPS();
        allBitmaps=new GifAllBitmaps(mBaseActivity);//拿到图片合集

        int x = mBaseActivity.point.x;//初始化屏幕大小
        int y = mBaseActivity.point.y;//初始化屏幕大小

        //具体的类--赋予属性
        gifObj=new GifObj(25,x,y)
                .withSize(100,100)
                .withPoint(x/2,y)
                .init(1,100,10,100,1)
               .setgiflist(1);

        //添加赋予图片资源
        laserGif = new LaserGif(gifObj,allBitmaps);


        GifObj button01=new GifObj(1,x,y)
                .withPoint(50,y-600)
                .withSize(200,200)
                .setgiflist(1);
        buttonGif01 = new ButtonGif(button01,allBitmaps);

        GifObj button02=new GifObj(1,x,y)
                .withPoint(50,y-900)
                .withSize(200,200)
                .setgiflist(2);
        buttonGif02 = new ButtonGif(button02,allBitmaps);

        GifObj xiong01=new GifObj(20,x,y)
                .withPoint(500,0)
                .withSize(200,200)
                .setgiflist(2);
        xiong = new EnemyGIf(xiong01,allBitmaps);

        GifObj play=new GifObj(1,x,y)
                .withPoint(x/2-100,y-400)
                .withSize(200,200);

        gifPlay = new PlayGif(play,allBitmaps);





    }

    @Override
    protected void onThreadDraw(Canvas canvas) {
        gifBG.draw(canvas);

        xiong.draw(canvas);

        laserGif.draw(canvas);
        buttonGif01.draw(canvas);
        buttonGif02.draw(canvas);


        gifPlay.draw(canvas);
        fps.draw(canvas);

    }

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw() {

    }










}
