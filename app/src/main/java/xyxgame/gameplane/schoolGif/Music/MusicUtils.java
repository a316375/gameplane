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

public class MusicUtils {
    private static SoundPool mSoundPool;
    Context context;
    private int mLaserId;

    public   MusicUtils (Context context) {
        this.context=context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
     if(mSoundPool==null)       mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(20)
                    .setAudioAttributes(attributes)
                    .build();
        } else {
            if(mSoundPool==null)    mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        }
        mLaserId = mSoundPool.load(context, R.raw.laser, 1);


    }
    boolean mThead=true;





    public   void playLaser(){
        mSoundPool.play(mLaserId, 1, 1, 1, 0, 1);


    }

    public void stop(){
        mSoundPool.stop(mLaserId);
    }


}
