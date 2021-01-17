package xyxgame.gameplane.schoolGif.Teacher;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.die_shui.DieShui;
import xyxgame.gameplane.schoolGif.Effect.die_shui.DieShuiBags;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathShui;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class DieShuiTeacher extends Teacher{

    DieShui shui;
    public DieShuiTeacher(SchoolGifView schoolGifView) {
        super(schoolGifView);
        shui=schoolGifView.dieShui;
    }

    @Override
    public void PKResult() {

       // PK(schoolGifView.gk01.xiongGifs);
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
        PK(schoolGifView.gk02.upxiongGifBoss);
    }
    private void PK(BaseGifObj obj) {

        if (obj==null||obj.bags==null)return;
        Iterator<BaseGifBag> iterator = shui.bags.iterator();
        while (iterator.hasNext()){
            DieShuiBags next = (DieShuiBags) iterator.next();
            Iterator<BaseGifBag> iterator1 = obj.bags.iterator();
            while (iterator1.hasNext()){
                BaseGifBag objbag = iterator1.next();

                    if (next.rect.intersect(objbag.rect)){

                        if (next.time>next.maxtime){
                            addShuiPath_Effct(objbag);
                            shui.bags.remove(next);//移除自己
                             }

                    }
            }
        }
    }








    private void addShuiPath_Effct( BaseGifBag enemy_bag) {
        if ( enemy_bag.shuxin!=ShuXin.Boss){
//
            PathShui path = new PathShui(enemy_bag,100+schoolGifView.level.level*3);
            enemy_bag.path= path;
            if (enemy_bag.baseState!=null&&enemy_bag.state!= State.Stop) enemy_bag.baseState.changState(State.Stop,enemy_bag,schoolGifView.allBitmaps);
            GifObj gifObj = new GifObj() .withPoint(enemy_bag.x, enemy_bag.y + enemy_bag.h / 3)  .withSize(enemy_bag.w, enemy_bag.h / 2) ;
            gifObj.life=enemy_bag.life;



            if (enemy_bag.shuiEffect!=null) {
                enemy_bag.shuiEffect.reset_time();
                enemy_bag.shuiEffect.add(enemy_bag,path.showTime);
            }


        }
    }
}
