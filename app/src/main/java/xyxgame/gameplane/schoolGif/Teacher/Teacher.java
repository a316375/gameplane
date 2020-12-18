package xyxgame.gameplane.schoolGif.Teacher;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.laser.LaserGif;

public class Teacher extends View {

    SchoolGifView schoolGifView;
    public Teacher(SchoolGifView schoolGifView) {
        super(schoolGifView.mBaseActivity);
        this.schoolGifView = schoolGifView;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (schoolGifView.buttonGif01.bags.size()<=0)return true;
                if (schoolGifView.buttonGif01.bags.get(0).rect.contains((int) event.getX(),(int) event.getY())){
                    Log.v("-------","------O-nClickListener---obj--"+schoolGifView.buttonGif01.obj.giflist);




                }

                if (schoolGifView.buttonGif02.bags.size()<=0)return true;
                if (schoolGifView.buttonGif02.bags.get(0).rect.contains((int) event.getX(),(int) event.getY())){
                    Log.v("-------","------O-nClickListener---obj--"+schoolGifView.buttonGif02.obj.giflist);


                }
                return true;}

        return true;
    }



}
