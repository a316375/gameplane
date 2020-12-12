package xyxgame.gameplane.school;

import xyxgame.gameplane.Base.BaseTeacher;
import xyxgame.gameplane.Base.PK;

public class TeacherA extends BaseTeacher {
    //把处理pk的类传给teacherA，这里使用传参方式，要求传入一个具体实现的类，而不是接口
    public TeacherA(PK pk) {
        super(pk);
    }
}
