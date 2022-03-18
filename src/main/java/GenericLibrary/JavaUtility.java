package GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This Method will return A random number.
	 * @return
	 */
    public int getRandomNumber() {
	Random ran=new Random();
	int random = ran.nextInt(1000);
	return random;
}
/**
 * This method will return date
 * @return
 */
public String getSystemDate() {
	Date d=new Date();
	String d1 = d.toString();
	String[] date = d1.split(" ");
	String month = date[1];
	String day = date[2];
	String time=date[3].replace(":", "-");
	String year = date[5];
	String dateFormat = day+"-"+month+"-"+year+"-"+time;
	
	return dateFormat;
}
}
