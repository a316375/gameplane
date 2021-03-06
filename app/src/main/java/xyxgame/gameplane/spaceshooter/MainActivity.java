package xyxgame.gameplane.spaceshooter;

import android.graphics.Point;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import xyxgame.gameplane.R;

public class MainActivity extends AppCompatActivity
//        implements SensorEventListener
{

    private GameView mGameView;
    private float mXTemp;
//
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

        mGameView = new GameView(this, point.x, point.y);
        setContentView(mGameView);

        //http://converttosqlite.com/convert/把txt转换成sqlite的网址
        //https://inloop.github.io/sqlite-viewer/查看数据库视图
        //https://www.rebasedata.com/convert-sqlite-to-mysql-online 转换成xlsx

        //Sensor Accelerometer digunakan untuk menggerakan player ke kanan dan ke kiri
//        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
//        manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGameView.pause();
    }

//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        mXTemp = event.values[0];
//
//        if (event.values[0] > 1){
//            mGameView.steerLeft(event.values[0]);
//        }
//        else if (event.values[0] < -1){
//            mGameView.steerRight(event.values[0]);
//        }else{
//            mGameView.stay();
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {

//    }


    //以下是字典功能



}

