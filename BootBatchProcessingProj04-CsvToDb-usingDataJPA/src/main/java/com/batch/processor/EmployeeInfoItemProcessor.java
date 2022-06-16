package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batch.model.Employee;

public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee> {

	/**
	 *this will check employee name contains A/a or not.  
	 */
	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getEmpName().contains("a") || item.getEmpName().contains("A")) {
			return item;
		}
		return null;	//other employee will be filtered
	}
	
/*	private boolean nameContainsA(String name) {
		return (name.contains("a") || name.contains("A"));
	}	*/

	
/*	public static void main(String[] args) {
		String  name = "Ty";
		
		System.out.println( name.contains("a") || name.contains("A")  );
	
	}	*/
}












