package io.nishandi.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JavaEight {
   public static void main(String[] args) {
	   PredicateExample predicateExample=new PredicateExample();
	   System.out.println(predicateExample.test(10));
	   ConsumerExample consumerExample=new ConsumerExample();
	   consumerExample.accept(20);
	   Integer new_arr[]= new Integer[]{1,2,3,4,5,6,7,8};
	   String arr[]=new String[] {"aman","gupta","asha","people"};
	   
	   List<Integer> list=Arrays.asList(new_arr);
	   List<String> list_str=Arrays.asList(arr);
	   list.parallelStream().filter(predicateExample).forEach(System.out::println);
	   list_str.stream().filter(s->s.startsWith("a")).map(s->s.toUpperCase()).forEach(System.out::println);
	   list_str.stream().sorted().forEach(System.out::println);
	   System.out.println(list.stream().reduce(0, (a,b)->a+b));
	
}
}

class PredicateExample implements Predicate<Integer>{

	
	public boolean test(Integer arg0) {
		
		return arg0>5;
	}
	
}

class ConsumerExample implements Consumer<Integer>{

	
	public void accept(Integer arg0) {
		System.out.println(arg0);
		
	}
	
}
