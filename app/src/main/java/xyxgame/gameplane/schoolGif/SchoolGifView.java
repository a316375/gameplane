package xyxgame.gameplane.schoolGif;

import android.graphics.Canvas;
import android.view.MotionEvent;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Blast.BlastTextGif;
import xyxgame.gameplane.schoolGif.Effect.FireEffect;
import xyxgame.gameplane.schoolGif.Effect.LeiEffect;

import xyxgame.gameplane.schoolGif.Button.Button2Gif;
import xyxgame.gameplane.schoolGif.Button.ButtonGif;
import xyxgame.gameplane.schoolGif.GKa.Gk01;
import xyxgame.gameplane.schoolGif.Model.Exp;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Music.MusicUtils;
import xyxgame.gameplane.schoolGif.Play.PlayGif;
import xyxgame.gameplane.schoolGif.ShowList.ADList;
import xyxgame.gameplane.schoolGif.ShowList.UIList;
import xyxgame.gameplane.schoolGif.Teacher.FireTeacher;
import xyxgame.gameplane.schoolGif.Teacher.LaserTeacher;
import xyxgame.gameplane.schoolGif.Teacher.TouchTeacher;
import xyxgame.gameplane.schoolGif.Model.Money;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.ShowList.ListB;

public class SchoolGifView extends BaseSurfaceVIEW  {

   public BaseActivity mBaseActivity;
    public GifBG gifBG;
    public  FPS fps;
    public GifObj laserObj;
    public  GifAllBitmaps allBitmaps;
    public BaseGifObj laserGif;
    public  ButtonGif buttonGif01;
     public Button2Gif buttonGif02;
//    public XiongGif xiong;
    public  PlayGif gifPlay;
    public  TouchTeacher touchTeacher;
    public  int x;
    public  int y;
    public ListB listB;

    //    public  PanGif panGif;
    private  LaserTeacher laserTeacher;
    public  BlastTextGif blastTextGif;
    public UIList uiList;
    public Money money;
    public  Level level;
    public   Exp exp;
//    public   ShuiEffect shuiEffect;
    public   FireEffect fireEffect;
    public FireTeacher fireTeacher;
    public   LeiEffect leiEffect;
    public   ADList adList;

    public MusicUtils musicPlayer;
    public final Gk01 gk01;


    public SchoolGifView(BaseActivity mBaseActivity) {
        super(mBaseActivity);
        this.mBaseActivity=mBaseActivity;
        money=new Money(mBaseActivity.info.money);



        musicPlayer=new MusicUtils(getContext());

        gifBG=new GifBG(mBaseActivity, R.drawable.bg5);
        fps=new FPS();
        allBitmaps=new GifAllBitmaps(mBaseActivity);//拿到图片合集

        //初始化屏幕大小
        x = mBaseActivity.point.x;
        //初始化屏幕大小
        y = mBaseActivity.point.y;


        level = new Level(mBaseActivity.info.level);
        exp = new Exp(mBaseActivity.info.exp);

        GifObj play=new GifObj(1, x, y)
                .withPoint(x /2-100, y -400)
                .withSize(200,200)
                .init(level.level, level.backValue().hit,10, level.backValue().life,ShuXin.Jin);

        gifPlay = (PlayGif) new PlayGif(play,allBitmaps);


        //具体的类--赋予属性
        laserObj =new GifObj(60, x, y)
                .withSize(50,100)
                .withPoint(x /2, y)
                .init(1,play.hit*5,30,100,ShuXin.Jin).showRect(false)
               ;



        //添加赋予图片资源
        laserGif = new LaserGif(laserObj,allBitmaps).with(gifPlay).withMoney(money).withTime_wait(15).setMusic(musicPlayer);


        GifObj button01=new GifObj(1, x, y)
                .withPoint(x-230, 200)
                .withSize(200,200)
                ;

        buttonGif01 = new ButtonGif(button01,allBitmaps);

        GifObj button02=new GifObj(1, x, y)
                .withPoint(60, y -380)
                .withSize(200,200)
                ;

         buttonGif02=new Button2Gif(button02,allBitmaps);

//
//        GifObj pano=new GifObj(1,x,y)
//                 .withPoint(80, y -1000)
//                .withSize(150,150) ;
//        panGif = new PanGif(pano,allBitmaps);
//        panGif.F5_GIf=15;

//        GifObj xiongo=new GifObj(2, x, y)
//                .withPoint(500,0)
//                .withSize(200,200)
//                .init(level.level, level.backEnemyValue().hit,10, new Level(100).backEnemyValue().life,ShuXin.Huo)
//               // .setShuXin(ShuXin.Huo)
//                .showRect(false);
//
//        xiong = new XiongGif(xiongo,allBitmaps);




        listB = new ListB(mBaseActivity);


        blastTextGif = new BlastTextGif(mBaseActivity);
        uiList=new UIList(mBaseActivity,this);



        GifObj shui=new GifObj(8, x, y)
                .withPoint(500,100)
                .withSize(200,200)
                .init(level.level, level.backEnemyValue().hit,10, level.backEnemyValue().life,ShuXin.Huo)
                // .setShuXin(ShuXin.Huo)
                .showRect(false);
//        shuiEffect = new ShuiEffect(shui,allBitmaps);


        GifObj fire=new GifObj(1,x,y).withPoint(500,500).withSize(150,150);
        fireEffect = new FireEffect(fire,allBitmaps);

        GifObj lei=new GifObj(1,x,y).withPoint(500,500).withSize(200,400);
        leiEffect = new LeiEffect(lei,allBitmaps);

        touchTeacher = new TouchTeacher(this);
        laserTeacher = new LaserTeacher(this);
        fireTeacher = new FireTeacher(this);


        adList = new ADList(mBaseActivity,this);

        gk01 = new Gk01(this);


    }


    public boolean showlistA=false;
    @Override
    protected void onThreadDraw(Canvas canvas) {





        gifBG.drawCanvas(canvas);


        fireEffect.drawCanvas(canvas);

//        xiong.drawCanvas(canvas);
      if (level.level>=16) {gk01.exit();}
        gk01.drawCanvas(canvas);



        uiList.drawCanvas(canvas);
        //展示列表
        if (showlistA) listB.draws(canvas);
         adList.drawCanvas(canvas);




        buttonGif01.drawCanvas(canvas);
        buttonGif02.drawCanvas(canvas);
//        panGif.drawCanvas(canvas);




//        shuiEffect.drawCanvas(canvas);


        leiEffect.drawCanvas(canvas);

        laserGif.drawCanvas(canvas);
        blastTextGif.draws(canvas);//绘制爆炸
        gifPlay.drawCanvas(canvas);
        fps.draw(canvas);






    }

    @Override
    protected void onFrameDrawFinish() {
        

        laserTeacher.PKResult();//处理碰撞
        fireTeacher.PKResult();//火技能的燃烧
    }


    @Override
    protected void onFrameDraw() {


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        gifPlay.onTouchEvent(event);

        touchTeacher.onTouchEvent(event);

        return true;

    }


    @Override
    public void ADFinish() {
        super.ADFinish();
        money.all+=10000;
        adList.clear();
    }


    @Override
    public void stopT() {
        super.stopT();
        musicPlayer.stop();
    }
}
