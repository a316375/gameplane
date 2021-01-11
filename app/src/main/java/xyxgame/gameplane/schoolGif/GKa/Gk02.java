package xyxgame.gameplane.schoolGif.GKa;

import android.graphics.Canvas;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk02.GK2_XiongGif;
import xyxgame.gameplane.schoolGif.Enemy.gk02.GK2_XiongGif2;
import xyxgame.gameplane.schoolGif.Enemy.shui.ShuiGif;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class Gk02 {


    public GK2_XiongGif xiongGifs;
    public GK2_XiongGif2 xiongGifs2;


    SchoolGifView schoolGifView;

    public ShuiGif shuiGif;


    public Gk02(SchoolGifView schoolGifView) {
        this.schoolGifView=schoolGifView;


    initGIf();

    shuiGif=new ShuiGif( new GifObj(10, schoolGifView.x, schoolGifView.y)
            .withPoint(schoolGifView.x/2, 0).withSize(250, 250)
            .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                    new Level(20).backEnemyValue().life, ShuXin.Shui)
            .showRect(true),
            schoolGifView.allBitmaps);
    shuiGif.withTime_wait(150);



    }

    public void initGIf() {
        if (schoolGifView.level.level >= 16) {
            if (xiongGifs == null) {
                xiongGifs = new GK2_XiongGif(new GifObj(250, schoolGifView.x, schoolGifView.y)
                        .withPoint(schoolGifView.x, 500).withSize(150, 150)
                        .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                                new Level(20).backEnemyValue().life, ShuXin.Huo),
                        schoolGifView.allBitmaps);
                xiongGifs.withTime_wait(50);

            }

            if (xiongGifs2 == null) {
                xiongGifs2 = new GK2_XiongGif2(new GifObj(250, schoolGifView.x, schoolGifView.y)
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




    }










}
