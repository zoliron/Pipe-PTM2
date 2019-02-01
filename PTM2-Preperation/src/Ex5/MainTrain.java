package Ex5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import Ex5.Q3.Cacher;

public class MainTrain {

	public static void main(String[] args) throws Exception {
		test1(); // Q1 10 points
		test2(); // Q1 10 points
		test3(); // Q1 10 points mode Hagasha
		test4(); // Q2 20 points mode Hagasha
		test5(); // Q3 5 points
		test6(); // Q3 5 points
		test7(); // Q3 10 points mode Hagasha
		test8(); // Q3 10 points mode Hagasha
		test9(); // Q4 20 points mode Hagasha
		System.out.println("if nothing is printed above then you have no mistakes in mode IMON. you may submit, good luck! :)");
	}

	private static void test9() {}

	private static void test8() {}

	private static void test7() {}

	private static void test6() throws Exception{
		Files.write(Paths.get("t1.txt"), "t1".getBytes()); // create t1.txt file

		Cacher c = new Cacher();
		c.readFile("t1.txt");
		c.readFile("t1.txt");
		List<String> l=c.readFile("t1.txt");
		if(!l.get(0).equals("t1")){
			System.out.println("files are not cached properly (-5)");
		}
	}

	private static void test5() throws Exception{
		Files.write(Paths.get("t1.txt"), "t1".getBytes()); // create t1.txt file

		Cacher c = new Cacher();
		c.readFile("t1.txt");
		c.readFile("t1.txt");
		c.readFile("t1.txt");
		if(c.getCacheSize()!=1){
			System.out.println("Cache is not the right size (-5)");
		}
	}

	private static void test4() {}

	private static void test3() {}

	private static void test2() {
		List<Integer> list=new LinkedList<>();
		for(int i=0;i<52;i++)
			list.add((i+1));
		ConcurrentHashMap<Integer, String> map=new ConcurrentHashMap<>();
		Q1.parallelMapper(list, 5, i->new String(""+i), map);
		// wait a bit
		try {Thread.sleep(100);} catch (InterruptedException e) {}

		if(!map.get(51).equals("51") || !map.get(52).equals("52"))
			System.out.println("parralel mapper did not output the correct result for 52 items and 5 threads (-10)");
	}

	private static void test1() {
		List<Integer> list=new LinkedList<>();
		for(int i=0;i<50;i++)
			list.add((i+1));
		ConcurrentHashMap<Integer, String> map=new ConcurrentHashMap<>();
		Q1.parallelMapper(list, 1, i->new String(""+i), map);
		// wait a bit
		try {Thread.sleep(100);} catch (InterruptedException e) {}

		boolean failed[]={false};
		map.forEach((i,s)->{
			if(!s.equals(""+i))
				failed[0]=true;
		});

		if(failed[0])
			System.out.println("parralel mapper did not output the correct result (-10)");

	}

}
