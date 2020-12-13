package xyxgame.gameplane.school;


import android.os.Handler;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.FrameSurfaceView;
import xyxgame.gameplane.Base.NUMManager;
import xyxgame.gameplane.R;

public class ASchoolActivity extends BaseActivity {

    private RoomA roomA;

    Handler handler=new  Handler();
    Runnable viewisOK=new Runnable() {
        @Override
        public void run() {


        }
    };


    @Override
    protected void setView() {

       // setContentView(R.layout.layout_wait);
        roomA = new RoomA(ASchoolActivity.this);
//        handler.postDelayed(viewisOK,5000);
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
