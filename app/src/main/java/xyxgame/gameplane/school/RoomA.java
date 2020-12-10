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
    StudentList list;
    BackGround backGround;
    FPS fps;

   public RoomA(BaseActivity context) {
        super(context);
        backGround =new BackGround(context,R.drawable.bg3);
        list=new StudentList(context);
        teacherA = new TeacherA(new TeacherFinishPK());
        fps=new FPS();


    }

    @Override//1用画布去绘制
    protected void onThreadDraw(Canvas canvas) {
        backGround.draw(canvas);
        draws(list.listA,canvas);
        draws(list.listB,canvas);
        draws(list.listC,canvas);
        draws(list.listD,canvas);
        draws(list.listVipA,canvas);
        draws(list.listVipB,canvas);

        fps.draw(canvas);

    }



    @Override//2在这里刷新坐标,并且让teacher去解决这些pk结果
    protected void onFrameDrawFinish() {
         UPXY(list.listA);
         UPXY(list.listB);
         UPXY(list.listC);
         UPXY(list.listD);
         UPXY(list.listVipA);
         UPXY(list.listVipB);

         teacherA.pkResult(list);//


        j++;
        if (j>100)j=0;
        if (j%10==0) list.AddList();

    }

    int j=0;
    @Override//3定时任务的循环清理，主要是负责清理空集合并且产生新的对象//这里产生一些特殊事件，如boss进场时间
    protected void onFrameDraw() {


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
