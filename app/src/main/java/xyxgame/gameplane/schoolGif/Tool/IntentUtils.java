package xyxgame.gameplane.schoolGif.Tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import xyxgame.gameplane.DB.Info;
import xyxgame.gameplane.MyActivity;
import xyxgame.gameplane.spaceshooter.MainMenuActivity;

public class IntentUtils {
   public static String info_name="info";
    public static void startActivity(Activity context, Class<?> activity, Info info){

        Intent intent = new Intent(context, activity);
        intent.putExtra(info_name, info);
        context.startActivity(intent);

    }

    public static Info getInfo(Activity context){
        return  (Info)context.getIntent().getSerializableExtra(info_name);
    }



}
