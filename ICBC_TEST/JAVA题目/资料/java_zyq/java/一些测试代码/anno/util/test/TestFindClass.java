package com.icbc.sh.mq.anno.util.test;

import java.util.List;

import com.icbc.sh.mq.anno.util.ScanClassUtil;

public class TestFindClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String packageName="lich.test.annotation.injar";
		List<Class<?>> mylist = ScanClassUtil.getClasses(packageName);
		for(Class<?> ac:mylist)
		{
			System.out.println(ac.getName());
		}
	}

}
