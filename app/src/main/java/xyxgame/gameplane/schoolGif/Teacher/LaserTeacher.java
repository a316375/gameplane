package xyxgame.gameplane.schoolGif.Teacher;

import android.graphics.Point;
import android.graphics.Rect;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.Blast.BlastBags;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
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


    private void pk(final BaseGifObj baseGifBag){

        Iterator<BaseGifBag> iterator = laserGif.bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            final BaseGifBag bag = it.next();

            for (Iterator<BaseGifBag> iter = baseGifBag.bags.iterator(); iter.hasNext(); ) {
                final BaseGifBag bagxiong = iter.next();
                if (Rect.intersects(bag.rect,bagxiong.rect)){

                    schoolGifView.blastTextGif.addBags(new BlastBags(bag.hit,new Point(bag.rect.left,bag.rect.top)));
                    laserGif.bags.remove(bag);
                    bagxiong.life-=bag.hit;

                    if (bag.shuxin==ShuXin.Mu)bagxiong.path=new PathMu(bagxiong);
                    if (bag.shuxin==ShuXin.Shui)bagxiong.path=new PathShui(bagxiong);
                    if (bagxiong.life<=0)  baseGifBag.bags.remove(bagxiong);
                }
            }
        }
    }
    public void PKResult(){
        pk(schoolGifView.xiong);





    }

}
