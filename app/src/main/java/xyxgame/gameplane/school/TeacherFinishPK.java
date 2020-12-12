package xyxgame.gameplane.school;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import xyxgame.gameplane.Base.BaseEffectStudent;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.PK;
import xyxgame.gameplane.school.Students.StudentB;
import xyxgame.gameplane.school.Students.StudentVIPA;

public class TeacherFinishPK implements PK {

     private void A_removePK(ArrayList<BaseStudent> listA,ArrayList<BaseStudent> list2)
         {

             Iterator<BaseStudent> iterator = listA.iterator();
             while (iterator.hasNext()){
                 BaseStudent next = iterator.next();

                 Iterator<BaseStudent> iterator1 = list2.iterator();
                 while (iterator1.hasNext())
                 { BaseStudent next1 = iterator1.next();
                     if (Rect.intersects(next.rect,next1.rect)){

                         int x=(int) next.mx_BaseStudent-list.listVIPA_Bitmaps.get(0).getWidth()/2+50;
                         int y=(int)next.my_BaseStudent-list.listVIPA_Bitmaps.get(0).getWidth()/2;
                         iterator.remove();
                         list. listVipA.add(new StudentVIPA(list.baseBagVIPA,list. listVIPA_Bitmaps,
                                 new Point(x,y)) );


                     }
                 }



         }
     }

     StudentList list;
    @Override
    public void pk(StudentList list) {
        this.list=list;
        A_removePK(list.listA,list.listB);
        A_removePK(list.listA,list.listC);
        A_removePK(list.listA,list.listD);



    }







    @Override
    public void Eating(StudentList list) {

        Iterator<BaseStudent> iterator = list.listB.iterator();
        while (iterator.hasNext()){
            BaseStudent next = iterator.next();
            if (next instanceof StudentB &&next.isEating==true){
               // 如果student正在吃东西//播放帧动画
                if (list.listVipB.size()<5)
                list.listVipB.add(new BaseEffectStudent(list.baseBagVIPB,list.listVIPB_Bitmaps,
                        new Point((int) next.mx_BaseStudent,(int)next.my_BaseStudent)).withRound());
               iterator.remove();
            }

        }

    }
}
