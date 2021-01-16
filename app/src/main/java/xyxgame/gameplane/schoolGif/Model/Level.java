package xyxgame.gameplane.schoolGif.Model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class Level {


    public int level;
//输入等级
    public Level( int level ) {
          this.level=level;

      }

      //每天等级上限
      public int Max_Level_day(Context context){
        return Level_share.getFistlevel(context)+19;
//        return Level_share.getFistlevel(context)+5;
      }



   //返回攻击力*10，等级*100，需要经验值*500---玩家
    public value backValue(){
        return new value(level*10,level*100,20);
      }
    //返回攻击力*10，等级*100，需要经验值*500--敌人数值
    public value backEnemyValue(){
        return new value(level*50,level*200,level*2000);
    }


    public class value{
        public  int hit;
        public  int life;
        public  int exp;

        public value(int hit, int life, int exp) {
            this.hit = hit;
            this.life = life;
            this.exp = exp;
        }


    }



}

