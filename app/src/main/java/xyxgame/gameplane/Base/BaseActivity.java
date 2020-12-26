package xyxgame.gameplane.Base;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Map;

import xyxgame.gameplane.GL.GameSurfaceView;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.AD.AD;
import xyxgame.gameplane.schoolGif.AD.BaseAD;
import xyxgame.gameplane.schoolGif.SchoolGifActivity;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UiThead;


//**在此类下新建的sufcaseview 必须去实现start跟stop方法，以此来绑定生命周期**///
public abstract class BaseActivity extends AppCompatActivity {

    public Point point;
    public boolean start=true;

    private RewardedAd rewardedAd;
    private RewardedAdLoadCallback adLoadCallback;
    String s = ShuXin.id;//测试id


    AD mad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavKey(this);
        super.onCreate(savedInstanceState);
        //Membuat tampilan menjadi full screen全屏

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        //Membuat tampilan selalu menyala jika activity aktif
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);//不允许截屏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        //硬件加速开启
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        //Mendapatkan ukuran layar
        Display display = getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        //Log.d("X and Y size", "X = " + point.x + ", Y = " + point.y);


        BaseSurfaceVIEW baseSurfaceVIEW = setView();
        setContentView(baseSurfaceVIEW);

        mad=new BaseAD(baseSurfaceVIEW);









        initAD();


    }










    public void initAD() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {



                Map<String, AdapterStatus> adapterStatusMap = initializationStatus.getAdapterStatusMap();
                for (Map.Entry<String, AdapterStatus> entry : adapterStatusMap.entrySet()) {


                    Log.v("ADMOB",entry.getKey()+"----"+entry.getValue().getDescription()+"-"+entry.getValue().getInitializationState().name());
                }


            }
        });

        rewardedAd = new RewardedAd(this, s
//                "ca-app-pub-7420611722821229/7438820365"
        );
        // Set app volume to be half of current device volume.
        MobileAds.setAppVolume(0.05f);


        adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.

               mad.coming();

            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.

            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }

    public boolean  AD_FINISHED=false;
    public void show_AD(){

        if (rewardedAd.isLoaded()) {
            Activity activityContext = BaseActivity.this;
            RewardedAdCallback adCallback = new RewardedAdCallback() {
                @Override
                public void onRewardedAdOpened() {
                    // Ad opened.
                }


                @Override
                public void onRewardedAdClosed() {
                    // Ad closed.

                    start=true;

                    mad.exit();


                    if (!AD_FINISHED)
                    UiThead.runInUIThread(new Runnable() {
                        @Override
                        public void run() {
                            rewardedAd = createAndLoadRewardedAd();//关闭时候重新加载新的
                            mad.reload();
                        }
                    }, ShuXin.ADTime);



//                    schoolGifView.adList.clear();




                }

                @Override
                public void onUserEarnedReward(@NonNull RewardItem reward) {
                    // User earned reward.


                    mad.FinishOK();
                    AD_FINISHED=true;


                }

                @Override
                public void onRewardedAdFailedToShow(AdError adError) {
                    // Ad failed to display.



                }


            };
            rewardedAd.show(activityContext, adCallback);
        } else {


            //rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);


            Log.d("TAG", "The rewarded ad wasn't loaded yet.");
        }

    }



    public RewardedAd createAndLoadRewardedAd() {

        final RewardedAd rewardedAd = new RewardedAd(this,  s  );
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.


            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        return rewardedAd;
    }











    protected abstract BaseSurfaceVIEW setView();

    protected abstract void viewResume();
    protected abstract void viewPause();




//    /**
//     * 通过设置全屏，设置状态栏透明
//     *
//     * @param activity
//     */
//    private void fullScreen(Activity activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
//                Window window = activity.getWindow();
//                View decorView = window.getDecorView();
//                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
//                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                decorView.setSystemUiVisibility(option);
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                window.setStatusBarColor(Color.TRANSPARENT);
//                //导航栏颜色也可以正常设置
////                window.setNavigationBarColor(Color.TRANSPARENT);
//            } else {
//                Window window = activity.getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//                attributes.flags |= flagTranslucentStatus;
////                attributes.flags |= flagTranslucentNavigation;
//                window.setAttributes(attributes);
//            }
//        }
//    }








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
    protected void onResume() {
        hideNavKey(this);
        start=true;
        viewResume();
        super.onResume();


    }

    @Override
    protected void onPause() {
        start=false;
        viewPause();

        super.onPause();

    }



}
