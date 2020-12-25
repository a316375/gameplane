package xyxgame.gameplane.school;


import android.os.Handler;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;

public class ASchoolActivity extends BaseActivity {

    private RoomA roomA;

    Handler handler=new  Handler();
    Runnable viewisOK=new Runnable() {
        @Override
        public void run() {


        }
    };


    @Override
    protected BaseSurfaceVIEW setView() {

       // setContentView(R.layout.layout_wait);
        roomA = new RoomA(ASchoolActivity.this);
//        handler.postDelayed(viewisOK,5000);



        return roomA;
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
