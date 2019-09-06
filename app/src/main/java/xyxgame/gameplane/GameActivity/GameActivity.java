package xyxgame.gameplane.GameActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import xyxgame.gameplane.R;

public class GameActivity extends Activity {

    private GView gView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Membuat tampilan menjadi full screen全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Membuat tampilan selalu menyala jika activity aktif
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //Mendapatkan ukuran layar
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        Log.d("X and Y size", "X = " + point.x + ", Y = " + point.y);


        gView = new GView(this,point.x, point.y);
        setContentView(gView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gView.pause();
    }


}
