package io.nishandi.javapractice.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	final int sum=10;
   public static CyclicBarrier barrier=new CyclicBarrier(2,new Runnable() {
		
		@Override
		public void run() {
			
			System.out.println("now barrier breaks,final sum");
			
		}
	});
    public static void main(String[] args) {
    	
    }
}




class CyclicBarrierWait1 implements Callable<Integer>{
	public Integer call() {
		System.out.println("current thead:"+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
			CyclicBarrierDemo.barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 5;
		
	}
}






