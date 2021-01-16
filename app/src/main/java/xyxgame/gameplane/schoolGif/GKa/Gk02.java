package xyxgame.gameplane.schoolGif.GKa;

import android.graphics.Canvas;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk02.GK2_XiongGif;
import xyxgame.gameplane.schoolGif.Enemy.gk02.GK2_XiongGif2;
import xyxgame.gameplane.schoolGif.Enemy.gk02.shui.ShuiGif;
import xyxgame.gameplane.schoolGif.Enemy.gk02.shui.ShuiGif2;
import xyxgame.gameplane.schoolGif.Enemy.gk02.shui.ShuiGifBoss;
import xyxgame.gameplane.schoolGif.Enemy.gk02.upXiong.UpXiongGif;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class Gk02 {


    public GK2_XiongGif xiongGifs;
    public GK2_XiongGif2 xiongGifs2;


    SchoolGifView schoolGifView;

    public ShuiGif shuiGif;
    public UpXiongGif upXiongGif;
    public ShuiGif2 shuiGif2;
    public ShuiGifBoss shuiGifBoss;


    public Gk02(  SchoolGifView schoolGifView) {

        this.schoolGifView = schoolGifView;


        initGIf();

        if (schoolGifView.level.level >= 16){
            initShuiGIf( );
        }

        if (schoolGifView.level.level >= 21)   initUpXiongGIf();

    }

    public void initShuiGIf( ) {

        if (schoolGifView.level.level>=16&&schoolGifView.level.level<=20)
   if (shuiGif==null)   { shuiGif = new ShuiGif(new GifObj(35, schoolGifView.x, schoolGifView.y)
//                .withPoint(schoolGifView.x / 2 - 250 / 2, 0).withSize(250, 250)
                .withPoint(-250+5, schoolGifView.y / 2).withSize(250, 250)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 2,
                        new Level(1).backEnemyValue().life, ShuXin.Shui)
                .showRect(false),
                schoolGifView.allBitmaps);
        }
    }


    public void initShuiGif2(){
        if (shuiGif2==null)   {
            shuiGif2 = new ShuiGif2(new GifObj(35, schoolGifView.x, schoolGifView.y)
//                .withPoint(schoolGifView.x / 2 - 250 / 2, 0).withSize(250, 250)
                    .withPoint(0, -240).withSize(250, 250)
                    .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                            new Level(2).backEnemyValue().life, ShuXin.Shui)
                    .showRect(false),
                    schoolGifView.allBitmaps);

            //shuiGif2.withTime_wait(50);
        }

        if (shuiGifBoss==null)     shuiGifBoss = new ShuiGifBoss(new GifObj(1, schoolGifView.x, schoolGifView.y)
//                .withPoint(schoolGifView.x / 2 - 250 / 2, 0).withSize(250, 250)
                .withPoint(0, -240).withSize(250, 250)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                        schoolGifView.laserGif.obj.hit*60, ShuXin.Boss)
                .showRect(false),
                schoolGifView.allBitmaps);
    }

    public void initUpXiongGIf( ) {
        schoolGifView.gifBG.updataBG(2);

        initShuiGif2();

        if (schoolGifView.level.level>=20)
        if (upXiongGif==null)   { upXiongGif = new UpXiongGif(new GifObj(35, schoolGifView.x, schoolGifView.y)
//                .withPoint(schoolGifView.x / 2 - 250 / 2, 0).withSize(250, 250)
                .withPoint( 0, -140).withSize(150, 150)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                        new Level(40).backEnemyValue().life, ShuXin.Jin)
                .showRect(false),
                schoolGifView.allBitmaps);

            upXiongGif.withTime_wait(100);
         }
    }




    public void initGIf() {
        if (schoolGifView.level.level>=16&&schoolGifView.level.level<=20) {
            if (xiongGifs == null) {
                xiongGifs = new GK2_XiongGif(new GifObj(25, schoolGifView.x, schoolGifView.y)
                        .withPoint(schoolGifView.x, 500).withSize(150, 150)
                        .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                                new Level(20).backEnemyValue().life, ShuXin.Huo),
                        schoolGifView.allBitmaps);
                xiongGifs.withTime_wait(50);

            }

            if (xiongGifs2 == null) {
                xiongGifs2 = new GK2_XiongGif2(new GifObj(25, schoolGifView.x, schoolGifView.y)
                        .withPoint(-150+5, 500-50).withSize(150, 150)
                        .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                                new Level(20).backEnemyValue().life, ShuXin.Huo),
                        schoolGifView.allBitmaps);
                xiongGifs2.withTime_wait(50);

            }
        }
    }

    public void drawCanvas(Canvas canvas){

//        for (BaseGifBag bgb:xiongGifs.bags ) {
//            bgb.path=new PathTest(bgb,1);
//        }
//        for (BaseGifBag bgb:xiongGifs2.bags ) {
//            bgb.path=new PathTest(bgb,2);
//        }


        if (xiongGifs !=null)  xiongGifs.drawCanvas(canvas);
        if (xiongGifs2 !=null)  xiongGifs2.drawCanvas(canvas);
        if (shuiGif!=null)shuiGif.drawCanvas(canvas);
        if (upXiongGif!=null)upXiongGif.drawCanvas(canvas);

        if (shuiGif2!=null)shuiGif2.drawCanvas(canvas);
        if (shuiGifBoss!=null) shuiGifBoss.drawCanvas(canvas);

    }










}
