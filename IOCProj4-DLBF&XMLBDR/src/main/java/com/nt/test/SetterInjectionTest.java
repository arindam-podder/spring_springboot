package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		
/*		//hold spring beans configuration  file
		FileSystemResource res = new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		
		//create IOC container (BeanFactory container)
		BeanFactory factory = new XmlBeanFactory(res);			//up-casting
		
		Object obj = factory.getBean("wmg");
		WishMessageGenerator wmg = (WishMessageGenerator) obj;
		
		String wishMessage = wmg.wishMessage("Arindam Podder");
		
		System.out.println("Wish Message is => "+ wishMessage);
*/
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		WishMessageGenerator wmg = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println("wish message -> "+wmg.wishMessage("Arindam"));
	}
	
	

}
