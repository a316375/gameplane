package xyxgame.gameplane.DB;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;


public class Info implements Serializable   {
    public String id;
    public   int level;
    public  int exp;
    public  int money;

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
}
