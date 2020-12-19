package xyxgame.gameplane.schoolGif;

import android.graphics.Canvas;
import android.view.MotionEvent;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.EnemyGIf;
import xyxgame.gameplane.schoolGif.GifButton.ButtonGif;
import xyxgame.gameplane.schoolGif.Play.PlayGif;
import xyxgame.gameplane.schoolGif.Teacher.Teacher;
import xyxgame.gameplane.schoolGif.laser.LaserGif;
import xyxgame.gameplane.schoolGif.list.ListA;

public class SchoolGifView extends BaseSurfaceVIEW {

   public BaseActivity mBaseActivity;
    public GifBG gifBG;
    public  FPS fps;
    public GifObj gifObj;
    public  GifAllBitmaps allBitmaps;
    public LaserGif laserGif;
    public final ButtonGif buttonGif01;
    public final ButtonGif buttonGif02;
    public final EnemyGIf xiong;
    public final PlayGif gifPlay;
    public final Teacher teacher;
    public final int x;
    public final int y;
    public   ListA listA;


    public SchoolGifView(BaseActivity mBaseActivity) {
        super(mBaseActivity);
        this.mBaseActivity=mBaseActivity;
        gifBG=new GifBG(mBaseActivity, R.drawable.bg5);
        fps=new FPS();
        allBitmaps=new GifAllBitmaps(mBaseActivity);//拿到图片合集

        //初始化屏幕大小
        x = mBaseActivity.point.x;
        //初始化屏幕大小
        y = mBaseActivity.point.y;

        GifObj play=new GifObj(1, x, y)
                .withPoint(x /2-100, y -400)
                .withSize(200,200);

        gifPlay = new PlayGif(play,allBitmaps);


        //具体的类--赋予属性
        gifObj=new GifObj(25, x, y)
                .withSize(50,100)
                .withPoint(x /2, y)
                .init(1,100,10,100,1)
               .setgiflist(1);

        //添加赋予图片资源
        laserGif = new LaserGif(gifObj,allBitmaps).with(gifPlay);


        GifObj button01=new GifObj(1, x, y)
                .withPoint(50, y -600)
                .withSize(200,200)
                .setgiflist(1);
        buttonGif01 = new ButtonGif(button01,allBitmaps);


        GifObj button02=new GifObj(1, x, y)
                .withPoint(50, y -900)
                .withSize(200,200)
                .setgiflist(2);
        buttonGif02 = new ButtonGif(button02,allBitmaps);

        GifObj xiong01=new GifObj(20, x, y)
                .withPoint(500,0)
                .withSize(200,200)
                .setgiflist(2);
        xiong = new EnemyGIf(xiong01,allBitmaps);



        listA = new ListA(mBaseActivity);

        teacher = new Teacher(this);






    }


    public boolean showlistA=false;
    @Override
    protected void onThreadDraw(Canvas canvas) {
        gifBG.draw(canvas);

        xiong.drawCanvas(canvas);

        laserGif.drawCanvas(canvas);
        buttonGif01.drawCanvas(canvas);
        buttonGif02.drawCanvas(canvas);


      if (showlistA) listA.draws(canvas);

        gifPlay.drawCanvas(canvas);
        fps.draw(canvas);

    }

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw() {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gifPlay.onTouchEvent(event);
        teacher.onTouchEvent(event);

        return true;

    }


}
