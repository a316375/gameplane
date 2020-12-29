package xyxgame.gameplane.schoolGif.Music;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import java.io.IOException;

import xyxgame.gameplane.R;

public class MusicPlayer  {




    Context context;
    private final Uri myUri;
    private final MediaPlayer mediaPlayer;

    public MusicPlayer(Context context) {
        this.context=context;
        // initialize Uri here
        myUri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.bg);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        run();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // 当前播放完毕
                run();
            }
        });



    }



    public void run() {

        try {

            mediaPlayer.reset();
            mediaPlayer.setDataSource(context, myUri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void onPause(){
        mediaPlayer.pause();
    }

    public void onStart(){
         mediaPlayer.start();
    }

}
