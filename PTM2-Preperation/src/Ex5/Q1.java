package Ex5;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Q1 {

	public static <T,R> void parallelMapper(List<T> data, int numOfThreads, Function<T, R> mapper, Map<T,R> theMap){
		int size = data.size() / numOfThreads;
		for(int i = 0 ; i < numOfThreads ; i++){
		    int fromIndex = i * size;
		    int toIndex = (i < numOfThreads - 1 ? (i+1) * size - 1 : data.size());
		    List<T> subList = data.subList(fromIndex, toIndex);
		    new Thread(() -> {
                subList.forEach(s -> theMap.put(s, mapper.apply(s)));
		    }).start();
        }
	}
	
	//------------------------------------ do not change from here.-----------------
	public static class Student{
		String name;
		public Student(String name) {
			this.name=name;
		}
		String getName(){return name;}
	}
	
	public static void mainAPI(){
		// create a list of 50 student names
		List<String> list=new LinkedList<>();
		for(int i=0;i<50;i++)
			list.add("Student_"+(i+1));
		// the map to store name->Student
		ConcurrentHashMap<String, Student> map=new ConcurrentHashMap<>();
		// map names to students in 7 parallel threads (6 threads with 7 names, 7th thread with 8 names)
		parallelMapper(list, 7, name->new Student(name), map);
		System.out.println(Thread.activeCount()); //should be 8 (main + 7)
		// wait a bit
		try {Thread.sleep(100);} catch (InterruptedException e) {}
		
		System.out.println(map.get("Student_50").getName()); // should be Student_50
		
	}
} 
