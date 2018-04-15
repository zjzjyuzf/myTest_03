package com.yuzf.lambda.test;

import java.util.HashMap;

import org.junit.Test;

public class Test_map {

	@Test //foreach()
	public void test01() {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		
		map.forEach((k,v)->
			System.out.println(k+"="+v)
				);
	}
	
	//getOrDefault 拿到或者拿不到返回默认值
	@Test
	public void test02() {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		
		System.out.println(map.getOrDefault(5, "five"));
	}
	
	//putIfAbsent(k,v) 只有在不存在key值的映射或者映射值为null时才赋值
	
	//remove(k,v) key值正好映射value时 才删除
	
	//replace(k,v)  replace(k,oldV,newV)
	
	//replaceAll
	@Test
	public void test03() {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		
		map.replaceAll((k,v)->
			v.toUpperCase()
				);
		
		System.out.println(map);
		
	}
	
}
