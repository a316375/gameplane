package xyxgame.gameplane.GL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import xyxgame.gameplane.Base.FrameSurfaceView;
import xyxgame.gameplane.R;
import xyxgame.gameplane.spaceshooter.GameView;

public class GLActivity extends AppCompatActivity {
    private GameSurfaceView mGameView;
    public Point point;

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
        point = new Point();
        display.getSize(point);
        //Log.d("X and Y size", "X = " + point.x + ", Y = " + point.y);

        mGameView = new GameSurfaceView(this, point.x, point.y);
        mGameView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(mGameView);


    }


    @Override
    protected void onResume() {
        mGameView.resume();

        super.onResume();


    }

    @Override
    protected void onPause() {
        mGameView.pause();

        super.onPause();

    }

}
