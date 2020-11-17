package io.nishandi.javapractice.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueImpl {
	
	private Queue<Integer> queue;
	private int limit;
	
	public BlockingQueueImpl(int limit) {
		this.limit=limit;
		this.queue=new LinkedList<Integer>();
	}
	
	public synchronized void enqueue(int key) throws InterruptedException{
		while(this.queue.size()==limit)
			wait();
		
		this.queue.add(key);
		notifyAll();
	}
	
	public synchronized void dequeue() throws InterruptedException{
		while(this.queue.size()==0)
			wait();
		
		System.out.println(this.queue.poll());
		
	}
	
}
