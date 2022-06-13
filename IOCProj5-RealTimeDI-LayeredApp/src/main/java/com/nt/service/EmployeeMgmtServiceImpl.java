package com.nt.service;

import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	private IEmployeeDAO empDAO;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}



	@Override
	public String registerEmployee(EmployeeDTO empDTO) throws Exception {
		//write  b.logic to calculate grossSalary and NetSalary
		float grossSalary = empDTO.getBasicSalary() + empDTO.getBasicSalary()*0.4f;		// +40% on BasicSalary
		float netSalary = grossSalary - empDTO.getBasicSalary()*0.2f;		// - 20% on grossSalary
		//add gs and ns to the empDTO
		empDTO.setGrossSalary(grossSalary);
		empDTO.setNetSalary(netSalary);
		
		//call DAO class method
		int count = empDAO.insertEmployee(empDTO);
		
		return count==1 ? "employee registered with net sal -> "+netSalary : "employee registewr fail, try again.";
	} 

}//class end
