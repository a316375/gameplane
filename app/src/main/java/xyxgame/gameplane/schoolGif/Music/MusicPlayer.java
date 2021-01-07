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

public class MusicPlayer implements MediaPlayer.OnPreparedListener  {




    Context context;
    private Uri myUri;
    private final MediaPlayer mediaPlayer;


    public MusicPlayer(Context context,int ID) {
        this.context=context;
        // initialize Uri here
        myUri = Uri.parse("android.resource://" + context.getPackageName() + "/" + ID);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        run();



    }





    public void run() {

        try {

            mediaPlayer.reset();

            mediaPlayer.setDataSource(context, myUri);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void onPause(){
        mediaPlayer.pause();
    }

    public void onStart(){

        run();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
}
