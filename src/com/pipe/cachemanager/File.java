package com.pipe.cachemanager;

import java.io.*;

public class File implements CacheManager {
    private String problem;

    public static class Problem implements Serializable {
        public String maze = null;
    }

    @Override
    public void save(String newProblem) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.txt"));

        Problem saveProblem = new Problem();
        saveProblem.maze = newProblem;

        objectOutputStream.writeObject(saveProblem);
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("out.txt"));

        Problem newProblemRead = (Problem) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(newProblemRead.maze);
    }

    @Override
    public void load() {
    }


    public static void main(String[] args) throws Exception {
        File newFile = new File();
        newFile.save("newTest");
    }
}




