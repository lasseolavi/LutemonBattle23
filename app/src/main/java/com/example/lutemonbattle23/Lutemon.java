package com.example.lutemonbattle23;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int gamesWon;
    protected int trainingDays;

    public Lutemon(String name,String color, int attack, int defense, int experience, int health, int maxHealth, int id, int gamesWon, int trainingDays ){
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.gamesWon = gamesWon;
        this.trainingDays = trainingDays;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public int getAttack(){
        return attack;
    }
    public int getHealth(){
        return health;
    }
    public int getDefense(){
        return defense;
    }
    public int getExperience(){
        return experience;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getId(){
        return id;
    }
    public int getGamesWon() {return gamesWon;}
    public int getTrainingDays() { return trainingDays;};
    public void setHealth(int health){this.health = health;}
    public void addWonGame(){this.gamesWon += 1;}
    public void addTrainingDay(){this.trainingDays += 1;}
    public static void setExperience(Lutemon selectedLutemon) {
        selectedLutemon.experience = selectedLutemon.experience+1;
    }

}
