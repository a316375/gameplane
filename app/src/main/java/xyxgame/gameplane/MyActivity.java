package xyxgame.gameplane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.HashMap;
import java.util.Map;

import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.spaceshooter.MainMenuActivity;


public class MyActivity extends Activity   {

    private static final int RC_SIGN_IN =999;

    String WEB_ID = ShuXin.WEB_ID;
    private FirebaseAuth mAuth;

    private  String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 别忘了开始的时候载入我们加工好的的SurfaceView






        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

//
//        startActivity(new Intent(this, GameActivity.class));


//        startActivity(new Intent(this, MainMenuActivity.class));
//        this.finish();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(WEB_ID)
                .requestEmail()
                .build();

// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


// in OnClickListener


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Configure Google Sign In
                ok=true;
                signIn();

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                // Google sign out
                mGoogleSignInClient.signOut().addOnCompleteListener(MyActivity.this,
                        new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                updateUI(null);
                            }
                        });





            }
        });



        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (string==null)return;
                 DatabaseReference mDatabase  = FirebaseDatabase.getInstance().getReference();

                 writeNewUser(mDatabase,string+444,1,2,3000);


            }
        });



        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read from the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();

//                getUser(myRef,string+5555555);
               get_and_up_User(myRef,string+1244,500,220,200);



            }
        });









    }

    private void writeNewUser(DatabaseReference mDatabase,String userId, int a, int b,int c) {
        DatabaseReference hopperRef = mDatabase.child("info");

        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put(userId, new Info(a,b,c));

        hopperRef.updateChildren(hopperUpdates);

    }
    private void upNewUser(DatabaseReference mDatabase,String userId, int a, int b,int c) {

        DatabaseReference hopperRef = mDatabase.child("info");
        Map<String, Object> hopperUpdates = new HashMap<>();
        hopperUpdates.put(userId, new Info(a,b,c));
        hopperRef.updateChildren(hopperUpdates);

    }

    private void get_and_up_User(final DatabaseReference mDatabase, final String userId , final int newa, final int newb, final int newc) {

        //执行查询操作
        DatabaseReference hopperRef = mDatabase.child("info").child(userId);
        hopperRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Info post = dataSnapshot.getValue(Info.class);
                if (post==null){
                    //插入新的数据
                    writeNewUser(mDatabase,userId,newa,newb,newc); return;}
                   //升级数据
                Log.v("----------",post.toString());
                upNewUser(mDatabase,userId,newa,newb,newc);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }


    boolean ok=false;
    private void updateUI(@Nullable FirebaseUser user) {
        // No-op


        if(user!=null){

            Log.i("a user is logged in: ",user.getEmail());
            string=user.getUid();

            if (!ok)return;
            startActivity(new Intent(this, MainMenuActivity.class));
            finish();
        }
        else{
            Log.i("Username", "there is no user");
        }


    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }












    GoogleSignInClient mGoogleSignInClient;
    private void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }



    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            //  Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }


















    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


// Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }

    }




    private static final String TAG = "MainActivity";



}

