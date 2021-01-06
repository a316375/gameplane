package xyxgame.gameplane.schoolGif.Music;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import xyxgame.gameplane.R;

public class MusicUtilsBGM {




    Context context;

    private final ArrayList<Uri> uris;
    private final ArrayList<MediaPlayer> mediaPlayers;

    public MusicUtilsBGM(final Context context) {
        this.context=context;
        uris = new ArrayList<>();

        uris.add(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.schoolbg));


        mediaPlayers = new ArrayList<>();
        for (int i = 0; i <uris.size() ; i++) {

            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.reset();
                mediaPlayer.setDataSource(context, uris.get(i));
                mediaPlayer.prepare();
                mediaPlayer.start();
                mediaPlayers.add(mediaPlayer);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
       // Log.v("---","++"+mediaPlayers.size());

        final int[] i = {0};
        for (final MediaPlayer mediaPlayer1:mediaPlayers) {
            mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    // 当前播放完毕
                    if (i[0]>=mediaPlayers.size())i[0]=0;
                    mediaPlayer1.reset();
                    try {
                        mediaPlayer1.setDataSource(context, uris.get(i[0]));
                        mediaPlayer1.prepare();
                        i[0]++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer1.start();



                }
            });
        }







    }



    public void onPause(){
        for (MediaPlayer mediaPlayer:mediaPlayers ) {
            mediaPlayer.pause();
        }

    }

    public void onStart(){
        for (MediaPlayer mediaPlayer:mediaPlayers  ) {
         mediaPlayer.start();
    }
    }

}
