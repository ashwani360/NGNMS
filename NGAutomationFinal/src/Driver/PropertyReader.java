package Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public String readproperty(String key) throws IOException
	{ String St=null;
	
	Properties pr= new Properties();
	InputStream file= new FileInputStream("src\\Config\\config.properties");
	pr.load(file);
	St=pr.getProperty(key);
	return St;
		
	}
	

}
