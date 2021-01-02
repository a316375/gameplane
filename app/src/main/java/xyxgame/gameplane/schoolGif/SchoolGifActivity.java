package xyxgame.gameplane.schoolGif;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.DB.DB;
import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.schoolGif.Tool.IntentUtils;
import xyxgame.gameplane.schoolGif.Tool.SaveUtils;
import xyxgame.gameplane.schoolGif.Tool.UiThead;

public class SchoolGifActivity extends BaseActivity {

    SchoolGifView schoolGifView;




    @Override
    protected BaseSurfaceVIEW setView() {
        info= IntentUtils.getInfo(this);

        schoolGifView = new SchoolGifView(this);



        return schoolGifView;


    }




    @Override
    protected void viewResume() {
        schoolGifView.startT();


    }




    @Override
    protected void viewPause() {
        schoolGifView.stopT();



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase.getInstance().goOnline();
        DatabaseReference hopperRef = reference.child("info");


        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put( info.id, new Info(schoolGifView.level.level,schoolGifView.exp.exp,schoolGifView.money.all));

        hopperRef.updateChildren(hopperUpdates);
        ValueEventListener listener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Info infos=  snapshot.getValue(Info.class);
                // Toast.makeText(mBaseActivity,"--提交成功--",Toast.LENGTH_LONG).show();
                 info=infos.withId(info.id);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        hopperRef.addListenerForSingleValueEvent(listener);








    }


}
