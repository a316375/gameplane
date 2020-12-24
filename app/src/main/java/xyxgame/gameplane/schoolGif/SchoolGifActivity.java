package xyxgame.gameplane.schoolGif;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.spaceshooter.MainActivity;

public class SchoolGifActivity extends BaseActivity {

    SchoolGifView schoolGifView;
    private RewardedAd rewardedAd;
    private RewardedAdLoadCallback adLoadCallback;
    String s = "ca-app-pub-3940256099942544/5224354917";//测试id
//    String s = "ca-app-pub-7420611722821229/7438820365";


    @Override
    protected void setView() {
        schoolGifView=new SchoolGifView(this);
        setContentView(schoolGifView);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        rewardedAd = new RewardedAd(this, s
//                "ca-app-pub-7420611722821229/7438820365"
        );
        // Set app volume to be half of current device volume.
        MobileAds.setAppVolume(0.1f);


        adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.

                schoolGifView.showAD=true;
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);











    }



    public void show_AD(){

        if (rewardedAd.isLoaded()) {
            Activity activityContext = SchoolGifActivity.this;
            RewardedAdCallback adCallback = new RewardedAdCallback() {
                @Override
                public void onRewardedAdOpened() {
                    // Ad opened.
                }


                @Override
                public void onRewardedAdClosed() {
                    // Ad closed.

                    start=true;
                    schoolGifView.startT();
                    schoolGifView.startDrawThread();

                    rewardedAd = createAndLoadRewardedAd();

//                    schoolGifView.adList.clear();




                }

                @Override
                public void onUserEarnedReward(@NonNull RewardItem reward) {
                    // User earned reward.


                    schoolGifView.money.all+=10000;
                    schoolGifView.adList.clear();

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

        final RewardedAd rewardedAd = new RewardedAd(this,
                s
        );
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













    @Override
    protected void viewResume() {
        schoolGifView.startT();


    }

    @Override
    protected void viewPause() {
        schoolGifView.stopT();

    }


}
