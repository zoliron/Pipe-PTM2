package Ex5;

import java.lang.reflect.Field;

public class Q2 {
	// fill the data members for the following classes according to question 2.
	class Engine{}
	class Propeller{}
	class Throttle{}
	class RPMgauge{}
	class Stick{}
	class Pedals{}
	class Wing{
	    public Aileron[] ailerons;
    }
	class Aileron{}
	class Tail{
	    public Elevator[] elevators;
	    public Rudder rudder;
    }
	class Elevator{}
	class Rudder{}
	class Cockpit{
		public Throttle throttle;
		public Stick stick;
		public RPMgauge rpMgauge;
		public Pedals pedals;
	}
	class Aircraft{
	    public Propeller propeller;
	    public Engine engine;
	    public Cockpit cockpit;
	    public Wing[] wings;
	    public Tail tail;
    }
	
	// ---------------------------------------------------------from here do not change anything.-------------------
	public static void recursuvePrint(String tabs,Field f){
		if(!(tabs+"class test.Q2").equals(tabs+f.getType()))
				System.out.println(tabs+f.getType());
		
		for(Field fs : f.getType().getDeclaredFields()){
			recursuvePrint(tabs+"\t",fs);
		}		
	}
	
	public static class Test{
		Aircraft a;
	}
	
	public static void mainAPI() {
		// just prints the classes and their data members
		// arrays have "[L" prefix before their names
		try {
			recursuvePrint("", Test.class.getDeclaredField("a"));
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
