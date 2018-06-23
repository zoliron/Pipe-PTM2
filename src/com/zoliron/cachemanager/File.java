package com.zoliron.cachemanager;

import java.io.*;

public class File implements CacheManager{
	private String problem = null;

	public File(){
	}

	public static class Problem implements Serializable{
		public String maze = null;
	}

	@Override
	public void save(String newProblem) throws IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("newProblem.txt"));

		Problem saveProblem = new Problem();
		saveProblem.maze = newProblem;

		objectOutputStream.writeObject(saveProblem);
		objectOutputStream.close();

	}

	@Override
	public String load() throws IOException, ClassNotFoundException{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("newProblem.txt"));

		Problem loadProblem = (Problem)objectInputStream.readObject();

		objectInputStream.close();

		return loadProblem.maze;
	}


//    public static void main(String[] args) throws Exception {
//        File newFile = new File();
//        newFile.save("newTest");
//    }
}




