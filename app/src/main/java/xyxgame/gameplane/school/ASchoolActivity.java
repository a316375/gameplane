package xyxgame.gameplane.school;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.FrameSurfaceView;
import xyxgame.gameplane.Base.NUMManager;

public class ASchoolActivity extends BaseActivity {

    private RoomA roomA;

    @Override
    protected void setView() {
        roomA = new RoomA(this);
        setContentView(roomA);
    }

    @Override
    protected void viewResume() {
        roomA.startT();
    }

    @Override
    protected void viewPause() {
        roomA.stopT();

    }
}
