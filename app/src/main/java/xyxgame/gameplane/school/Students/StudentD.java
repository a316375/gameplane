package xyxgame.gameplane.school.Students;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentD extends BaseStudent {


    public StudentD(BaseBag baseBag) {
        super(  baseBag);
        mx=point.x/2;
        my=0;

    }

    @Override
    public void drawXP() {
        my+=10;
        if (my>500){mx-=15;}
    }


}
