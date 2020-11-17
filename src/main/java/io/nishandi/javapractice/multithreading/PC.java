package io.nishandi.javapractice.multithreading;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {

	Queue<Integer> queue = new LinkedList<Integer>();
	int capacity=5;
	
	public void produce() throws InterruptedException{
		int value=0;
		while(true) {
			synchronized (this) {
				while(queue.size()==5)
					wait();
				
				System.out.println("Producer produced:"+value);
				
				queue.add(value++);
				notify();
				
				Thread.sleep(1000);
				
			}
		}
	}
	
	public void consume() throws InterruptedException{
		while(true) {
			synchronized (this) {
				while(queue.size()==0)
					wait();
				
				System.out.println("Consumer consumed:"+queue.peek());
				queue.poll();
				notify();
				Thread.sleep(1000);
				
			}
		}
	}
	

}

public class PC{
	
	public static void main(String[] args) throws InterruptedException {
		final ProducerConsumer pc=new ProducerConsumer();
		
		Thread producer=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
		Thread consumer =new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
		
		
	}
}



