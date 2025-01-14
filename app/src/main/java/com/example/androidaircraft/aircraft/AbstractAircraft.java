package com.example.androidaircraft.aircraft;


import com.example.androidaircraft.basic.AbstractFlyingObject;
import com.example.androidaircraft.bullet.AbstractBullet;

import java.util.List;

/**
 * 所有种类飞机的抽象父类：
 * 敌机（BOSS, ELITE, MOB），英雄飞机
 *
 * @author hitsz
 */
public abstract class AbstractAircraft extends AbstractFlyingObject {
    /**
     * 生命值
     */
    protected int maxHp;

    public void setHp(int hp) {
        this.hp = hp;
    }

    protected int hp;

    public AbstractAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY);
        this.hp = hp;
        this.maxHp = hp;
    }

    public void decreaseHp(int decrease){
        hp -= decrease;
        if(hp <= 0){
            hp=0;
            vanish();
        }
    }

    public void raiseHp(int raise){
        hp += raise;
        if(hp >=maxHp){
            hp = maxHp;
        }
        if(hp <= 0){
            hp=0;
            vanish();
        }
    }


    public int getHp() {
        return hp;
    }

    public int getDirection() {
        return direction;
    }

    private final int direction = -1;

    public int getPower() {
        return power;
    }

    private final int power = 30;

    /**
     * 飞机射击方法，可射击对象必须实现
     * @return
     *  可射击对象需实现，返回子弹
     *  非可射击对象空实现，返回null
     */
    public abstract List<AbstractBullet> shoot();

}



