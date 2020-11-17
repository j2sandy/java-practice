package io.nishandi.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByValues {
	public static void main(String[] args) {
		
		Map<String,Integer> hm=new HashMap<String,Integer>();
		
		hm.put("nitin", 10000);
		hm.put("abc", 3033);
		hm.put("ddd", 12333);
		hm.put("fdfggg", 12243435);
		
		//hm=SortMapByValues.sortMapUsingValues(hm);
		hm.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
	}
	
	public static Map<String,Integer> sortMapUsingValues(Map<String,Integer> hm) {
		
		List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
				return (arg0.getValue()).compareTo(arg1.getValue());
			}
		});
		
		hm.clear();
		
		for(Map.Entry<String, Integer> entry:list) {
			hm.put(entry.getKey(), entry.getValue());
		}
		
		
		
		return hm;
		
	}

}
