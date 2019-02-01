package Ex5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {

	public static class FileLines{
		List<String> lines;
		long lastModified;
	}

	public static class Cacher{
		
		HashMap<String, FileLines> cache;

		public Cacher() {
			cache = new HashMap<>();
		}
		
		public List<String> readFile(String fileName) throws IOException{
            FileLines fileLines = cache.get(fileName);
            if (fileLines == null){
                fileLines = new FileLines();
                cache.put(fileName,fileLines);
            }
            long lastModified = new File(fileName).lastModified();
            if (fileLines.lastModified != lastModified){
                fileLines.lines =  Files.lines(Paths.get(fileName)).collect(Collectors.toList());
                fileLines.lastModified = lastModified;
            }
            return cache.get(fileName).lines;
		}
		
		public int getCacheSize(){
			return cache.size();
		}
	}
	
	public static void mainAPI() throws Exception{
		Files.write(Paths.get("test1.txt"), "test1".getBytes()); // create test1.txt file
		Files.write(Paths.get("test2.txt"), "test2".getBytes()); // create test2.txt file
		
		Cacher c = new Cacher();
		c.readFile("test1.txt");
		System.out.println(c.getCacheSize()); // 1
		List<String> lines= c.readFile("test1.txt");
		System.out.println(c.getCacheSize()); // still 1, its the same unchanged file
		System.out.println(lines.get(0)); // test1
		lines=c.readFile("test2.txt");
		System.out.println(c.getCacheSize()); // 2
		System.out.println(lines.get(0)); // test2
		
		Files.write(Paths.get("test1.txt"), "changed test1".getBytes()); // change test1.txt file
		lines= c.readFile("test1.txt"); // will re-read the file
		System.out.println(lines.get(0)); // changed test1
		
	}
}
