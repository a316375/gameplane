package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBackGround;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;

public class GifGame extends BaseSurfaceVIEW {

    FPS fps;
    BaseBackGround backGround;



    ArrayList<BaseGIF> baseGIFS;


    BaseActivity mActivity;
    public GifGame(BaseActivity mActivity)  {
        super(mActivity);
        this.mActivity=mActivity;
        fps=new FPS();
        backGround=new BaseBackGround(mActivity, R.drawable.bg5);




        baseGIFS=new ArrayList<>();


    }




    int i=0;int j=0;

    @Override
    protected void onThreadDraw(Canvas canvas) {


        backGround.draw(canvas);


        i++;
        if (i>1000)i=0;
        if (i%10==0)j++;
        if (i%100==0)baseGIFS.add(new BaseGIF(mActivity,Bitmaps.getxue(mActivity),500,500,6));
        for (int k = 0; k <baseGIFS.size(); k++) {
            baseGIFS.get(k).draw(canvas);
        }





        fps.draw(canvas);
    }

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw() {

    }


    @Override
    public void startT() {
        super.startT();
        //重新唤醒屏幕，唤醒线程

    }
}
