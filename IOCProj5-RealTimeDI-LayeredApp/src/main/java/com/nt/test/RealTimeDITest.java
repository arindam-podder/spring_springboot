package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.EmployeeController;
import com.nt.dto.EmployeeDTO;

public class RealTimeDITest {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		EmployeeController controller = factory.getBean("controller", EmployeeController.class);
		
		try (Scanner sc = new Scanner(System.in)
				){
			//read the data 
			System.out.println("enter employee name : ");
			String name = sc.nextLine();
			System.out.println("enter employee desg : ");
			String desg = sc.nextLine();
			System.out.println("enter basic salary :");
			float basicSalary = sc.nextFloat();
			
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEname(name); dto.setDesg(desg); dto.setBasicSalary(basicSalary);
			
			String result = controller.processEmployee(dto);
			
			System.out.println(result);
		}
		catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}//main end
}//class end
