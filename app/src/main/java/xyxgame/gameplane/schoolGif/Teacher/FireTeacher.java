package xyxgame.gameplane.schoolGif.Teacher;

import android.util.Log;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.Effect.FireEffect;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class FireTeacher extends  Teacher {


    FireEffect effect;

    public FireTeacher(SchoolGifView schoolGifView) {
        super(schoolGifView);

        effect=schoolGifView.fireEffect;
    }





    @Override
    public void PKResult() {



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
        //  PK(schoolGifView.gk02.upxiongGifBoss);


    }

    private void PK(BaseGifObj enemy_obj) {

        if (enemy_obj==null||enemy_obj.bags==null)return;
        Iterator<BaseGifBag> fireiterator = effect.bags.iterator();
        while (fireiterator.hasNext()){
            BaseGifBag firebag = fireiterator.next();
//            firebag.FireTime++;
//            if (firebag.FireTime>1500)firebag.FireTime=1;
            Iterator<BaseGifBag> enemybag = enemy_obj.bags.iterator();
            while (enemybag.hasNext()){
                BaseGifBag enemy_bag = enemybag.next();




                if (firebag.rect.intersect(enemy_bag.rect)){
                    firebag.showtime=0;//添加持续时间,如果火特效被碰撞
//                    Log.d("-------", "PK: "+firebag.FireTime% 100);
//                    if (firebag.FireTime% 100==20){
////
//
//                        int lose_life = new Level(schoolGifView.level.level).backValue().hit;
//                        enemy_bag.startONFire_hit(schoolGifView,lose_life);//被火烧
////                       enemy_bag.life-=new Level(schoolGifView.level.level).backValue().hit;//计算伤害
////                    schoolGifView.blastTextGif.addBag(new Level(schoolGifView.level.level).backValue().hit,firebag.rect.left+firebag.w/2,firebag.rect.top+firebag.h/2);
//                        enemy_bag.startI(schoolGifView);//死亡经验奖励
//                        enemy_bag.startJ(schoolGifView);//死亡移除特效/产出特效
//                        enemy_bag.startK(enemy_obj);//移除对象或者标记死亡--Boss需要额外设置


//                         }
//



                }
            }
        }


    }






}
