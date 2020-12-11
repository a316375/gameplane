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
        if (my_BaseStudent<30){
            my_BaseStudent +=2;
        }
        else {

            my_BaseStudent +=2;
            mx_BaseStudent -= (float) ((Math.tan(45)*my_BaseStudent)/999);}
    }


}
