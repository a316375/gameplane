package xyxgame.gameplane.school.Students;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentI extends BaseStudent {


    public StudentI(BaseBag baseBag) {
        super(  baseBag);
    }

    @Override
    public void drawXP() {
        my_BaseStudent -=35;
    }


}
