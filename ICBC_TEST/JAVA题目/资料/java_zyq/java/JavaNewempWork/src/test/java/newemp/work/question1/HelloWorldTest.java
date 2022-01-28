package newemp.work.question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import newemp.work.exp.MyException;

public class HelloWorldTest {
	HelloWorld hw;
	@Before
	public void setUp() throws Exception {
		hw=new HelloWorld("HELLO");
	}

	@Test
	public void testPrintHello() throws MyException {
		System.out.println("IN JUNIT");
		hw.printHello("WORLD");
	}

}
