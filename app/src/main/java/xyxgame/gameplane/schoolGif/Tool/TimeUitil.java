package xyxgame.gameplane.schoolGif.Tool;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.TimeZone;

import static android.content.Context.MODE_PRIVATE;

public class TimeUitil {



 private static final String fileName = "sharedtime";//定义保存的文件的名称



    public static void savaToday(Context context,long b){

        SharedPreferences share = context.getSharedPreferences(fileName, MODE_PRIVATE);//实例化
        SharedPreferences.Editor editor = share.edit(); //使处于可编辑状态

          editor.putLong("Today_ziro",b);
        editor.commit();    //提交数据保存
    }
    public static long getToday(Context context ){
        SharedPreferences share = context.getSharedPreferences(fileName, MODE_PRIVATE);//实例化
        return share.getLong("Today_ziro",0);
    }

    //主界面都去保存当天的时间
    public static void save(Context context){

        if (isOneDay(context))return;

            savaToday(context,day_StartTime());//保存零点时间戳

    }

    public static boolean isOneDay(Context context){
      //是同一天
        //拿现在的时间
      long now=day_NowTime();
      //拿储存的时间
      long today = getToday(context);

      if (today==0)return false;//如果拿到是1970：表示不是同一天

      return now-today<=day?true:false;

    }










    public static void test(Context context){

        //一天86400；
        Log.d("----", "getToday: "+   getToday(context)+" oneday "+isOneDay(context));


    }

  private  static long day=86400;

  public static long day_StartTime(){
      //获取今天零点时间戳
      long nowTime =System.currentTimeMillis();
      long dailyStartTime =nowTime - ((nowTime + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L));
      //十位时间戳
      String substring = String.valueOf(dailyStartTime).substring(0, 10);
      return Long.valueOf(substring);
  }

  public static long day_NowTime(){
      long NowTime = System.currentTimeMillis() / 1000;

      return NowTime;
  }


//  public static boolean isOneDay(){
//      return day_NowTime()-day_StartTime()<=day?true:false;
//  }
}
