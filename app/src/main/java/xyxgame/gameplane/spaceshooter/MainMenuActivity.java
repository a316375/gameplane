package xyxgame.gameplane.spaceshooter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchUIUtil;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import xyxgame.gameplane.Acache.AcacheActivity;
import xyxgame.gameplane.Base.MVVMActivity;
import xyxgame.gameplane.DB.DB;
import xyxgame.gameplane.DB.DBBack;
import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.GIf.GifActivity;
import xyxgame.gameplane.GL.GLActivity;
import xyxgame.gameplane.MyActivity;
import xyxgame.gameplane.R;
import xyxgame.gameplane.school.ASchoolActivity;
import xyxgame.gameplane.schoolGif.SchoolGifActivity;
import xyxgame.gameplane.schoolGif.Tool.IntentUtils;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UIAlertDialog;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener  {


    private Button mPlay,mPlay2,mPlay3,mPlay4,mPlay5,mPlay6,mPlay7, mHighScore, mExit,msignOut;
    private Info info;
    private AlertDialog alertDialog;
    //



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main_menu);


        info = IntentUtils.getInfo(this);


        hideNavKey(this);



//        //Membuat tampilan menjadi full screen
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        //Membuat tampilan selalu menyala jika activity aktif
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



        mPlay = findViewById(R.id.play);
        mPlay2 = findViewById(R.id.play2);
        mPlay3 = findViewById(R.id.play3);
        mPlay4 = findViewById(R.id.play4);
        mPlay5 = findViewById(R.id.play5);
        mPlay6 = findViewById(R.id.play6);
        mPlay7 = findViewById(R.id.play7);
        mHighScore = findViewById(R.id.high_score);
        mExit = findViewById(R.id.exit);
        msignOut = findViewById(R.id.signOut);


        mPlay.setVisibility(View.GONE);
        mPlay2.setVisibility(View.GONE);
        mPlay3.setVisibility(View.GONE);
        mPlay4.setVisibility(View.GONE);
        mPlay5.setVisibility(View.GONE);
        mPlay6.setVisibility(View.GONE);



        mPlay.setOnClickListener(this);
        mPlay2.setOnClickListener(this);
        mPlay3.setOnClickListener(this);
        mPlay4.setOnClickListener(this);
        mPlay5.setOnClickListener(this);
        mPlay6.setOnClickListener(this);
        mPlay7.setOnClickListener(this);
        mHighScore.setOnClickListener(this);
        mExit.setOnClickListener(this);
        msignOut.setOnClickListener(this);
    }




            ;//隐藏底部
    public static void hideNavKey(Context context) {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = ((Activity) context).getWindow().getDecorView();

            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = ((Activity) context).getWindow().getDecorView();

            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }











    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                startActivity(new Intent(this, MainActivity.class));
               // finish();
                break;
            case R.id.play2:
                startActivity(new Intent(this, GLActivity.class));
               // finish();
                break;
            case R.id.play3:
                startActivity(new Intent(this, MVVMActivity.class));
                // finish();
                break;
            case R.id.play4:
                startActivity(new Intent(this, AcacheActivity.class));
                // finish();
                break;
            case R.id.play5:
                startActivity(new Intent(this, ASchoolActivity.class));
                // finish();
                break;
                case R.id.play6:
                startActivity(new Intent(this, GifActivity.class));
                // finish();
                break;
            case R.id.play7:
             //   startActivity(new Intent(this, SchoolGifActivity.class));

                alertDialog = UIAlertDialog.showDialogA(this);
                if (info.id==null)return;
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                FirebaseDatabase.getInstance().goOnline();
                final DatabaseReference hopperRef = reference.child("info").child(info.id);


                ValueEventListener listener=new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        alertDialog.dismiss();
                        Info infos=  snapshot.getValue(Info.class);
                        // Toast.makeText(mBaseActivity,"--提交成功--",Toast.LENGTH_LONG).show();
                        if (infos==null)

                        {DatabaseReference hopperRef = FirebaseDatabase.getInstance().getReference().child("info");

                        Map<String, Object> hopperUpdates = new HashMap<>();
                        hopperUpdates.put(info.id, new Info(1,0,9999));
                        hopperRef.updateChildren(hopperUpdates);
                         info= new Info(1,0,9999).withId(info.id);
                        }
                      else {  info=infos.withId(info.id);}

                        IntentUtils.startActivity(MainMenuActivity.this,SchoolGifActivity.class,info.withId(info.id));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                hopperRef.addListenerForSingleValueEvent(listener);






                // finish();
                break;
            case R.id.high_score:
                startActivity(new Intent(this, HighScoreActivity.class));
                break;
            case R.id.exit:

                finish();
                break;

                case R.id.signOut:
                FirebaseAuth.getInstance().signOut();

                 GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                         .requestIdToken( ShuXin.WEB_ID)
                         .requestEmail()
                         .build()).signOut();


                startActivity(new Intent(this, MyActivity.class));
                finish();
                break;
        }
    }


    @Override
    protected void onResume() {
        hideNavKey(this);
        super.onResume();

    }


}
