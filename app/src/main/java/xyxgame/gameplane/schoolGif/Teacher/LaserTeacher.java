package xyxgame.gameplane.schoolGif.Teacher;

import android.graphics.Point;
import android.graphics.Rect;

import java.util.Iterator;
import java.util.Random;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Blast.BlastBags;
import xyxgame.gameplane.schoolGif.Effect.ShuiBag;
import xyxgame.gameplane.schoolGif.Effect.ShuiEffect;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathMu;
import xyxgame.gameplane.schoolGif.Path.PathShui;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;


//**处理laser的老师，注意，只能处理集合，本身不能创建对象，可以调用别的地方的对象集合**//
public class LaserTeacher {

    SchoolGifView schoolGifView;
    private final BaseGifObj laserGif;

    public LaserTeacher(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
        laserGif = schoolGifView.laserGif;
    }



    public void  addexp(){
        schoolGifView.exp.exp+=50;
        if (schoolGifView.exp.exp>schoolGifView.level.backValue().exp-1){
            schoolGifView.exp.exp=0;
            schoolGifView.level.level++;
            schoolGifView.gifPlay.obj.level=schoolGifView.level.level;
            schoolGifView.gifPlay.obj.hit=schoolGifView.level.backValue().hit;


           if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Jin)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*5;
           if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Mu)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*2;
           if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Shui)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*1;
           if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Huo)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*4;
           if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Tu)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*3;
        }


    }

    private void pk(  BaseGifObj baseGifBag){

        Iterator<BaseGifBag> iterator = laserGif.bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            final BaseGifBag bag = it.next();

            for (Iterator<BaseGifBag> iter = baseGifBag.bags.iterator(); iter.hasNext(); ) {
                final BaseGifBag enemy = iter.next();
                if (Rect.intersects(bag.rect,enemy.rect)){

                    int add=new Random().nextInt(bag.hit/10);
                    schoolGifView.blastTextGif.addBags(new BlastBags(bag.hit+add,new Point(bag.rect.left,bag.rect.top)));
                    laserGif.bags.remove(bag);
                    enemy.life-=bag.hit+add;

                    addexp();
                    if (bag.shuxin==ShuXin.Mu){enemy.path=new PathMu(enemy);
                    enemy.baseState.changState(State.Move,enemy,schoolGifView.allBitmaps);}
                    if (bag.shuxin==ShuXin.Shui){
                        PathShui path = new PathShui(enemy);
                        enemy.path= path;
                        enemy.baseState.changState(State.Stop,enemy,schoolGifView.allBitmaps);
                        GifObj gifObj = new GifObj() .withPoint(enemy.x, enemy.y + enemy.h / 3)  .withSize(enemy.w, enemy.h / 2).showRect(true) ;
                         gifObj.life=enemy.life;
                         schoolGifView.shuiEffect.add(gifObj, path.showTime);


                    }
                    if (enemy.life<=0)  {
                        Iterator<ShuiBag> iterator1 = schoolGifView.shuiEffect.shuiBags.iterator();
                        while (iterator1.hasNext()){
                            ShuiBag next = iterator1.next();
                            if (Rect.intersects(next.rect,enemy.rect)){
                                next.life=-100;
                            }
                        }

                        baseGifBag.bags.remove(enemy);


                    }
                }
            }
        }
    }
    public void PKResult(){
        pk(schoolGifView.xiong);





    }

}
