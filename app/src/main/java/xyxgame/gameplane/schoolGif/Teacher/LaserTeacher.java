package xyxgame.gameplane.schoolGif.Teacher;

import android.graphics.Rect;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.Laser.LaserGif;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;


//**处理laser的老师，注意，只能处理集合，本身不能创建对象，可以调用别的地方的对象集合**//
public class LaserTeacher {

    SchoolGifView schoolGifView;
    private final LaserGif laserGif;

    public LaserTeacher(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
        laserGif = schoolGifView.laserGif;
    }


    private void pk(final BaseGifObj baseGifBag){
        final int[] j = {0};
        Iterator<BaseGifBag> iterator = laserGif.bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            final BaseGifBag bag = it.next();

            for (Iterator<BaseGifBag> iter = baseGifBag.bags.iterator(); iter.hasNext(); ) {
                final BaseGifBag bagxiong = iter.next();
                if (Rect.intersects(bag.rect,bagxiong.rect)){

                    laserGif.bags.remove(bag);
                    bagxiong.life-=bag.hit;
                   if (laserGif.obj.ShuXin== ShuXin.Mu)bagxiong.path=new BaseGifBagPath() {
                       //风属性后退效果
                       @Override
                       public void drawpath() {
                           j[0]++;
                           if (j[0]>500)j[0]=21;
                         if (j[0] >20) bagxiong.y+=2;
                          else    bagxiong.y-=2;

                       }
                   };
                    if (bagxiong.life<=0)  baseGifBag.bags.remove(bagxiong);
                }
            }
        }
    }
    public void PKResult(){
        pk(schoolGifView.xiong);





    }

}
