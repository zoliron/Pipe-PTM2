package com.pipe.cachemanager;

import java.io.*;

public class File implements CacheManager {
    private String newProblem;

    public File(String newProblem) {
        this.newProblem = newProblem;
    }

    public static class Problem implements Serializable {
        public String maze = null;
    }

    @Override
    public void save(String newProblem) {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.txt"));

        Problem newProblem = new Problem();
        newProblem.maze = "Test";

        objectOutputStream.writeObject(newProblem);
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("out.txt"));

        Problem newProblemRead = (Problem) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(newProblemRead.maze);
    }

    @Override
    public void load() {

    }




