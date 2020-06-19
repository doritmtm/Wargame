package model;

import java.util.Objects;

public class Troop {
    private String type;
    private int attack;
    private int defense;
    private int count;
    private int cost;
    public Troop(String type,int attack,int defense)
    {
        this.type=type;
        this.attack=attack;
        this.defense=defense;
        this.count=0;
        this.cost=0;
    }
    public Troop(String type,int attack,int defense,int cost)
    {
        this.type=type;
        this.attack=attack;
        this.defense=defense;
        this.count=0;
        this.cost=cost;
    }
    public Troop(String type,int attack,int defense,int cost,int count)
    {
        this.type=type;
        this.attack=attack;
        this.defense=defense;
        this.count=count;
        this.cost=cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Troop troop = (Troop) o;
        return attack == troop.attack &&
                defense == troop.defense &&
                count == troop.count &&
                cost == troop.cost &&
                Objects.equals(type, troop.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, attack, defense, count, cost);
    }
}
