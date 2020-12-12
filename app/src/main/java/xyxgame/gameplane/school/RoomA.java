package xyxgame.gameplane.school;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
    BaseStudent studentVIP_play;

   public RoomA(BaseActivity context) {
        super(context);
        backGround =new BackGround(context,R.drawable.bg5);
        list=new StudentList(context);
        teacherA = new TeacherA(new TeacherFinishPK());
        fps=new FPS();
        studentVIP_play= (BaseStudent) list.studentVIP_Play;


    }

    @Override//1用画布去绘制
    protected void onThreadDraw(Canvas canvas) {
        backGround.draw(canvas);

        draws(list.listB,canvas);
        draws(list.listC,canvas);
        draws(list.listD,canvas);
        draws(list.listVipA,canvas);
        draws(list.listVipB,canvas);

       //在最顶层
        draws(list.listA,canvas);
        draws(list.listVip_Play,canvas);
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
        if (j>10000)j=0;
        if (j%300==0)list.OnTimeClean=true;//定时清理产出敌人
        if (j%200==0&&new Random().nextInt(2)==0)list.onStudenB =true;//定时产出敌人
        if (j%20==0) list.onStudentA=true;//定时产生StudentA 代表子弹
        if (j%10==0)  list.AddList();//定时产生




    }







    private int lastX, lastY;//手指的位置
    private float pointX, pointY;//飞机的位置
    private int pointXFix, pointYFix;//最终飞机的位置
    //按下屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                    lastX = (int) event.getX();//保存手指临时值
                    lastY = (int) event.getY();
                    pointX = studentVIP_play.mx_BaseStudent;//保存飞机按下时候的原始位置
                    pointY = studentVIP_play.my_BaseStudent;



                break;
            case MotionEvent.ACTION_MOVE:

                    pointXFix = (int) (pointX + (event.getX() - lastX));
                    pointYFix = (int) (pointY + (event.getY() - lastY));

                studentVIP_play.moveToXY(pointXFix, pointYFix);


                break;


        }
        return true;
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
