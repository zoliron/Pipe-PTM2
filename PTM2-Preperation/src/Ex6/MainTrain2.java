package Ex6;

import Ex6.Q2.A;
import Ex6.Q2.MyObservable;
import Ex6.Q2.MyObserver;

public class MainTrain2 {

	static boolean[] activated={false};
	static int i=0;

	public static class C implements MyObserver{
		A a;
		public C(A a) {this.a=a; a.addObserver(this);}

		@Override
		public void update(MyObservable o) {
			activated[i]=true;
			i++;
			if(o!=a)
				System.out.println("problem with update() parameter (-5)");
			if(a.getX()!=50)
				System.out.println("problem with the updated value (-5)");
		}
	}

	public static void main(String[] args) {
		Q2 q2=new Q2();
		// test API
		 q2.testAPI();
		A a=q2.new A();
		C c0=new C(a);
		a.setX(50);
		if(!activated[0] )
			System.out.println("the implementation of the UML does not work (-20)");
		System.out.println("done");
	}

}
