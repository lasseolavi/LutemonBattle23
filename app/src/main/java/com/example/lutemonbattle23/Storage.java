package com.example.lutemonbattle23;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

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
        System.out.println(lutemons.size());
        lutemons.add(lutemon);
        System.out.println(lutemons.size());
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput(FILENAME,Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
    }
    public Storage loadLutemons(Context context) {
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput(FILENAME));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            // Find out the highest id number and set id to the next
            savedId = lutemons.isEmpty() ? 1 : lutemons.get(lutemons.size()-1).getId() +1 ;
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
    public Lutemon getLutemon(int id) {
        Lutemon chosenLutemon = null;
        for (Lutemon lutemon : lutemons){
            if (lutemon.id == id){
                chosenLutemon = lutemon;
                break;
            }
        }
        return chosenLutemon;
    }
    public ArrayList listLutemons(){
        return lutemons;
    }
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

}
