package model;

public class Troop {
    private String type;
    private int attack;
    private int defense;
    private int count;
    public Troop(String type,int attack,int defense)
    {
        this.type=type;
        this.attack=attack;
        this.defense=defense;
        this.count=0;
    }
    public Troop(String type,int attack,int defense,int count)
    {
        this.type=type;
        this.attack=attack;
        this.defense=defense;
        this.count=count;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}
