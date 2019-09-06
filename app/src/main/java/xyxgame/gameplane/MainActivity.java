package xyxgame.gameplane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import xyxgame.gameplane.spaceshooter.MainMenuActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 别忘了开始的时候载入我们加工好的的SurfaceView

//        startActivity(new Intent(this, GameActivity.class));
        startActivity(new Intent(this, MainMenuActivity.class));
        this.finish();


    }


}

