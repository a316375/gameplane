package xyxgame.gameplane.schoolGif;

import android.graphics.Canvas;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifBaseObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class SchoolGifView extends BaseSurfaceVIEW {


    GifBG gifBG;
    FPS fps;
    GifObj gifObj;
    GifAllBitmaps allBitmaps;
    private final GifBaseObj gifBaseObj;

    public SchoolGifView(BaseActivity mBaseActivity) {
        super(mBaseActivity);
        gifBG=new GifBG(mBaseActivity, R.drawable.bg5);
        fps=new FPS();
        allBitmaps=new GifAllBitmaps(mBaseActivity);
        gifObj=new GifObj(25,mBaseActivity.point.x,mBaseActivity.point.y)
                .withSize(200,200)
                .withPoint(mBaseActivity.point.x/2,mBaseActivity.point.y)
               .withgiflist(1);


        gifObj.speed=5;
        gifBaseObj = new GifBaseObj(gifObj,allBitmaps);
    }

    @Override
    protected void onThreadDraw(Canvas canvas) {
        gifBG.draw(canvas);



        gifBaseObj.draw(canvas);


        fps.draw(canvas);

    }

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw() {

    }
}
