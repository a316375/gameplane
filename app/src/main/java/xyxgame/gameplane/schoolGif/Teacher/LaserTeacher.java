package xyxgame.gameplane.schoolGif.Teacher;

import android.graphics.Rect;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.Enemy.EnemyGIf;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.SchoolGifView;


//**处理laser的老师，注意，只能处理集合，本身不能创建对象，可以调用别的地方的对象集合**//
public class LaserTeacher {

    SchoolGifView schoolGifView;
    private final LaserGif laserGif;

    public LaserTeacher(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
        laserGif = schoolGifView.laserGif;
    }


    private void pk(BaseGifObj baseGifBag){
        Iterator<BaseGifBag> iterator = laserGif.bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            BaseGifBag bag = it.next();

            for (Iterator<BaseGifBag> iter = baseGifBag.bags.iterator(); iter.hasNext(); ) {
                BaseGifBag bagxiong = iter.next();
                if (Rect.intersects(bag.rect,bagxiong.rect)){

                    laserGif.bags.remove(bag);
                    bagxiong.life-=bag.hit;
                    if (bagxiong.life<=0)  baseGifBag.bags.remove(bagxiong);
                }
            }
        }
    }
    public void PKResult(){
        pk(schoolGifView.xiong);





    }

}
