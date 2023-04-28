package com.example.lutemonbattle23;

import java.util.ArrayList;

public class Statistics {

    private int pinkWins = 0;
    private int greenWins = 0;
    private int blackWins = 0;
    private int orangeWins = 0;
    private int whiteWins = 0;

    private int pinklosses = 0;
    private int greenlosses = 0;
    private int blacklosses = 0;
    private int orangelosses = 0;
    private int whitelosses = 0;


    private static Statistics statistics = null;

    private Statistics(){}

    public static Statistics getInstance() {
        if (statistics == null){
            statistics = new Statistics();
        }
        return statistics;
    }

    private void addWin(Lutemon lutemon) {
        switch (lutemon.getColor()) {
            case "Valkoinen":
                whiteWins += 1;
            case "Vihreä":
                greenWins += 1;
            case "Pinkki":
                pinkWins += 1;
            case "Oranssi":
                orangeWins += 1;
            case "Musta":
                blacklosses += 1;
        }
    }
}
