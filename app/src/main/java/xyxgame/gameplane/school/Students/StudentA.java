package xyxgame.gameplane.school.Students;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentA extends BaseStudent {


    public StudentA(  BaseBag baseBag   ) {
        super(  baseBag);


    }


    @Override
    public void creatRect() {
        rect.set((int)mx_BaseStudent ,
                (int)my_BaseStudent,
                (int)mx_BaseStudent+bitmap.getWidth(),
                (int)my_BaseStudent+bitmap.getHeight()*1/5);
    }

    @Override
    public void drawXP() {

        my_BaseStudent -=15;
    }


}
