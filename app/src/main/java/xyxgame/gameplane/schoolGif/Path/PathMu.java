package xyxgame.gameplane.schoolGif.Path;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;

public class PathMu implements BaseGifBagPath {
   BaseGifBag baseGifBag;


    public PathMu(BaseGifBag baseGifBag) {
        this.baseGifBag = baseGifBag;

    }

    int j =0;
    @Override
    public void drawpath() {
        {
            j ++;
            if (j >100)baseGifBag.resetPath();
            if (j  >20) baseGifBag.y+=2;
            else    baseGifBag.y-=2;
            if (baseGifBag.y<20)baseGifBag.y=20;

        }

    }
}
