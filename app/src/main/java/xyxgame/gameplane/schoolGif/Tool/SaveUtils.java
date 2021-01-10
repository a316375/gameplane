package xyxgame.gameplane.schoolGif.Tool;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SaveUtils {
    private static final String fileName = "sharedfile";//定义保存的文件的名称
    public static void savaShared(Context activity, boolean b){
        SharedPreferences share = activity.getSharedPreferences(fileName, MODE_PRIVATE);//实例化
        SharedPreferences.Editor editor = share.edit(); //使处于可编辑状态
         editor.putBoolean("ad",b);
        editor.commit();    //提交数据保存
          }
    public static boolean getShared(Context activity){
       SharedPreferences share = activity.getSharedPreferences(fileName, MODE_PRIVATE);//实例化
       return share.getBoolean("ad",true);
    }

}
