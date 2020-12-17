package xyxgame.gameplane.schoolGif;

import xyxgame.gameplane.Base.BaseActivity;

public class SchoolGifActivity extends BaseActivity {

    SchoolGifView schoolGifView;
    @Override
    protected void setView() {
        schoolGifView=new SchoolGifView(this);
        setContentView(schoolGifView);

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
