package newemp.work.question1;

import newemp.work.exp.MyException;

public class HelloWorld {
	public static void main(String[] args) {
		Suansu suansu= new Suansu(3,2);
		System.out.println(suansu.subAB());
		System.out.println(suansu.addAB());
		System.out.println(suansu.multiAB());
		System.out.println(suansu.divAB());
	}

//	String msgHead = "";
//
//	public HelloWorld(String world) {
//		msgHead = world;
//	}
//
//	public void printHello(String msg) throws MyException {
//		System.out.println(msgHead + "\t" + msg);
//		if(1>2)
//		{
//			throw new MyException("LICH's FIRST ERROR");
//		}
//		String[] strs=new String[100];
//		for(int i=0;i<50;i++)
//		{
//			strs[i]="a";
//		}
//
//
//	}

}
