package xyxgame.gameplane.schoolGif.Music;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.Tool.UiThead;

public class MusicUtils  {
    private   SoundPool mSoundPool;
    Context context;
    private int mLaserId;


    public   MusicUtils (Context context) {
        this.context=context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
         mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(20)
                    .setAudioAttributes(attributes)
                    .build();
        } else {
              mSoundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        }

        mLaserId = mSoundPool.load(context, R.raw.laser, 1);
        mSoundPool.setVolume(mLaserId,1,1);




    }
    boolean mThead=true;





    public   void playLaser(){

         mSoundPool.play(mLaserId, 0.5f, 0.5f, 1, 0, 1);

    }

    public void stop(){
        mSoundPool.stop(mLaserId);
    }


}
