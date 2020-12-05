package xyxgame.gameplane.GL;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class BOSS extends SpriteManager {
    public BOSS(BTMAP bitmaps, int who, Point selfxy, Point cirxy) {
        super(bitmaps, who, selfxy, cirxy);
        setWidthandHight(500,500);

 }

    @Override
    public void UPXY() {

        selfxy.y+=1;

    }
}
