package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(System.getProperty("user.dir")+"	\\src\\test\\resources\\configfiles\\config.properties");

		Properties p = new Properties();
		
		p.load(fr);
		
	}

}
