package xyxgame.gameplane;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;
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
import com.snail.antifake.jni.EmulatorDetectUtil;


import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.schoolGif.Tool.IntentUtils;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.TimeUitil;
import xyxgame.gameplane.schoolGif.Tool.UIHide;
import xyxgame.gameplane.spaceshooter.MainMenuActivity;


public class MyActivity extends Activity  {

    private static final int RC_SIGN_IN =999;

    String WEB_ID = ShuXin.WEB_ID;
    private FirebaseAuth mAuth;

    private  String string;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIHide.hideNavKey(this);
        setContentView(R.layout.activity_main); // 别忘了开始的时候载入我们加工好的的SurfaceView



        if(EmulatorDetectUtil.isEmulator(this) )findViewById(R.id.button1).setVisibility(View.GONE);




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

                signIn();
                startAnima();

            }
        });



    }



    private void startAnima(){

        ImageView mImage = findViewById(R.id.imageView);
        mImage.setVisibility(View.VISIBLE);
        Glide.with(this).load(R.drawable.gif_yu6).into(mImage);

    }








    //登陆登出
    private void SignOut() {
        string=null;
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


    private void updateUI(@Nullable FirebaseUser user) {
        // No-op



        if(user!=null){

            //登陆成功
            Log.i("a user is logged in: ",user.getEmail());
            string=user.getUid();
            IntentUtils.startActivity(MyActivity.this,MainMenuActivity.class,new Info().withId(string));
            finish();
           // SignOut();

        }
        else{
            Log.i("Username", "there is no user");
           // findViewById(R.id.button1).setVisibility(View.GONE);
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

