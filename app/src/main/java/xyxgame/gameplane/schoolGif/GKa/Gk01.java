package xyxgame.gameplane.schoolGif.GKa;

import android.graphics.Canvas;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif2;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif3;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class Gk01 {

    public final XiongGif xiongGifs,xiongGifs1,xiongGifs2;



    public Gk01(SchoolGifView schoolGifView) {
        xiongGifs = new XiongGif(new GifObj(20,schoolGifView.x,schoolGifView.y)
                .withPoint(schoolGifView.x/2,0).withSize(200,200)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,10,
                        new Level(schoolGifView.level.level).backEnemyValue().life, ShuXin.Huo),
                schoolGifView.allBitmaps);

          xiongGifs1 = new XiongGif2(new GifObj(20,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                  .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,10,
                          new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                  schoolGifView.allBitmaps);


        xiongGifs2 = new XiongGif3(new GifObj(20,schoolGifView.x,schoolGifView.y)
                .withPoint(schoolGifView.x,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,10,
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



}
