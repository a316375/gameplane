package xyxgame.gameplane.Acache;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.Base.NUMManager;
import xyxgame.gameplane.GL.FPS;

public class AcacheSurfaceView extends BaseSurfaceVIEW {
    private FPS fps;

    Bitmap bitmap;
    public AcacheSurfaceView(BaseActivity activity,AcacheActivity A) {
        super(activity );
        fps=new FPS();
        bitmap=A.memoryCache.get("bg4");


    }

    @Override
    protected void onThreadDraw(Canvas canvas) {

        canvas.drawBitmap(bitmap,0,0,null);
        fps.draw(canvas);

    }

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw() {

    }
}
