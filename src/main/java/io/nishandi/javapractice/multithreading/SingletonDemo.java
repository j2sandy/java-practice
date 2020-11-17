package io.nishandi.javapractice.multithreading;

public class SingletonDemo {
	
	public static void main(String[] args) {
		Singleton instance1=Singleton.getInstance();
		Singleton instance2=Singleton.getInstance();
		System.out.println(instance1==instance2);
		EnumSingleton instance=EnumSingleton.INSTANCE;
	}

}

class Singleton{
	
	private static Singleton singleton_instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(singleton_instance==null)
			{
			   singleton_instance=new Singleton();
			   return singleton_instance;
			}
		else
			return singleton_instance;
	}
}

class ThreadSafeSingleton{
private static ThreadSafeSingleton singleton_instance;
	
	private ThreadSafeSingleton() {
		
	}
	
	public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
	    if(singleton_instance == null){
	        synchronized (ThreadSafeSingleton.class) {
	            if(singleton_instance == null){
	            	singleton_instance = new ThreadSafeSingleton();
	            }
	        }
	    }
	    return singleton_instance;
	}

	
	
}

class EagerInitilaizedSingleton{
	
	private static EagerInitilaizedSingleton singleton_instance=new EagerInitilaizedSingleton();
	private EagerInitilaizedSingleton() {
		
	}
	
	public static EagerInitilaizedSingleton getInstance() {
		return singleton_instance;
	}
	
}

enum EnumSingleton{
	INSTANCE;
}
