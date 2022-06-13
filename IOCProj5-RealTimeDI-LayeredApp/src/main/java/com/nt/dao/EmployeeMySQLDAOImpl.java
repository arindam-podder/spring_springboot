package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.dto.EmployeeDTO;

public class EmployeeMySQLDAOImpl implements IEmployeeDAO {

	private static final String INSERT_QUERY = "INSERT INTO REALTIMEDI_SPRING_EMPLOYEE(ENAME,DESG,BASICSALARY,GROSSSALARY,NETSALARY) "
																								+ "VALUES(?,?,?,?,?)";
	//HAS-A property
	//@Autowired
	private DataSource dataSource;
	
	
	public EmployeeMySQLDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	@Override
	public int insertEmployee(EmployeeDTO empDTO) throws Exception {
		
		int result = 0;
		try(Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
				){
			//set query param
			ps.setString(1, empDTO.getEname());
			ps.setString(2, empDTO.getDesg());
			ps.setFloat(3, empDTO.getBasicSalary());
			ps.setFloat(4, empDTO.getGrossSalary());
			ps.setFloat(5, empDTO.getNetSalary());
			
			result = ps.executeUpdate();
			
			
		}catch (SQLException se) {
			se.printStackTrace();
			throw se;	//exception rethrowing
		}catch(Exception e) {
			e.printStackTrace();
			throw e;	//exception rethrowing
		}
		
		return result;
		
	}//inserEmp.. end
	
}//class end
