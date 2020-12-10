package xyxgame.gameplane.school.Students;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentF extends BaseStudent {


    public StudentF(BaseBag baseBag) {
        super(  baseBag);
    }

    @Override
    public void drawXP() {
        my-=35;
    }


}
