package xyxgame.gameplane.schoolGif.Teacher;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.Laser.LaserRewardBags;
import xyxgame.gameplane.schoolGif.SchoolGifView;

public class LaserRewardTeacher extends Teacher{
    public LaserRewardTeacher(SchoolGifView schoolGifView) {
        super(schoolGifView);
    }

    @Override
    public void PKResult() {
        Iterator<BaseGifBag> iterator = schoolGifView.laserRewardGif.bags.iterator();

        while (iterator.hasNext()){
            LaserRewardBags next = (LaserRewardBags) iterator.next();
            Iterator<BaseGifBag> iterator1 = schoolGifView.gifPlay.bags.iterator();
            while (iterator1.hasNext()){
                BaseGifBag next1 = iterator1.next();
                if (next.rect.intersect(next1.rect)){

                    ((LaserGif) schoolGifView.laserGif).setLaser_lv(next.getLv());
                    schoolGifView.laserRewardGif.bags.remove(next);
                }
            }


        }
    }
}
