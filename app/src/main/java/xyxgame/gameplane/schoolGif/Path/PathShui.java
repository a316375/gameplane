package xyxgame.gameplane.schoolGif.Path;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;

public class PathShui implements BaseGifBagPath {
    BaseGifBag baseGifBag;

    public  int showTime=200;
    public PathShui(BaseGifBag baseGifBag) {
        this.baseGifBag = baseGifBag;
    }

    int j=0;
    @Override
    public void drawpath() {

        if (j>showTime){baseGifBag.resetPath();j=0;return;}
        if (j<=showTime)j++;
    }


}
