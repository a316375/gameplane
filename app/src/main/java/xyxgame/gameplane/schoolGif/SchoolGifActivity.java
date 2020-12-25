package xyxgame.gameplane.schoolGif;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;

public class SchoolGifActivity extends BaseActivity {

    SchoolGifView schoolGifView;






    @Override
    protected BaseSurfaceVIEW setView() {

          schoolGifView = new SchoolGifView(this);
        return schoolGifView;
    }














    @Override
    protected void viewResume() {
        schoolGifView.startT();


    }

    @Override
    protected void viewPause() {
        schoolGifView.stopT();

    }


}
