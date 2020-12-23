package xyxgame.gameplane.schoolGif.Path;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;

public class PathShui implements BaseGifBagPath {
    BaseGifBag baseGifBag;

    public PathShui(BaseGifBag baseGifBag) {
        this.baseGifBag = baseGifBag;
    }

    int j=0;
    @Override
    public void drawpath() {

        if (j>200)baseGifBag.resetPath();
        if (j<=200)j++;
    }


}
