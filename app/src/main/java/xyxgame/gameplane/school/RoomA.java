package xyxgame.gameplane.school;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.BaseTeacher;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;

public class RoomA extends BaseSurfaceVIEW {


    BaseTeacher teacherA;
    RoomList list;
    RoomBG roomBG;
    FPS fps;

   public RoomA(BaseActivity context) {
        super(context);
        roomBG=new RoomBG(context,R.drawable.bg3);
        list=new RoomList(context);
        teacherA = new TeacherA(new TeacherFinishPK());
        fps=new FPS();


    }

    @Override//1用画布去绘制
    protected void onThreadDraw(Canvas canvas) {
        roomBG.draw(canvas);
        draws(list.listA,canvas);
        draws(list.listB,canvas);
        draws(list.listC,canvas);





        fps.draw(canvas);

    }



    @Override//2在这里刷新坐标,并且让teacher去解决这些pk结果
    protected void onFrameDrawFinish() {
         UPXY(list.listA);
         UPXY(list.listB);
         UPXY(list.listC);

         teacherA.pkResult(list);//


    }

    int j=0;
    @Override//3定时任务的循环清理，主要是负责清理空集合并且产生新的对象
    protected void onFrameDraw() {
                j++;
                if (j>100)j=0;
            if (j%10==0) list.AddList();

    }













    //集合迭代绘制
    protected void draws(ArrayList<BaseStudent> list,Canvas canvas){
        Iterator<BaseStudent> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next().draw(canvas);
        }
    }

    //集合迭代升级
    protected void UPXY(ArrayList list){
        Iterator<BaseStudent> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next().upXY();
        }
    };
}
