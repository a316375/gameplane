package xyxgame.gameplane.schoolGif.Tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.MyActivity;
import xyxgame.gameplane.spaceshooter.MainMenuActivity;

public class IntentUtils {

    public static void startActivity(Activity context, Class<?> activity){

        Intent intent = new Intent(context, activity);
         context.startActivity(intent);


    }


    public static void startActivity(Activity context, Class<?> activity, Info info){

        Intent intent = new Intent(context, activity);
        intent.putExtra(ShuXin.info_qu01, info);
        context.startActivity(intent);

    }

    public static Info getInfo(Activity context){
        return  (Info)context.getIntent().getSerializableExtra(ShuXin.info_qu01);
    }



    public static void startActivity(Activity context, Class<?> activity, String str){

        Intent intent = new Intent(context, activity);
        intent.putExtra("name", str);
        context.startActivity(intent);

    }

    public static String getStr(Activity contexts){
        return  (String)contexts.getIntent().getExtras().get("name").toString();
    }



}
