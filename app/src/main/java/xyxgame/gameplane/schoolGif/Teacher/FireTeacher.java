package xyxgame.gameplane.schoolGif.Teacher;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.FireEffect;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathShui;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class FireTeacher extends  Teacher {


    FireEffect effect;

    public FireTeacher(SchoolGifView schoolGifView) {
        super(schoolGifView);

        effect=schoolGifView.fireEffect;
    }




    int time=0;
    @Override
    public void PKResult() {


      if (time% 5==0) {
//         PK(schoolGifView.xiong);
//         PK(schoolGifView.gk01.xiongGifs);
         PK(schoolGifView.gk01.xiongGifs1);
         PK(schoolGifView.gk01.xiongGifs2);
         PK(schoolGifView.gk01.xiongGifs3);
         PK(schoolGifView.gk01.xiongGifs4);
         PK(schoolGifView.gk01.xiongGifs5);
         PK(schoolGifView.gk01.xiongGifs6);
         PK(schoolGifView.gk01.xiongGifs7);
         PK(schoolGifView.gk01.xiongBoss);
         PK(schoolGifView.gk02.xiongGifs);
         PK(schoolGifView.gk02.xiongGifs2);
         PK(schoolGifView.gk02.shuiGif);
          PK(schoolGifView.gk02.upXiongGif);
          PK(schoolGifView.gk02.shuiGif2);
          PK(schoolGifView.gk02.shuiGifBoss);
     }

        time++;
        if (time>=500)time=0;//防止int溢出


    }

    private void PK(BaseGifObj enemy_obj) {

        if (enemy_obj==null||enemy_obj.bags==null)return;
        Iterator<BaseGifBag> iterator = effect.bags.iterator();
        while (iterator.hasNext()){
            BaseGifBag next = iterator.next();
            Iterator<BaseGifBag> iterator1 = enemy_obj.bags.iterator();
            while (iterator1.hasNext()){
                BaseGifBag objbag = iterator1.next();
                objbag.FireTime++;

                if (objbag.FireTime>1500)objbag.FireTime=1;

                if (next.rect.intersect(objbag.rect)){
                    next.showtime=0;//添加持续时间,如果火特效被碰撞



                    if (objbag.FireTime% (ShuXin.Speed*10)==0){

                    objbag.life-=new Level(schoolGifView.level.level).backValue().hit;
                    schoolGifView.blastTextGif.addBag(new Level(schoolGifView.level.level).backValue().hit,next.rect.left+next.w/2,next.rect.top+next.h/2);
                    }
                    if (objbag.life<=0){
                        objbag.isDie=true;
                        if (objbag.shuxin==ShuXin.Shui)  schoolGifView.dieShui.add(objbag);;//添加死亡水特效
                        if (objbag.shuxin==ShuXin.Huo)  schoolGifView.fireEffect.add(objbag,schoolGifView.gifPlay.obj.level);;//添加死亡火特效
                        if (objbag.shuxin!=ShuXin.Boss)enemy_obj.bags.remove(objbag);//移除普通怪

                    }


                }
            }
        }


    }






}
