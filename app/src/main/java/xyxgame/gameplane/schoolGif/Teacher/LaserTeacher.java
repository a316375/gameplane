package xyxgame.gameplane.schoolGif.Teacher;

import android.graphics.Point;
import android.graphics.Rect;

import java.util.Iterator;
import java.util.Random;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Blast.BlastBag;
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

        //升级攻击力
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
            final BaseGifBag laser_bag = it.next();

            for (Iterator<BaseGifBag> iter = baseGifBag.bags.iterator(); iter.hasNext(); ) {
                final BaseGifBag enemy_bag = iter.next();
                if (Rect.intersects(laser_bag.rect,enemy_bag.rect)){

                    int lei=0;
//                    if (bag.shuxin==ShuXin.Tu)return;
                    if (schoolGifView.leiEffect.open==true&&laser_bag.shuxin!=ShuXin.Huo){
                        schoolGifView.leiEffect.add_leiBag(enemy_bag,schoolGifView.gifPlay.obj.level);
                        lei=laser_bag.hit*5;
                      if (laser_bag.shuxin==ShuXin.Jin) schoolGifView.money.all-=30;
                      if (laser_bag.shuxin==ShuXin.Mu) schoolGifView.money.all-=20;
                      if (laser_bag.shuxin==ShuXin.Shui) schoolGifView.money.all-=10;

                    }

                    int add=new Random().nextInt(laser_bag.hit/10)+lei;
                   if (laser_bag.shuxin!=ShuXin.Huo)     schoolGifView.blastTextGif.addBag(laser_bag.hit+add,laser_bag.rect.left,laser_bag.rect.top);
                    laserGif.bags.remove(laser_bag);
                    if (laser_bag.shuxin!=ShuXin.Huo)   enemy_bag.life-=laser_bag.hit+add;

                    addexp();


                    if (laser_bag.shuxin==ShuXin.Mu){

                     schoolGifView.shuiEffect.remove_effcet(enemy_bag,ShuXin.Mu);
                     enemy_bag.path=new PathMu(enemy_bag);
                 if (enemy_bag.baseState!=null)  enemy_bag.baseState.changState(State.Att,enemy_bag,schoolGifView.allBitmaps);}

                    if (laser_bag.shuxin==ShuXin.Shui){
                        PathShui path = new PathShui(enemy_bag,100+schoolGifView.level.level*3);
                        enemy_bag.path= path;
                   if (enemy_bag.baseState!=null) enemy_bag.baseState.changState(State.Stop,enemy_bag,schoolGifView.allBitmaps);
                        GifObj gifObj = new GifObj() .withPoint(enemy_bag.x, enemy_bag.y + enemy_bag.h / 3)  .withSize(enemy_bag.w, enemy_bag.h / 2) ;
                         gifObj.life=enemy_bag.life;

                         schoolGifView.shuiEffect.add(gifObj, path.showTime);

                    }

                    if (laser_bag.shuxin==ShuXin.Huo){

                        schoolGifView.fireEffect.add(laser_bag,schoolGifView.gifPlay.obj.level);
                    }


                    //敌人被击败
                    if (enemy_bag.life<=0)  {


                        //移除水的特效
                        schoolGifView.shuiEffect.remove_effcet(enemy_bag,ShuXin.Null);

                        //移除敌人
                        baseGifBag.bags.remove(enemy_bag);
                        //奖励经验
                        schoolGifView.exp.exp+= schoolGifView.level.level*5;


                    }
                }
            }
        }
    }
    public void PKResult(){
//        pk(schoolGifView.xiong);
        pk(schoolGifView.gk01.xiongGifs);
        pk(schoolGifView.gk01.xiongGifs1);
        pk(schoolGifView.gk01.xiongGifs2);





    }

}
