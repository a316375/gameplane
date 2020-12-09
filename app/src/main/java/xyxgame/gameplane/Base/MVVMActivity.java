package xyxgame.gameplane.Base;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import xyxgame.gameplane.GL.GameSurfaceView;

public class MVVMActivity extends BaseActivity {

    private FrameSurfaceView frameSurfaceView;



    @Override
    protected void setView() {


        //Log.d("X and Y size", "X = " + point.x + ", Y = " + point.y);
        frameSurfaceView = new FrameSurfaceView(this,new NUMManager(point.x,point.y));
        setContentView(frameSurfaceView);
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
