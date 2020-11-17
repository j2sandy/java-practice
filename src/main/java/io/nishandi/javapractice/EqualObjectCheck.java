package io.nishandi.javapractice;

public class EqualObjectCheck {
	public static void main(String[] args) {
		EqualCheck eq1=new EqualCheck(10);
		EqualCheck eq2=new EqualCheck(20);
		EqualCheck eq3=eq1;
		EqualCheck eq4=new EqualCheck(10);
		
		System.out.println(eq1==eq2);
		System.out.println(eq1==eq3);
		System.out.println(eq1.equals(eq2));
		System.out.println(eq1.equals(eq3));
		System.out.println(eq1.equals(eq4));
		
	}

}

class EqualCheck{
	
	int myValue;
	public EqualCheck(int val) {
		myValue=val;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EqualCheck) {
			return ((EqualCheck) obj).myValue==myValue;
		}
		else
			return false;
					
	}
	
}
