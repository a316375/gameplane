package xyxgame.gameplane.schoolGif;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.Iterator;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Billing.BillingView;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Blast.BlastTextGif;
import xyxgame.gameplane.schoolGif.Effect.FireEffect;
import xyxgame.gameplane.schoolGif.Effect.LeiEffect;

import xyxgame.gameplane.schoolGif.Button.Button2Gif;
import xyxgame.gameplane.schoolGif.Button.ButtonGif;
import xyxgame.gameplane.schoolGif.Effect.die.DieEnemyGif;
import xyxgame.gameplane.schoolGif.Effect.die_shui.DieShui;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBoss;
import xyxgame.gameplane.schoolGif.GKa.Gk01;
import xyxgame.gameplane.schoolGif.GKa.Gk02;
import xyxgame.gameplane.schoolGif.Laser.LaserRewardGif;
import xyxgame.gameplane.schoolGif.Model.Exp;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Model.Level_share;
import xyxgame.gameplane.schoolGif.Music.MusicUtils;
import xyxgame.gameplane.schoolGif.Play.PlayGif;
import xyxgame.gameplane.schoolGif.ShowList.ADList;
import xyxgame.gameplane.schoolGif.ShowList.UIList;
import xyxgame.gameplane.schoolGif.Teacher.DieShuiTeacher;
import xyxgame.gameplane.schoolGif.Teacher.FireTeacher;
import xyxgame.gameplane.schoolGif.Teacher.LaserRewardTeacher;
import xyxgame.gameplane.schoolGif.Teacher.LaserTeacher;
import xyxgame.gameplane.schoolGif.Teacher.TouchTeacher;
import xyxgame.gameplane.schoolGif.Model.Money;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.ShowList.ListB;
import xyxgame.gameplane.schoolGif.Tool.TimeUitil;
import xyxgame.gameplane.schoolGif.Tool.UiThead;


/**绘制完对象后，你需要在SchoolGifView添加resethuihe(波段出现的敌人重载时间)
 *Teacher包下除了Teacher跟TouchTeacher的其他Teacher添加pk处理碰撞响应
 *
 *
 *
 *
 * **/
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
    public  LaserTeacher laserTeacher;
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
    public final Gk02 gk02;

    public DieShui dieShui;
    private final DieShuiTeacher dieShuiTeacher;
    public   BillingView billingView;
    public   LaserRewardGif laserRewardGif;
    private final LaserRewardTeacher laserRewardTeacher;
    public DieEnemyGif dieEnemyGif;


    public SchoolGifView(BaseActivity mBaseActivity) {
        super(mBaseActivity);
        this.mBaseActivity=mBaseActivity;


        billingView = new BillingView(this);


        musicPlayer=new MusicUtils(getContext());

        gifBG=new GifBG(mBaseActivity, R.drawable.bg5);
        fps=new FPS();
        allBitmaps=new GifAllBitmaps(mBaseActivity);//拿到图片合集

        //初始化屏幕大小
        x = mBaseActivity.point.x;
        //初始化屏幕大小
        y = mBaseActivity.point.y;


//        level = new Level(mBaseActivity.info.level);//网络
        level = new Level(mBaseActivity.info.level);
//        level = new Level(1);
     if (TimeUitil.isOneDay(getContext())==false)
         Level_share.savaFistlevel(getContext(),mBaseActivity.info.level);//储存一下今天的等级初始值
     //   else level.level=level.Max_Level_day(getContext());
//        else {TimeUitil.save(getContext());}
        //TimeUitil.test(getContext());
        exp = new Exp(mBaseActivity.info.exp);
//        money=new Money(mBaseActivity.info.money);
        money=new Money(19999);


        GifObj play=new GifObj(1, x, y)
                .withPoint(x /2-100, y -400)
                .withSize(200,200)
                .init(level.level, level.backValue().hit,10, level.backValue().life,ShuXin.Jin);

        gifPlay = (PlayGif) new PlayGif(play,allBitmaps);


        //具体的类--赋予属性
        laserObj =new GifObj(60, x, y)
                .withSize(50,100)
                .withPoint(x /2, y)
                .init(level.level,level.backValue().hit,TouchTeacher.jin_waitA,100,ShuXin.Jin).showRect(false)
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



        GifObj shui=new GifObj(80, x, y)
                .withPoint(500,1000)
                .withSize(100,100)
                .init(level.level, level.backEnemyValue().hit,10, level.backEnemyValue().life,ShuXin.Shui)
                // .setShuXin(ShuXin.Huo)
                .showRect(false);
        dieShui=new DieShui(shui,allBitmaps);
//        shuiEffect = new ShuiEffect(shui,allBitmaps);


        GifObj fire=new GifObj(1,x,y).withPoint(500,500).withSize(150,150);
        fireEffect = new FireEffect(fire,allBitmaps);

        GifObj lei=new GifObj(1,x,y).withPoint(500,500).withSize(200,400);
        leiEffect = new LeiEffect(lei,allBitmaps);

        touchTeacher = new TouchTeacher(this);
        laserTeacher = new LaserTeacher(this);
        fireTeacher = new FireTeacher(this);
        dieShuiTeacher = new DieShuiTeacher(this);



        adList = new ADList(mBaseActivity,this);


        laserRewardGif = new LaserRewardGif(new GifObj(5,x,y).withSize(150,150),allBitmaps);
        laserRewardTeacher = new LaserRewardTeacher(this);
        dieEnemyGif = new DieEnemyGif(new GifObj(60,x,y).withSize(150,150),allBitmaps);

        gk01 = new Gk01(this);
        gk02 = new Gk02(this);


    }


    public boolean showlistA=false;
    @Override
    protected void onThreadDraw(Canvas canvas) {





        gifBG.drawCanvas(canvas);

        dieEnemyGif.drawCanvas(canvas);

        fireEffect.drawCanvas(canvas);

//        xiong.drawCanvas(canvas);
      if (level.level>=16) {gk01.exit();gk02.initGIf();gk02.initShuiGIf();}


        gk01.drawCanvas(canvas);

        gk02.drawCanvas(canvas);




        dieShui.drawCanvas(canvas);
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
        laserRewardGif.drawCanvas(canvas);
        gifPlay.drawCanvas(canvas);
        fps.draw(canvas);






    }



    boolean showBillingview=false;
    boolean showOneTime=true;

    @Override
    protected void onFrameDrawFinish() {

        if (money.all<=0)showBillingview=true;

        if (showBillingview&&showOneTime)  UiThead.runInUIThread(new Runnable() {
            @Override
            public void run() {
                showOneTime=false;
                billingView.show();
            }
        });

        laserTeacher.PKResult();//处理碰撞
        fireTeacher.PKResult();//火技能的燃烧
        dieShuiTeacher.PKResult();//水属性敌方死亡后产物碰撞
        laserRewardTeacher.PKResult();



        removeDie(gk01.xiongBoss);//移除Boss死亡
        removeDie(gk02.upxiongGifBoss);//移除Boss死亡


    }

    private void removeDie(XiongBoss xiongBoss) {
        if (xiongBoss==null||xiongBoss.bags.size()==0)return;
        Iterator<BaseGifBag> iterator = xiongBoss.bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            BaseGifBag baseGifBag = it.next();
            if (baseGifBag.isDie){
               if (gk01.xiongGifs1!=null)   gk01.xiongGifs1.Exit(gk01.xiongGifs1);
                if (gk01.xiongGifs2!=null)  gk01.xiongGifs2.Exit(gk01.xiongGifs2);
                if (gk01.xiongGifs3!=null)    gk01.xiongGifs3.Exit(gk01.xiongGifs3);
                if (gk01.xiongGifs4!=null)    gk01.xiongGifs4.Exit(gk01.xiongGifs4);
                if (gk01.xiongGifs5!=null)    gk01.xiongGifs5.Exit(gk01.xiongGifs5);
                if (gk01.xiongGifs6!=null)     gk01.xiongGifs6.Exit(gk01.xiongGifs6);
                if (gk02.xiongGifs!=null)     gk02.xiongGifs.Exit(gk02.xiongGifs);
                if (gk02.xiongGifs2!=null)      gk02.xiongGifs2.Exit(gk02.xiongGifs2);
                if (gk02.shuiGif!=null)     gk02.shuiGif.Exit(gk02.shuiGif);
               // gk02.initUpXiongGIf();

                xiongBoss.bags.remove(baseGifBag);}
        }

    }


    @Override
    protected void onFrameDraw() {
        if (frame_Time%5==0){
            resethuihe(laserGif);}
        if (frame_Time%25==0){

            resethuihe(dieEnemyGif);

            resethuihe(gk01.xiongGifs1);
            resethuihe(gk01.xiongGifs2);
            resethuihe( gk01.xiongGifs3);
            resethuihe( gk01.xiongGifs4);
            resethuihe( gk01.xiongGifs5);
            resethuihe( gk01.xiongGifs6);
            resethuihe( gk01.xiongGifs7);

            resethuihe(gk02.shuiGif);
            resethuihe( gk02.xiongGifs);
            resethuihe( gk02.xiongGifs2);
            resethuihe( gk02.upXiongGif);
            resethuihe( gk02.shuiGif2);
            resethuihe( gk02.upxiongGifBoss);


        }

    }

    private void resethuihe(BaseGifObj gifObj) {
       if (gifObj!=null)gifObj.resetHuiHeTime();
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


    @Override
    public void ADLoadFaid() {
        super.ADLoadFaid(); 
        money.all+=1000;//不能无限制添加，应该设置广告展示次数
    }
}
