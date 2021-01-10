package xyxgame.gameplane.schoolGif.GKa;

import android.graphics.Canvas;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.XiongBoss;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif2;
import xyxgame.gameplane.schoolGif.Enemy.XiongGif3;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UiThead;

public class Gk01 {

    public XiongGif xiongGifs;
    public XiongGif2 xiongGifs1;
    public XiongGif3 xiongGifs2;
    public XiongBoss xiongBoss;
    SchoolGifView schoolGifView;


    public Gk01(SchoolGifView schoolGifView) {
        this.schoolGifView=schoolGifView;
        if (schoolGifView.level.level<=16){  xiongGifs = new XiongGif(new GifObj(3,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(200,200)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level).backEnemyValue().life, ShuXin.Huo),
                schoolGifView.allBitmaps);
        xiongGifs.withTime_wait(100);}

        if (schoolGifView.level.level<=16)   {  xiongGifs1 = new XiongGif2(new GifObj(4,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(150,150)
                  .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                          new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                  schoolGifView.allBitmaps);
        xiongGifs1.withTime_wait(150);}


        if (schoolGifView.level.level<=16)  {  xiongGifs2 = new XiongGif3(new GifObj(24,schoolGifView.x,schoolGifView.y)
                .withPoint(0,0).withSize(100,100)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit,3,
                        new Level(schoolGifView.level.level/2).backEnemyValue().life,ShuXin.Huo),
                schoolGifView.allBitmaps);
        xiongGifs2.withTime_wait(30);}

        if (schoolGifView.level.level>=16&&schoolGifView.level.level<=19)initBoss(schoolGifView);




    }

    private void initBoss(SchoolGifView schoolGifView) {

        GifObj init = new GifObj(1, schoolGifView.x, schoolGifView.y)
                .withPoint(0, 0).withSize(250, 250)
                .init(schoolGifView.level.level, schoolGifView.level.backEnemyValue().hit, 3,
                        new Level(20*100).backEnemyValue().life, ShuXin.Boss);

        xiongBoss = new XiongBoss(init,
                schoolGifView.allBitmaps);

    }

    public void drawCanvas(Canvas canvas){

//        for (BaseGifBag bgb:xiongGifs.bags ) {
//            bgb.path=new PathTest(bgb,1);
//        }
//        for (BaseGifBag bgb:xiongGifs2.bags ) {
//            bgb.path=new PathTest(bgb,2);
//        }

        drawBossCanvas(canvas);
        if (xiongGifs!=null)  xiongGifs.drawCanvas(canvas);
        if (xiongGifs1!=null)   xiongGifs1.drawCanvas(canvas);
        if (xiongGifs2!=null)  xiongGifs2.drawCanvas(canvas);




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
        if (xiongGifs==null||xiongGifs1==null||xiongGifs2==null)return;
                exit(xiongGifs);
                exit(xiongGifs1);
               exit(xiongGifs2);


    }




    private void exit(  BaseGifObj baseGifBag){
        if (xiongBoss==null)  initBoss(schoolGifView);/////////触发退出后召回一个boss
        if (baseGifBag!=null)  baseGifBag.exit=true;
        if (baseGifBag.bags==null)return;
        for (BaseGifBag bag:baseGifBag.bags){
            bag.path=new exitPath(bag);
        }


    }



    class exitPath implements BaseGifBagPath{
        BaseGifBag baseGifBag;

        public exitPath(BaseGifBag baseGifBag) {
            this.baseGifBag = baseGifBag;
        }

        @Override
        public void drawpath() {

            if (baseGifBag.shuxin==ShuXin.Boss){
                baseGifBag.y-=5;
                if (baseGifBag.y<=10) baseGifBag.y-=35;
            }
            else {
                if (baseGifBag.x < baseGifBag.obj.maXx / 2) {
                    baseGifBag.x -= 5;
                    baseGifBag.y += 5;
                } else {
                    baseGifBag.x += 5;
                    baseGifBag.y += 5;
                }

            }
        }
    }


}
