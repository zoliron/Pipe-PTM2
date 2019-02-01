package Ex6;

import java.util.Random;

import Ex6.Q4.Consumer;
import Ex6.Q4.ParallelStreamer;
import Ex6.Q4.Producer;

public class MainTrain4 {

	public static void main(String[] args) {
		// test API
		Q4.testAPI();
		Random r=new Random();
		Producer<Integer> p=()->r.nextInt(100);
		Consumer<Integer> c=x->x+=2;
		
		ParallelStreamer<Integer> ps=new ParallelStreamer<>(5, p, c);
		ps.start();
		
		try { Thread.sleep(1000);} catch (InterruptedException e) {}
		
		if(Thread.activeCount()!=3)
			System.out.println("current num of threads is wrong (-10)");
		
		ps.stop();
		try { Thread.sleep(10);} catch (InterruptedException e) {}
		if(Thread.activeCount()!=1)
			System.out.println("current num of threads after stop() is wrong (-10)");
		
		
		System.out.println("done");
	}
}
