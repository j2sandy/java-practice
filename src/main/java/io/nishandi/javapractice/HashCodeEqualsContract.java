package io.nishandi.javapractice;

import java.util.HashMap;
import java.util.Map;

public class HashCodeEqualsContract {
	
	public static void main(String[] args) {
		
		HashMap<Employee,Integer> hmap=new HashMap<>();
		Employee emp1=new Employee("nitin", 787054, "abc@gmail.com");
		Employee emp2=new Employee("nitin", 787054, "abc@gmail.com");
		Employee emp3=new Employee("shandilya", 787054, "abc@gmail.com");
		
		hmap.put(emp1, 10000);
		hmap.put(emp2, 20000);
		hmap.put(emp3, 30000);
		
		for(Map.Entry<Employee, Integer> hm:hmap.entrySet()) {
			System.out.println("Key:"+hm.getKey()+"Value:"+hm.getValue());
		}
		
		emp1=new Employee("new nitin",66777,"afc#fdff");
		
		System.out.println(hmap.get(emp1));
		for(Map.Entry<Employee, Integer> hm:hmap.entrySet()) {
			System.out.println("Key:"+hm.getKey()+"Value:"+hm.getValue());
		}
	}

	
}

class Employee{
	String name;
	int number;
	String email;
	public Employee(String name, int number, String email) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
	
	
	
}
