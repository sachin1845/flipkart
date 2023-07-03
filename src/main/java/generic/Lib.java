package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lib {
	
	public String getPropertyData(String property) throws IOException {
		
		FileInputStream fs=new FileInputStream("./src/main/resources/testdata.property");
	    Properties p=new Properties();
	    p.load(fs);
	    
	    String data=p.getProperty(property);
	    return data;
	    
	}

}
