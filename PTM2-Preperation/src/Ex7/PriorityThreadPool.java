package Ex7;


import java.util.concurrent.*;

public class PriorityThreadPool extends ThreadPoolExecutor {

	private class Helper<V> extends FutureTask<V> implements Comparable<Helper<V>> {

	    private int priority;

        public Helper(Callable<V> callable, int priority) {
            super(callable);
            this.priority = priority;
        }

        public Helper(Runnable runnable, V result, int priority) {
            super(runnable, result);
            this.priority = priority;
        }

        @Override
        public int compareTo(Helper<V> o) {
            return this.priority - o.priority;
        }
    }

	public PriorityThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, PriorityBlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public <V> void execute(Runnable r,V result,int priority){
	    RunnableFuture<V> runnableFuture = new Helper<V>(r, result, priority);
	    super.execute(runnableFuture);
	}

	public <V> Future<V> submit(Callable<V> c, int priority){
	    RunnableFuture<V> runnableFuture = new Helper<V>(c, priority);
	    super.execute(runnableFuture);
	    return runnableFuture;
	}

}
