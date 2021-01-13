package xyxgame.gameplane.schoolGif.GKa;

import android.graphics.Canvas;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBoss;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongGif3;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class Gk01 {

    //public XiongGif xiongGifs;
    public XiongGif3 xiongGifs1;
    public XiongGif3 xiongGifs2;
    public XiongGif3 xiongGifs3;
    public XiongGif3 xiongGifs4;
    public XiongGif3 xiongGifs5;
    public XiongGif3 xiongGifs6;
    public XiongGif3 xiongGifs7;
    public XiongBoss xiongBoss;
    SchoolGifView schoolGifView;


    public Gk01(SchoolGifView schoolGifView) {
        this.schoolGifView=schoolGifView;
//        if (schoolGifView.level.level<=16){  xiongGifs = new XiongGif(new GifObj(3,schoolGifView.x,schoolGifView.y)
//                .withPoint(0,0).withSize(200,200)
//                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
//                        new Level(schoolGifView.level.level).backEnemyValue().life, ShuXin.Huo),
//                schoolGifView.allBitmaps);
//        xiongGifs.withTime_wait(100);}

        if (schoolGifView.level.level<=19)   {  xiongGifs1 = (XiongGif3) new XiongGif3(new GifObj(4,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(150,150)
                  .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                          new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                  schoolGifView.allBitmaps).withx(schoolGifView.x/2-150/2+schoolGifView.x*1/8);
        xiongGifs1.withTime_wait(80);}


        if (schoolGifView.level.level<=19)  {  xiongGifs2 = new XiongGif3(new GifObj(9,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps);
        xiongGifs2.withTime_wait(30);}

        if (schoolGifView.level.level<=19)  {  xiongGifs3 = (XiongGif3) new XiongGif3(new GifObj(9,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps).withx(schoolGifView.x/2-100/2+schoolGifView.x*3/8);
            xiongGifs3.withTime_wait(30);}



        if (schoolGifView.level.level<=19)  {  xiongGifs4 = (XiongGif3) new XiongGif3(new GifObj(9,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps).withx(schoolGifView.x/2-100/2-schoolGifView.x*3/8);
            xiongGifs4.withTime_wait(30);}
        if (schoolGifView.level.level<=19)  {  xiongGifs5 = (XiongGif3) new XiongGif3(new GifObj(9,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps).withx(schoolGifView.x/2-100/2-schoolGifView.x*2/8);
            xiongGifs5.withTime_wait(30);}

        if (schoolGifView.level.level<=19)   {
            xiongGifs6 = (XiongGif3) new XiongGif3(new GifObj(4,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(150,150)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps).withx(schoolGifView.x/2-150/2-schoolGifView.x*1/8);
            xiongGifs6.withTime_wait(80);}
        if (schoolGifView.level.level<=19)   {  xiongGifs7 = (XiongGif3) new XiongGif3(new GifObj(2,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(200,200)
                .init(schoolGifView.level.level*2, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level*2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps).withx(schoolGifView.x/2-200/2);
            xiongGifs7.withTime_wait(130);}

       if (schoolGifView.level.level>=16&&schoolGifView.level.level<=19)
            initBoss(schoolGifView);




    }

    public void initBoss(SchoolGifView schoolGifView) {

        if (schoolGifView.level.level>=16&&schoolGifView.level.level<=19)
        if (xiongBoss==null){
        GifObj init = new GifObj(1, schoolGifView.x, schoolGifView.y)
                .withPoint(0, 0).withSize(250, 250)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                        new Level(20*100).backEnemyValue().life, ShuXin.Boss);

        xiongBoss = new XiongBoss(init,
                schoolGifView.allBitmaps);
        }

    }

    public void drawCanvas(Canvas canvas){

//        for (BaseGifBag bgb:xiongGifs.bags ) {
//            bgb.path=new PathTest(bgb,1);
//        }
//        for (BaseGifBag bgb:xiongGifs2.bags ) {
//            bgb.path=new PathTest(bgb,2);
//        }

        drawBossCanvas(canvas);
    //    if (xiongGifs!=null)  xiongGifs.drawCanvas(canvas);
        if (xiongGifs1!=null)   xiongGifs1.drawCanvas(canvas);
        if (xiongGifs2!=null)  xiongGifs2.drawCanvas(canvas);
        if (xiongGifs3!=null)  xiongGifs3.drawCanvas(canvas);
        if (xiongGifs4!=null)  xiongGifs4.drawCanvas(canvas);
        if (xiongGifs5!=null)  xiongGifs5.drawCanvas(canvas);
        if (xiongGifs6!=null)  xiongGifs6.drawCanvas(canvas);
        if (xiongGifs7!=null)  xiongGifs7.drawCanvas(canvas);




    }

    public void drawBossCanvas(Canvas canvas){

        if (xiongBoss==null)return;

      xiongBoss.drawCanvas(canvas);
  //修改状态
    if (xiongBoss.bags!=null)
        for (BaseGifBag enemy_bag:xiongBoss.bags){
         if (enemy_bag.baseState!=null&&enemy_bag.state!=State.Att)
             if (enemy_bag.y>350)
                 enemy_bag.baseState.changState(State.Att,enemy_bag,schoolGifView.allBitmaps);}

    }


    public void exit(){
        initBoss(schoolGifView);/////////触发退出后召回一个boss
//        if (xiongGifs==null||xiongGifs1==null||xiongGifs2==null)return;
//                exit(xiongGifs);
//                exit(xiongGifs1);

         if (xiongGifs7!=null)   xiongGifs7.Exit(xiongGifs7);


    }










}
