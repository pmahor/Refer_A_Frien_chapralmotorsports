package com.immply.readproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
	static FileInputStream in;
	static Properties prop;


	public static Properties Read(){
		try {
			in = new FileInputStream("C:\\Users\\sdevkar\\workspace\\Refer_A_friend(ChaparralMotor)\\Configure.Properties");
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	} 

}










