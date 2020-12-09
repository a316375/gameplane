package xyxgame.gameplane.school;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.BaseTeacher;
import xyxgame.gameplane.Base.PK;
import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.BG;

public class RoomA extends BaseSurfaceVIEW {



    BaseTeacher teacherA;
    RoomList list;
    RoomBG roomBG;




    public RoomA(BaseActivity context) {
        super(context);

          roomBG=new RoomBG(context,R.drawable.bg3,1000,2000);
        list=new RoomList(context);
        teacherA = new TeacherA(new TeacherFinishPK());


    }

    @Override
    protected void onThreadDraw(Canvas canvas) {
        roomBG.draw(canvas);

        Iterator<BaseStudent> iterator = list.listA.iterator();
        while (iterator.hasNext()){
            iterator.next().draw(canvas);
        }

        Iterator<BaseStudent> iterator1 = list.listB.iterator();
        while (iterator1.hasNext()){
            iterator1.next().draw(canvas);
        }
        Iterator<BaseStudent> iterator2 = list.listC.iterator();
        while (iterator2.hasNext()){
            iterator2.next().draw(canvas);
        }

    }


    protected void UPXY(ArrayList list){
        Iterator<BaseStudent> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next().upXY();
        }
    };

    @Override
    protected void onFrameDrawFinish() {
         UPXY(list.listA);
         UPXY(list.listB);
         UPXY(list.listC);





    }

    int j=0;
    @Override
    protected void onFrameDraw() {
                j++;
                if (j>100)j=0;
            if (j%10==0) list.AddList();

    }
}
