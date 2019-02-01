package Ex6;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Q4 {

	public interface Producer<T>{
		public T produce();
	}
	
	public interface Consumer<T>{
		public void consume(T t); 
	}
	
	
	public static class ParallelStreamer<T>{

	    int bufferSize;
	    Producer<T> producer;
	    Consumer<T> consumer;

	    Thread producerThread, consumerThread;

	    ArrayBlockingQueue<T> arrayBlockingQueue;

	    volatile boolean stop;
		
		public ParallelStreamer(int bufferSize, Producer<T> p, Consumer<T> c) {
            this.bufferSize = bufferSize;
            this.producer = p;
            this.consumer = c;
            arrayBlockingQueue = new ArrayBlockingQueue<>(bufferSize);
            this.stop = false;
		}
		
		public void start(){
		    // Producer thread
		    producerThread = new Thread(() -> {
		        while(!stop){
                    try {
                        this.arrayBlockingQueue.put(this.producer.produce());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

		    // Consumer thread
            consumerThread = new Thread(() -> {
                while(!stop){
                    try {
                        this.consumer.consume(this.arrayBlockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            this.producerThread.start();
            this.consumerThread.start();

		}
		
		public void stop(){
		    this.stop = true;
		    this.producerThread.interrupt();
		    this.consumerThread.interrupt();
		}		
	}
	
	//------------------- test API -----------------
	public static void testAPI(){
		Random r=new Random();
		Producer<Integer> p=()->r.nextInt(100);
		Consumer<Integer> c=x->System.out.println(x);
		
		ParallelStreamer<Integer> ps=new ParallelStreamer<>(10, p, c);
		ps.start();
		
		try { Thread.sleep(1000);} catch (InterruptedException e) {}
		
		System.out.println("current num of threads is " + Thread.activeCount()); // should be 3 : main + producer thread + consumer thread
		
		ps.stop();
		try { Thread.sleep(10);} catch (InterruptedException e) {}
		System.out.println("current num of threads is " + Thread.activeCount()); // should be 1 : main
	}
	
}
