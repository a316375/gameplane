package xyxgame.gameplane.school;

import android.graphics.Canvas;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.BaseTeacher;
import xyxgame.gameplane.Base.PK;
import xyxgame.gameplane.R;

public class RoomA extends BaseSurfaceVIEW {

    BaseStudent baseStudent;
    BaseStudent studentA;
    BaseStudent studentB;
    BaseStudent studentC;

    BaseTeacher teacherA;
    public RoomA(BaseActivity context) {
        super(context);
        studentA=new StudentA((ASchoolActivity) context, R.drawable.bg);
        studentB=new StudentB((ASchoolActivity) context, R.drawable.bg);
        studentC=new StudentC((ASchoolActivity) context, R.drawable.bg3);


        teacherA = new TeacherA(new TeacherFinishPK());
    }

    @Override
    protected void onThreadDraw(Canvas canvas) {
        studentA.draw(canvas);
        studentB.draw(canvas);
        studentC.draw(canvas);

    }

    @Override
    protected void onFrameDrawFinish() {
       // studentB.UPXP();
        studentA.UPXP();
        teacherA.pkResult(studentA,studentB);
        teacherA.pkResult(studentB,studentC);

    }

    @Override
    protected void onFrameDraw() {

    }
}
