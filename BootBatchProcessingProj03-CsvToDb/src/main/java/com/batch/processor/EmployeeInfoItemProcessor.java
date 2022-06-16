package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batch.model.Employee;

public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getEmpSalary() >= 35000.00f) {
			Float grossSalary = item.getEmpSalary() + item.getEmpSalary() * 0.4f;
			Float netSalary = grossSalary - grossSalary * 0.15f;
			item.setGrossSalary(grossSalary);
			item.setNetSalary(netSalary);
			return item;
		}
		return null;	//other employee will be filtered
	}

}












