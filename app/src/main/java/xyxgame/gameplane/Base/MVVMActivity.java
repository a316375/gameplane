package xyxgame.gameplane.Base;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import xyxgame.gameplane.GL.GameSurfaceView;

public class MVVMActivity extends AppCompatActivity {

    private FrameSurfaceView frameSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();


    }

    private void setView() {
        //Membuat tampilan menjadi full screen全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Membuat tampilan selalu menyala jika activity aktif
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

//        //硬件加速开启
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        //Mendapatkan ukuran layar
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        //Log.d("X and Y size", "X = " + point.x + ", Y = " + point.y);
         frameSurfaceView = new FrameSurfaceView(this);
        setContentView(frameSurfaceView);
    }


    @Override
    protected void onResume() {

        frameSurfaceView.startT();
        super.onResume();


    }

    @Override
    protected void onPause() {

        frameSurfaceView.stopT();
        super.onPause();

    }

}
