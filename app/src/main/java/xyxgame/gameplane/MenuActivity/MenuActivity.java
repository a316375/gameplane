package xyxgame.gameplane.MenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;

import xyxgame.gameplane.GameActivity.GameActivity;
import xyxgame.gameplane.R;

public class MenuActivity extends Activity implements View.OnClickListener {
    private Button mPlay, mHighScore, mExit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Membuat tampilan menjadi full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Membuat tampilan selalu menyala jika activity aktif
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mPlay = findViewById(R.id.play);
        mHighScore = findViewById(R.id.high_score);
        mExit = findViewById(R.id.exit);

        mPlay.setOnClickListener(this);
        mHighScore.setOnClickListener(this);
        mExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                startActivity(new Intent(this, GameActivity.class));
                finish();
                break;
            case R.id.high_score:
                startActivity(new Intent(this, GameActivity.class));
                break;
            case R.id.exit:
                finish();
                break;
        }
    }
}
