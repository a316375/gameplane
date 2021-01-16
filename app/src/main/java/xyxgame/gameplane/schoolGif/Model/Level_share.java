package xyxgame.gameplane.schoolGif.Model;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Level_share {
    private static final String fileName = "level";//定义保存的文件的名称
    public static void savaFistlevel(Context context, int b){
        SharedPreferences share = context.getSharedPreferences(fileName, MODE_PRIVATE);//实例化
        SharedPreferences.Editor editor = share.edit(); //使处于可编辑状态
        editor.putInt("FistStart",b);
        editor.commit();    //提交数据保存
    }

    //默认第一次启动
    public static int getFistlevel(Context context){
        SharedPreferences share = context.getSharedPreferences(fileName, MODE_PRIVATE);//实例化
        return share.getInt("FistStart",1);
    }
}
