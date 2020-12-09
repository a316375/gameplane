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

    @Override
    protected void onFrameDrawFinish() {
        Iterator<BaseStudent> iterator = list.listA.iterator();
        while (iterator.hasNext()){
            iterator.next().UPXP();
        }

        Iterator<BaseStudent> iterator1 = list.listB.iterator();
        while (iterator1.hasNext()){
            iterator1.next().UPXP();
        }
        Iterator<BaseStudent> iterator2 = list.listC.iterator();
        while (iterator2.hasNext()){
            iterator2.next().UPXP();
        }

    }

    int j=0;
    @Override
    protected void onFrameDraw() {
                j++;
            if (j%10==0) list.AddList();
    }
}
