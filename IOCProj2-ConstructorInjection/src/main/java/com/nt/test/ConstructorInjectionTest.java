package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		//hold spring beans configuration  file
		FileSystemResource res = new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		
		//create IOC container (BeanFactory container)
		BeanFactory factory = new XmlBeanFactory(res);			//up-casting
		
		Object obj = factory.getBean("wmg");
		WishMessageGenerator wmg = (WishMessageGenerator) obj;
		
		String wishMessage = wmg.wishMessage("Arindam Podder");
		
		System.out.println("Wish Message is => "+ wishMessage);

	}

}
