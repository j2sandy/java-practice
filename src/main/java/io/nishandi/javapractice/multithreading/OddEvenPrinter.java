package io.nishandi.javapractice.multithreading;

  class OddEven implements Runnable {
    private int max;
    private OddEvenPrinter print;
    private boolean isEvenNumber;
    
    
	public OddEven(OddEvenPrinter print,int max, boolean isEvenNumber) {
		super();
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}


	public void run() {
		int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
		
	}


public class OddEvenPrinter {
    private volatile boolean isOdd;
    
    public static void main(String... args) {
    	OddEvenPrinter print = new OddEvenPrinter();
        Thread t1 = new Thread(new OddEven(print, 10, false),"Odd");
        Thread t2 = new Thread(new OddEven(print, 10, true),"Even");
        t1.start();
        t2.start();
    }
    
 
    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }
 
    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}