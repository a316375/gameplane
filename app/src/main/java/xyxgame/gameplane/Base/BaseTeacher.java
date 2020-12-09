package xyxgame.gameplane.Base;

public  abstract  class BaseTeacher  {
    private PK pk;

    public BaseTeacher(PK pk) {
        this.pk = pk;
    }

    public void  pkResult(BaseStudent s1,BaseStudent s2){
        pk.pk(s1,s2);
    }
}
