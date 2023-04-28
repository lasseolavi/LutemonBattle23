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
    protected int gamesPlayed;
    protected int avatarImage;

    public Lutemon(String name,String color, int attack, int defense, int experience, int health, int maxHealth, int id, int gamesWon, int trainingDays, int gamesPlayed, int avatarImage ){
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
        this.gamesPlayed = gamesPlayed;
        this.avatarImage = avatarImage;
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
    public  int getGamesPlayed() {return gamesPlayed;}
    public int getAvatarImage() {return avatarImage;}
    public void setHealth(int health){this.health = health;}
    public void addWonGame(){this.gamesWon += 1;}
    public void addgamePlayed(){this.gamesPlayed += 1;}
    public static void addTrainingDay(Lutemon lutemon){
        lutemon.trainingDays += 1;
    }
    public static void setExperience(Lutemon selectedLutemon) {
        selectedLutemon.experience = selectedLutemon.experience+1;
    }

}
