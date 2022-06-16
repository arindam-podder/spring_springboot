package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.service.IPersonLobService;

@Component
public class LobValuesRunnerTest implements CommandLineRunner{

	@Autowired
	private IPersonLobService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		//register or save operation
/*		
		// take data from user
		Scanner sc = new Scanner(System.in);
		System.out.print("enter person name : ");
		String name = sc.nextLine();
		
		System.out.println();
		
		System.out.print("person is married?(true or false):");
		boolean isMarried = sc.nextBoolean(); sc.nextLine();
		
		System.out.println();
		
		System.out.print("person image path :");
		String imgPath = sc.nextLine();
	
		System.out.println();
		
		System.out.print("person audio file path :");
		String audioPath = sc.nextLine();
		
		System.out.println();
		
		System.out.print("person resume file path : ");
		String resumePath = sc.nextLine();
		
		
		Person p1 =  new Person();
		p1.setName(name);
		p1.setMarried(isMarried);
		InputStream is1 = new FileInputStream(imgPath);
		byte[] imgArr = new byte[is1.available()];
		is1.read(imgArr);
		//imgArr = is.readAllBytes();
		p1.setImage(imgArr);
		
		InputStream is2 = new FileInputStream(audioPath);
		byte[] audioArr = new byte[is2.available()];
		audioArr = is2.readAllBytes();		
		p1.setPersonAudio(audioArr);
		
		Reader reader = new FileReader(resumePath);
		File f = new File(resumePath);
		char[] resumeArr = new char[(int) f.length()];
		reader.read(resumeArr);
		p1.setResume(resumeArr);
		
		System.out.println(service.registerPerson(p1));
*/
		
		//retrieve operation
		Person person = service.getPersonById(2);
		if(person != null ) {
			System.out.println(person.getId()+" : "+person.getName());
			
			byte[] imgContent = person.getImage();
			OutputStream os = new FileOutputStream("retrieve_img.jpeg");
			os.write(imgContent);
			os.close();
			System.out.println("img retrieved.");
			
			char[] resumeContent = person.getResume();
			Writer w = new FileWriter("retrieve_resume.txt");
			w.write(resumeContent);
			w.close();
			System.out.println("resume retrieved.");
			
		}
		else {
			System.out.println("person with that id not found.");
		}
		
		
	}
}















