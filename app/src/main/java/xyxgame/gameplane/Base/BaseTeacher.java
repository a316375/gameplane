package xyxgame.gameplane.Base;

import xyxgame.gameplane.school.StudentList;


//这个老师要解决括号里RoomList的pk结果
//pk是一个行为
public  abstract  class BaseTeacher  {
    private PK pk;

    public BaseTeacher(PK pk) {
        this.pk = pk;
    }

    public void  pkResult(StudentList list){
        pk.pk(list);
    }
}
