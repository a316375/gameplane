package xyxgame.gameplane.Billing;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.UIAlertDialog;

public class BillingView  {
    SchoolGifView schoolGifView;
    private final Testbilling testbilling;

    public BillingView(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
        testbilling = new Testbilling(schoolGifView.mBaseActivity, new SchoolGIfBilling(schoolGifView));
    }

    public void show(){
        final AlertDialog alertDialog = UIAlertDialog.showDialogLayout(schoolGifView.mBaseActivity, R.layout.showfabao);
        View decorView = alertDialog.getWindow().getDecorView();


        ImageView imageView_a=decorView.findViewById(R.id.image_a);
        imageView_a.setImageResource(R.drawable.vip1);
        ImageView imageView_b=decorView.findViewById(R.id.image_b);
        imageView_b.setImageResource(R.drawable.vip5);
        decorView.findViewById(R.id.ll_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                testbilling.start(Testbilling.vip1);
                alertDialog.dismiss();

            }
        });
        decorView.findViewById(R.id.ll_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testbilling.start(Testbilling.vip2);
                alertDialog.dismiss();
            }
        });
    }
}
