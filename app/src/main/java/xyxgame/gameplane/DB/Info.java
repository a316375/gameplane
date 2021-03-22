package xyxgame.gameplane.DB;



import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class Info implements Serializable   {
    public String id;
    public   int level=-1;
    public  int exp=-1;
    public  int money=-1;

    public Info() {
    }
    public Info withId(String id) {
        this.id=id;
        return this;
    }

    public Info(int level, int exp, int money) {
        this.level = level;
        this.exp = exp;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Info{" +
                "level=" + level +
                ", exp=" + exp +
                ", money=" + money +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
