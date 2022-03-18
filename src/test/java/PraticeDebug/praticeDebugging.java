package PraticeDebug;

import org.testng.annotations.Test;

public class praticeDebugging {
@Test
public void debugIt() {
	praticeDebugging  d=new praticeDebugging ();
	int x=d.div(1, 1);
	System.out.println(x);
}
	public int div(int a, int b) {
		int c=a/b;
		return c;
	}


}
