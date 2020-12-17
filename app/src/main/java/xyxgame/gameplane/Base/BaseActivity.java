package xyxgame.gameplane.Base;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import xyxgame.gameplane.GL.GameSurfaceView;
import xyxgame.gameplane.R;




//**在此类下新建的sufcaseview 必须去实现start跟stop方法，以此来绑定生命周期**///
public abstract class BaseActivity extends AppCompatActivity {

    public Point point;
    public boolean start=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        setView();


    }

    protected abstract void setView();

    protected abstract void viewResume();
    protected abstract void viewPause();

    ;

    @Override
    protected void onResume() {

        start=true;
        viewResume();
        super.onResume();


    }

    @Override
    protected void onPause() {
        start=false;
        viewPause();

        super.onPause();

    }

}
