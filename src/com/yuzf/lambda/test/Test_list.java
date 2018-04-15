package com.yuzf.lambda.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Test_list {

	@Test  //输出字符串长度大于2的字符串
	public void test01() {
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I","am","ppg","!!!"));
		list.forEach(str -> {
			if(str.length() > 2)
				System.out.println(str);
		});
		
	}
	
	@Test //移除字符串长度大于2的
	public void test02(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I","am","ppg","!!!"));
		
		list.removeIf(str ->
			str.length()>2
				);
		System.out.println(list);
	}
	
	@Test //字符串长度大于2的,转化为大写
	public void test03() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I","am","ppg","!!!"));
		
		list.replaceAll(str ->{
			if(str.length()>2)
				return str.toUpperCase();
			return str;
		});
		
		System.out.println(list);
	}
	
	@Test //按字符串长度排序
	public void test04() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I","am","ppg","!!!","q"));
		
		list.sort((str1,str2)->
			str1.length()-str2.length()
				);
		
		System.out.println(list);
	}
	
}
