package newemp.work.question1;

import newemp.work.exp.MyException;

public class HelloWorld {

	String msgHead = "";

	public HelloWorld(String world) {
		msgHead = world;
	}

	public void printHello(String msg) throws MyException {
		System.out.println(msgHead + "\t" + msg);
		if(1>2)
		{
			throw new MyException("LICH's FIRST ERROR");
		}
		String[] strs=new String[100];
		for(int i=0;i<50;i++)
		{
			strs[i]="a";
		}
		
		
	}

}
