package xyxgame.gameplane.Billing;

import android.util.Log;

import xyxgame.gameplane.schoolGif.SchoolGifView;

public class SchoolGIfBilling  implements Billing{

    SchoolGifView schoolGifView;

    public SchoolGIfBilling(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
    }

    @Override
    public void OK(String string) {
        Log.v("------","ok"+string);
        if (string.equals(Testbilling.vip1))   schoolGifView.money.all+=10000000;
        if (string.equals(Testbilling.vip2))   schoolGifView.money.all+=55000000;


    }

    @Override
    public void Cance() {
        Log.v("------","Cance");

    }

    @Override
    public void Error() {
        Log.v("------","Error");

    }
}
