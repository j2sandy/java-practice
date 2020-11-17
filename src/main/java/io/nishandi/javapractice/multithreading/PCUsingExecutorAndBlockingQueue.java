package io.nishandi.javapractice.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class PCUsingExecutorAndBlockingQueue {
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		BlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>(2);
		
		Runnable producerTask=new Runnable() {
			
			@Override
			public void run() {
				try {
					int value=0;
					while(true) {
						queue.add(value);
						System.out.println("Produced value"+value);
						value++;
						
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		Runnable consumerTask=new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						System.out.println("consumed value"+queue.poll());
						Thread.sleep(1000);
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		executor.execute(producerTask);
		executor.execute(consumerTask);
		
		executor.shutdown();
		
		
	}

}
