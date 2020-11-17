package io.nishandi.javapractice.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(3);
		
		ThreadImpl t1=new ThreadImpl(latch, "t1");
		ThreadImpl t2=new ThreadImpl(latch, "t2");
		ThreadImpl t3=new ThreadImpl(latch, "t3");
		t1.start();
		t2.start();
		t3.start();
		latch.await();
		
		System.out.println("final thread"+Thread.currentThread().getName());
		

	}

}


class ThreadImpl extends Thread{
	
	private CountDownLatch latch;
	
	public ThreadImpl(CountDownLatch latch,String name) {
		super(name);
		this.latch=latch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			latch.countDown();
			System.out.println("Thread finished :"+Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
