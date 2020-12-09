package xyxgame.gameplane.school;

import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.PK;

public class TeacherFinishPK implements PK {
    @Override
    public void pk(BaseStudent student1, BaseStudent student2) {
        if(student1 instanceof StudentA )
        {
            if (student1.my>=50)student2.drawXP();
        }
        if (student1 instanceof StudentB){
            if (student1.mx>=50)student2.drawXP();
            if (student2.my>150)student2.bitmap.recycle();
        }
    }
}
