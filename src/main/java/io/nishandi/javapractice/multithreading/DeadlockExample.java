package io.nishandi.javapractice.multithreading;

public class DeadlockExample {
	
	Shared s1,s2;
	public static void main(String[] args) {
		Shared s1=new Shared ();
		Shared s2=new Shared ();
		Thread1 t1=new Thread1(s1,s2);
		Thread1 t2=new Thread1(s1,s2);
		t1.start();
		t2.start();
		
	}

}

class Shared{
	
	synchronized public void test1(Shared s2) {
		System.out.println("test 1 begin");
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		s2.test2(this);
		System.out.println("test 1 ends");
	}
	
    synchronized public void test2(Shared s1) {
    	System.out.println("test 2 begin");
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		s1.test1(this);
		System.out.println("test 2 ends");
	}
	
}

class Thread1 extends Thread{
	private Shared s1,s2;
	
	public Thread1(Shared s1,Shared s2) {
		this.s1=s1;
		this.s2=s2;
	}
	
	@Override
	public void run() {
		s1.test1(s2);
	}
	
}

class Thread2 extends Thread{
	private Shared s1,s2;
	
	public Thread2(Shared s1,Shared s2) {
		this.s1=s1;
		this.s2=s2;
	}
	
	
	@Override
    public void run() 
    { 
        
        s2.test2(s1); 
    } 
}
