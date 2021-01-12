package xyxgame.gameplane.schoolGif.Path;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBagPath;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class   exitPath implements BaseGifBagPath {
    BaseGifBag baseGifBag;

    public exitPath(BaseGifBag baseGifBag) {
        this.baseGifBag = baseGifBag;
    }

    @Override
    public void drawpath() {

        if (baseGifBag.shuxin== ShuXin.Boss){
            baseGifBag.y-=5;
            if (baseGifBag.y<=10) baseGifBag.y-=35;
        }
        else {
            if (baseGifBag.x < baseGifBag.obj.maXx / 2) {
                baseGifBag.x -= 5;
                baseGifBag.y += 5;
            } else {
                baseGifBag.x += 5;
                baseGifBag.y += 5;
            }

        }
    }
}
