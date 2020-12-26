package xyxgame.gameplane.DB;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class DB   {
    String id;
    private  DatabaseReference myRef;
    DBBack dbBack;
    public  FirebaseDatabase database;
    public ValueEventListener listener;

    public DB(String id, DBBack dbBack) {
        this.id = id;
        if (database==null)
        // Read from the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
//        database.setPersistenceEnabled(true);
//        myRef.keepSynced(true);
        up_User( dbBack);//查询.如果没有则初始化

    }



    public void close(){

        myRef.onDisconnect().setValue("Disconnected!");
    }

    private void up_User(  final DBBack db ) {

        if (myRef==null||id==null)return;
        //执行查询操作
        DatabaseReference hopperRef = myRef.child("info").child(id);
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Info post = dataSnapshot.getValue(Info.class);
                if (db == null) return;
                if (post == null) {
                    db.EmptyInfo();
                    return;
                }

                db.getInfo(post);//处理回调


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };
//        hopperRef.addValueEventListener(listener);
        hopperRef.addListenerForSingleValueEvent(listener);//一次监听


    }





    public void writeNewUser(   int a, int b,int c) {
        if (myRef==null)return;
        DatabaseReference hopperRef = myRef.child("info");

        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put(id, new Info(a,b,c));

        hopperRef.updateChildren(hopperUpdates);

    }
    public void upNewUser( String userId, int a, int b,int c) {
        if (myRef==null||userId==null)return;

        DatabaseReference hopperRef = myRef.child("info");
        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put(userId, new Info(a,b,c));
        hopperRef.updateChildren(hopperUpdates);

    }



}
