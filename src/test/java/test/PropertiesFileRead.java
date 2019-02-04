package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileRead {
	
	public String PropertiesRead(String properties) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\vikas\\Desktop\\Java\\TestNGInterviewPractice\\src\\test\\resources\\propertiesFiles\\data.properties");		
		Properties prop=new Properties();
		prop.load(fis);
		String str=prop.getProperty(properties);
		return str;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertiesFileRead pr=new PropertiesFileRead();
		System.out.println(pr.PropertiesRead("Browser"));
		System.out.println(pr.PropertiesRead("Url"));
		
		
		

	}

}
