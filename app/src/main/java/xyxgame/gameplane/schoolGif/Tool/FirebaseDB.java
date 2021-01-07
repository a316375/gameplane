package xyxgame.gameplane.schoolGif.Tool;

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
import xyxgame.gameplane.spaceshooter.MainMenuActivity;

public class FirebaseDB {


    public  FirebaseDB_I firebaseDB_i;

    public FirebaseDB(FirebaseDB_I firebaseDB_i) {
        this.firebaseDB_i = firebaseDB_i;
    }

    public  void Send(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference hopperRef = reference.child(ShuXin.db_ADID) ;


        ValueEventListener listener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot==null)return;
                String string= (String) snapshot.getValue();
                Log.v("----DB",string);
                firebaseDB_i.show_AD(string);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        hopperRef.addListenerForSingleValueEvent(listener);

    }
}
