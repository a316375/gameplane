package xyxgame.gameplane.Base;

public class MVVMActivity extends BaseActivity {

    private FrameSurfaceView frameSurfaceView;



    @Override
    protected BaseSurfaceVIEW setView() {


        //Log.d("X and Y size", "X = " + point.x + ", Y = " + point.y);
        frameSurfaceView = new FrameSurfaceView(this,new NUMManager(point.x,point.y));

        return frameSurfaceView;
    }

    @Override
    protected void viewResume() {
        frameSurfaceView.startT();

    }

    @Override
    protected void viewPause() {

        frameSurfaceView.stopT();


    }






}
