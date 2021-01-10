package xyxgame.gameplane.Billing;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.schoolGif.SchoolGifActivity;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.IntentUtils;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.spaceshooter.MainMenuActivity;

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

        sendData(schoolGifView);//上传

    }

    private void sendData(final SchoolGifView schoolGifView) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase.getInstance().goOnline();
        DatabaseReference hopperRef = reference.child(ShuXin.info_qu01);


        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put( FirebaseAuth.getInstance().getUid(),
                new Info(schoolGifView.level.level,schoolGifView.exp.exp,schoolGifView.money.all));

        hopperRef.updateChildren(hopperUpdates);

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
