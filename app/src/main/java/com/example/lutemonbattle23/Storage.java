package com.example.lutemonbattle23;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private ArrayList<Lutemon> deadLutemons = new ArrayList<>();
    private ArrayList<Lutemon> allLutemons = new ArrayList<>();

    private static Storage storage = null;

    private static final String FILENAME = "lutemons.data";
    private int savedId;

    private Storage(){
    }
    public static Storage getInstance(){
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }
    public void addLutemon(Lutemon lutemon, Context context) {
        // The app will only save one ArrayList to file so we
        // merge lists and save that
        lutemons.add(lutemon);
        allLutemons.addAll(deadLutemons);
        allLutemons.addAll(lutemons);
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput(FILENAME,Context.MODE_PRIVATE));
            lutemonWriter.writeObject(allLutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
        // After saving the helper list will be cleared
        allLutemons.clear();
    }
    public void saveCurrentState(Context context) {
        allLutemons.addAll(deadLutemons);
        allLutemons.addAll(lutemons);
        try {
            ObjectOutputStream writer = new ObjectOutputStream(context.openFileOutput(FILENAME, Context.MODE_PRIVATE));
            writer.writeObject(allLutemons);
            writer.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
        allLutemons.clear();
    }
    public Storage loadLutemons(Context context) {
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput(FILENAME));
            allLutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            // We need to separate dead lutemons from alive ones
            for (Lutemon lutemon: allLutemons) {
                if (lutemon.getHealth() == 0 ) {
                    deadLutemons.add(lutemon);
                } else {
                    lutemons.add(lutemon);
                }
            }
            // Find out the highest id number and set id to the next
            savedId = allLutemons.isEmpty() ? 1 : allLutemons.get(allLutemons.size()-1).getId() +1 ;
            allLutemons.clear();
            lutemonReader.close();

        }catch (FileNotFoundException e){
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList listLutemons(){
        return lutemons;
    }
    public ArrayList getDeadLutemons(){return deadLutemons;}
    public void removeLutemon(Lutemon removableLutemon, Context context) {
        lutemons.remove(removableLutemon);
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput(FILENAME,Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
    }
    public int getSavedId(){return savedId;}
    public void killLutemon(Lutemon lutemon) {
        //remove dead lutemon from normal list and add it to dead list
        lutemons.remove(lutemon);
        deadLutemons.add(lutemon);
    }
    public void reviveLutemon(Lutemon lutemon) {
        lutemon.setHealth(lutemon.getMaxHealth());
        lutemons.add(lutemon);
        deadLutemons.remove(lutemon);
    }

}
