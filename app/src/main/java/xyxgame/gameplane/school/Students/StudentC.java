package xyxgame.gameplane.school.Students;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentC extends BaseStudent {


    public StudentC(  BaseBag baseBag) {
        super(  baseBag);
        mx_BaseStudent =point.x/2;
        my_BaseStudent =0;

    }

    int radio=500;
    float angle=0;
    @Override
    public void drawXP() {

        angle=angle+0.1f;//每次旋转0.2f度数
        if (angle >= 360) angle = 0;

        mx_BaseStudent = (int) (500 + radio * Math.sin(angle * Math.PI / 180));
       my_BaseStudent = (int) (500 - radio * Math.cos(angle * Math.PI / 180));//-是逆时针+是顺时针;
    }


}
