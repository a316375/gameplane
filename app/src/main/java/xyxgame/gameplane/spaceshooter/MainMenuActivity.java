package xyxgame.gameplane.spaceshooter;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import xyxgame.gameplane.Acache.AcacheActivity;
import xyxgame.gameplane.Base.MVVMActivity;
import xyxgame.gameplane.GIf.GifActivity;
import xyxgame.gameplane.GL.GLActivity;
import xyxgame.gameplane.R;
import xyxgame.gameplane.school.ASchoolActivity;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mPlay,mPlay2,mPlay3,mPlay4,mPlay5,mPlay6, mHighScore, mExit;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Membuat tampilan menjadi full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Membuat tampilan selalu menyala jika activity aktif
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mPlay = findViewById(R.id.play);
        mPlay2 = findViewById(R.id.play2);
        mPlay3 = findViewById(R.id.play3);
        mPlay4 = findViewById(R.id.play4);
        mPlay5 = findViewById(R.id.play5);
        mPlay6 = findViewById(R.id.play6);
        mHighScore = findViewById(R.id.high_score);
        mExit = findViewById(R.id.exit);

        mPlay.setOnClickListener(this);
        mPlay2.setOnClickListener(this);
        mPlay3.setOnClickListener(this);
        mPlay4.setOnClickListener(this);
        mPlay5.setOnClickListener(this);
        mPlay6.setOnClickListener(this);
        mHighScore.setOnClickListener(this);
        mExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                startActivity(new Intent(this, MainActivity.class));
               // finish();
                break;
            case R.id.play2:
                startActivity(new Intent(this, GLActivity.class));
               // finish();
                break;
            case R.id.play3:
                startActivity(new Intent(this, MVVMActivity.class));
                // finish();
                break;
            case R.id.play4:
                startActivity(new Intent(this, AcacheActivity.class));
                // finish();
                break;
            case R.id.play5:
                startActivity(new Intent(this, ASchoolActivity.class));
                // finish();
                break;
                case R.id.play6:
                startActivity(new Intent(this, GifActivity.class));
                // finish();
                break;
            case R.id.high_score:
                startActivity(new Intent(this, HighScoreActivity.class));
                break;
            case R.id.exit:
                finish();
                break;
        }
    }
}
