package xyxgame.gameplane.school.Students;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentB extends BaseStudent {


    public StudentB(  BaseBag baseBag) {
        super(  baseBag);
        mx_BaseStudent =point.x/2;
        my_BaseStudent =0;
    }

    @Override
    public void drawXP() {
        my_BaseStudent +=35;
    }


}
