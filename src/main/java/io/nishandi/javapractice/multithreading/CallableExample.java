package io.nishandi.javapractice.multithreading;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;


/*Callable

Callable interface has the call() method. In this method, we have to implement 
the logic of a task. The Callable interface is a parameterized interface, meaning we have to 
indicate the type of data the call() method will return.
		
Future

Future interface has methods to obtain the result generated by a Callable object and to manage its state.
*/
public class CallableExample {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        
        ArrayList<Future<Integer>> resultList = new ArrayList<>();
         
        Random random = new Random();
         
        for (int i=0; i<4; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
         
        for(Future<Integer> future : resultList)
        {
              try
              {
                  System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
              } 
              catch (InterruptedException | ExecutionException e) 
              {
                  e.printStackTrace();
              }
          }
          
          executor.shutdown();
    }

	}


class FactorialCalculator implements Callable<Integer>{
   
	private Integer number;
	
	public FactorialCalculator(Integer number) {
		
		this.number=number;
	}
	
	
	
	@Override
	public Integer call() throws Exception {
		System.out.println("calculating for:"+number);
		int result=1;
		if(number==0 || number==1) {
			result=1;
		}
		else {
			for(int i=2;i<=number;i++) {
				result=result*i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		
		System.out.println("Result for number - " + number + " -> " + result+"calculated by thread:"+Thread.currentThread().getName());
		return result;
	}
	
}
