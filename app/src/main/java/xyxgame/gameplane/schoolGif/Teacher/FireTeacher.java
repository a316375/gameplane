package xyxgame.gameplane.schoolGif.Teacher;

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




    int time=0;
    @Override
    public void PKResult() {


     if (time% (ShuXin.Speed*20) ==0)  PK(schoolGifView.xiong);

        time++;
        if (time>=500)time=0;


    }

    private void PK(BaseGifObj obj) {


        Iterator<BaseGifBag> iterator = effect.bags.iterator();
        while (iterator.hasNext()){
            BaseGifBag next = iterator.next();
            Iterator<BaseGifBag> iterator1 = obj.bags.iterator();
            while (iterator1.hasNext()){
                BaseGifBag objbag = iterator1.next();
                if (next.rect.intersect(objbag.rect)){

                    objbag.life-=next.hit;
                   schoolGifView.blastTextGif.addBag(next.hit,next.rect.left+next.w/2,next.rect.top+next.h/2);

                }
            }
        }


    }
}