package ru.gb.family_tree.model.family_tree.saver;

import java.io.*;

public class FileHandler implements Writable {
    private String filePath;

    public FileHandler() {
        filePath = "src/ru/gb/family_tree/model/family_tree/saver/tree_save.txt";
    }



    @Override
    public void save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
