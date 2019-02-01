//package Ex4;
//
//import java.awt.Point;
//import java.util.Random;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class Q1 {
//
//	public static class Stream<T>{
//
//
//		public interface Predicate<E>{
//			________________________
//		}
//
//		BlockingQueue<T> buffer;
//		volatile boolean stop;
//		____________________________________;
//		____________________________________;
//
//		public Stream() {
//			buffer=new LinkedBlockingQueue<T>();
//			stop=false;
//		}
//
//
//		public void push(T t){
//			buffer.add(t);
//		}
//
//		public ______________ filter(___________ p){
//			/* ������ �� ���� */
//		}
//
//
//		public BlockingQueue<T> getBuffer(){
//			return buffer;
//		}
//
//		public void endOfStream() {
//			/* ������ �� ���� */
//		}
//	}
//
//	public static void mainAPI() throws Exception{
//		BlockingQueue<Point> result;
//		// define the stream
//		Stream<Point> s=new Stream<>();
//		result = s.filter(p->p.x>=0).filter(p->p.y<=0).getBuffer();
//		// the stream is still empty.
//
//		// printing thread
//		final boolean[] stop={false};
//		new Thread(()->{
//			try {
//				while(!stop[0])
//					while(!result.isEmpty())
//						System.out.println(result.take());
//			} catch (InterruptedException e) {}
//		}).start();
//
//		// demo of a slow stream generation
//		Random r=new Random();
//		for(int i=0;i<500;i++){
//			s.push(new Point(-100+r.nextInt(201),-100+r.nextInt(201)));
//			Thread.sleep(50);
//		}
//		// stopping the stream(s)
//		s.endOfStream();
//
//		// stopping the printing thread
//		stop[0]=true;
//
//		// result: as new points are generated, only points with x>=0 & y<=0 are printed
//	}
//}
