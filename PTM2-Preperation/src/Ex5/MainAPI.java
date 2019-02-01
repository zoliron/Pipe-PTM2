package Ex5;

public class MainAPI {
	
	
	public static void main(String[] args) throws Exception{
		Q1.mainAPI();
		Q2.mainAPI();
		Q3.mainAPI();
		if(Q4.a() || Q4.b() || Q4.c() || Q4.d() || !Q4.a() || !Q4.b() || !Q4.c() || !Q4.d())
			System.out.println("you answered all Q4's questions");
		else
			System.out.println("you did NOT answer all Q4's questions");
	}
	
}
