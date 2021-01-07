package xyxgame.gameplane.schoolGif;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.Billing.SchoolGIfBilling;
import xyxgame.gameplane.Billing.Testbilling;
import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.Music.MusicPlayer;

import xyxgame.gameplane.schoolGif.Tool.IntentUtils;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class SchoolGifActivity extends BaseActivity {

    SchoolGifView schoolGifView;


    MusicPlayer musicUtilsBGM;

    @Override
    protected BaseSurfaceVIEW setView() {
        info= IntentUtils.getInfo(this);

        schoolGifView = new SchoolGifView(this);




        return schoolGifView;


    }

    @Override
    public void init() {
        musicUtilsBGM=new MusicPlayer(this,R.raw.schoolbg)  ;

    }

    @Override
    protected void viewResume() {
        schoolGifView.startT();
        musicUtilsBGM.onStart();


    }




    @Override
    protected void viewPause() {
        schoolGifView.stopT();
        musicUtilsBGM.onPause();



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase.getInstance().goOnline();
        DatabaseReference hopperRef = reference.child(ShuXin.info_qu01);


        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put( FirebaseAuth.getInstance().getUid(), new Info(schoolGifView.level.level,schoolGifView.exp.exp,schoolGifView.money.all));

        hopperRef.updateChildren(hopperUpdates);
        ValueEventListener listener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Info infos=  snapshot.getValue(Info.class);
                // Toast.makeText(mBaseActivity,"--提交成功--",Toast.LENGTH_LONG).show();
                 info=infos.withId(FirebaseAuth.getInstance().getUid());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        hopperRef.addListenerForSingleValueEvent(listener);








    }


}
