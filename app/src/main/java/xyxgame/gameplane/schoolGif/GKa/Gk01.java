package xyxgame.gameplane.schoolGif.GKa;

import android.graphics.Canvas;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.XiongBoss;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif2;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif3;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UiThead;

public class Gk01 {

    public XiongGif xiongGifs;
    public XiongGif2 xiongGifs1;
    public XiongGif3 xiongGifs2;
    public XiongBoss xiongBoss;



    public Gk01(SchoolGifView schoolGifView) {
        xiongGifs = new XiongGif(new GifObj(3,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(200,200)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level).backEnemyValue().life, ShuXin.Huo),
                schoolGifView.allBitmaps);
        xiongGifs.withTime_wait(100);

          xiongGifs1 = new XiongGif2(new GifObj(4,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(150,150)
                  .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                          new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                  schoolGifView.allBitmaps);
        xiongGifs1.withTime_wait(150);


        xiongGifs2 = new XiongGif3(new GifObj(24,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps);
        xiongGifs2.withTime_wait(30);


        xiongBoss = new XiongBoss(new GifObj(1,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(250,250)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps);


    }

    public void drawCanvas(Canvas canvas){

//        for (BaseGifBag bgb:xiongGifs.bags ) {
//            bgb.path=new PathTest(bgb,1);
//        }
//        for (BaseGifBag bgb:xiongGifs2.bags ) {
//            bgb.path=new PathTest(bgb,2);
//        }



          xiongGifs.drawCanvas(canvas);
          xiongGifs1.drawCanvas(canvas);
          xiongGifs2.drawCanvas(canvas);


    }

    public void drawBossCanvas(Canvas canvas){

//        for (BaseGifBag bgb:xiongGifs.bags ) {
//            bgb.path=new PathTest(bgb,1);
//        }
//        for (BaseGifBag bgb:xiongGifs2.bags ) {
//            bgb.path=new PathTest(bgb,2);
//        }

      xiongBoss.drawCanvas(canvas);



    }


    public void recycle(){

                xiongGifs.bags=null;
                xiongGifs1.bags=null;
                xiongGifs2.bags=null;


    }



}
