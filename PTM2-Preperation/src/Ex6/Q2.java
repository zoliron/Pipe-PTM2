package Ex6;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

    public interface MyObserver{
        public void update(MyObservable myObservable);
    }

    public class MyObservable{
        List<MyObserver> myObservers = new ArrayList<>();

        public void addObserver(MyObserver myObserver){
            myObservers.add(myObserver);
        }

        public void notifyObservers(){
            myObservers.forEach(myObserver -> myObserver.update(this));
        }

    }

    public class A extends MyObservable {
        int x;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
            notifyObservers();
        }
    }


    // -------------------------------------   tests the API for Q2 ---------------------
    public class B implements MyObserver{
        A a;
        public B(A a) {this.a=a;}
        @Override
        public void update(MyObservable o) {
            System.out.println("B updated with a.x = "+a.getX());
        }
    }
    public void testAPI(){
        A a=new A();
        B b=new B(a);
        a.addObserver(b);
        a.setX(100);
        // this should output:
        // B updated with a.x = 100
    }

}
