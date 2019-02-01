package Mock1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mock1Q2 {

    public class DataHolder {
        public String currentData;

        public void setData(String newData) {
            this.currentData = newData;
        }
    }

    public interface DataHandler {
        void dataArrived(String payload);
    }

    public interface DataManager {
        void subscribeToDataEvent(DataHandler handler);
        void unsubscribeFromDataEvent(DataHandler handler);
    }

    public void start(List<DataHandler> handlers) {
        DataHolder holder = new DataHolder();
        DataManager mgr = null;
        ExecutorService pool = Executors.newSingleThreadExecutor();

        pool.submit( () -> {
            try {
                while (true) {
                    Thread.sleep(new Random().nextInt(3000));
                    holder.setData("random:" + new Random().nextLong());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void execute() {
        List<DataHandler> handlers = new ArrayList<>();
        start(handlers);
    }
}
