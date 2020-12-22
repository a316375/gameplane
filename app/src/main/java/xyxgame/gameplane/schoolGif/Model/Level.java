package xyxgame.gameplane.schoolGif.Model;

import android.util.Log;

import java.util.ArrayList;

public class Level {


    public int level;
//输入等级
    public Level( int level ) {
          this.level=level;

      }
   //返回攻击力*10，等级*100，需要经验值*500---玩家
    public value backValue(){
        return new value(level*10,level*100,level*500);
      }
    //返回攻击力*10，等级*100，需要经验值*500--敌人数值
    public value backEnemyValue(){
        return new value(level*5,level*500,level*1500);
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

