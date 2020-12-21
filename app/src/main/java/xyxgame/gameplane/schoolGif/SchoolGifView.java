package xyxgame.gameplane.schoolGif;

import android.graphics.Canvas;
import android.view.MotionEvent;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Blast.BlastTextGif;
import xyxgame.gameplane.schoolGif.Enemy.XiongGIf;
import xyxgame.gameplane.schoolGif.Button.Button2Gif;
import xyxgame.gameplane.schoolGif.Button.ButtonGif;
import xyxgame.gameplane.schoolGif.Play.PlayGif;
import xyxgame.gameplane.schoolGif.ShowList.UIList;
import xyxgame.gameplane.schoolGif.Teacher.LaserTeacher;
import xyxgame.gameplane.schoolGif.Teacher.TouchTeacher;
import xyxgame.gameplane.schoolGif.Tool.Money;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.ShowList.ListB;
import xyxgame.gameplane.schoolGif.Pan.PanGif;

public class SchoolGifView extends BaseSurfaceVIEW {

   public BaseActivity mBaseActivity;
    public GifBG gifBG;
    public  FPS fps;
    public GifObj laserObj;
    public  GifAllBitmaps allBitmaps;
    public LaserGif laserGif;
    public final ButtonGif buttonGif01;
     public Button2Gif buttonGif02;
    public final XiongGIf xiong;
    public final PlayGif gifPlay;
    public final TouchTeacher touchTeacher;
    public final int x;
    public final int y;
    public ListB listB;
    public final PanGif panGif;
    private final LaserTeacher laserTeacher;
    public final BlastTextGif blastTextGif;
    public UIList uiList;
    public Money money;


    public SchoolGifView(BaseActivity mBaseActivity) {
        super(mBaseActivity);
        this.mBaseActivity=mBaseActivity;
        money=new Money(99998);

        gifBG=new GifBG(mBaseActivity, R.drawable.bg5);
        fps=new FPS();
        allBitmaps=new GifAllBitmaps(mBaseActivity);//拿到图片合集

        //初始化屏幕大小
        x = mBaseActivity.point.x;
        //初始化屏幕大小
        y = mBaseActivity.point.y;

        GifObj play=new GifObj(1, x, y)
                .withPoint(x /2-100, y -400)
                .withSize(200,200)
                .init(1,100,10,50,ShuXin.Huo);

        gifPlay = new PlayGif(play,allBitmaps);


        //具体的类--赋予属性
        laserObj =new GifObj(5, x, y)
                .withSize(50,100)
                .withPoint(x /2, y)
                .init(1,10,10,100,1).showRect(false)
               ;

        //添加赋予图片资源
        laserGif = new LaserGif(laserObj,allBitmaps).with(gifPlay).withMoney(money);

        GifObj button01=new GifObj(1, x, y)
                .withPoint(50, y -800)
                .withSize(200,200)
                ;

        buttonGif01 = new ButtonGif(button01,allBitmaps);

        GifObj button02=new GifObj(1, x, y)
                .withPoint(50, y -600)
                .withSize(200,200)
                ;

         buttonGif02=new Button2Gif(button02,allBitmaps);


        GifObj pano=new GifObj(1,x,y)
                 .withPoint(80, y -1000)
                .withSize(150,150) ;
        panGif = new PanGif(pano,allBitmaps);
        panGif.F5_GIf=15;

        GifObj xiongo=new GifObj(1, x, y)
                .withPoint(500,0)
                .withSize(200,200)
                .init(1,10,10,500,ShuXin.Huo)
                .setShuXin(ShuXin.Huo).showRect(false);
        xiong = new XiongGIf(xiongo,allBitmaps);




        listB = new ListB(mBaseActivity);


        blastTextGif = new BlastTextGif(mBaseActivity);
        uiList=new UIList(mBaseActivity,this);


        touchTeacher = new TouchTeacher(this);
        laserTeacher = new LaserTeacher(this);


    }


    public boolean showlistA=false;
    @Override
    protected void onThreadDraw(Canvas canvas) {





        gifBG.drawCanvas(canvas);
        uiList.drawCanvas(canvas);

        xiong.drawCanvas(canvas);


        buttonGif01.drawCanvas(canvas);
        buttonGif02.drawCanvas(canvas);
        panGif.drawCanvas(canvas);






        laserGif.drawCanvas(canvas);
        blastTextGif.draws(canvas);//绘制爆炸
        gifPlay.drawCanvas(canvas);
        fps.draw(canvas);


        //展示列表
         if (showlistA) listB.draws(canvas);


    }

    @Override
    protected void onFrameDrawFinish() {
        laserTeacher.PKResult();
    }

    @Override
    protected void onFrameDraw() {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gifPlay.onTouchEvent(event);
        touchTeacher.onTouchEvent(event);

        return true;

    }


}
