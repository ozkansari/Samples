package com.ozkansari.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * In Java 8, you can loop a Map with forEach and lambda expression.
 * 
 */
public class LoopAMapWithForEachLambda {

	public static void main(String [] args) {
		
		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("ANTELOPE", 10);
		items.put("BEAR", 20);
		items.put("CAT", 30);
		items.put("DOG", 40);
		items.put("ELEPHANT", 50);
		items.put("FLAMINGO", 60);
		
		System.out.println("normalWay: ");
		String normalWay = normalWay(items);
		System.out.println(normalWay);
		
		System.out.println("java8Way 1: ");
		String java8Way1 = java8way1(items);
		System.out.println(java8Way1);
		
		System.out.println("java8Way 2: ");
		String java8Way2 = java8way2(items);
		System.out.println(java8Way2);
	}
	
	private static String normalWay(Map<String, Integer> items){
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			sb.append("Item : " + entry.getKey() + " Count : " + entry.getValue() + ". ");
		}
		
		return sb.toString();
	}

	private static String java8way1(Map<String, Integer> items){
		StringBuilder sb = new StringBuilder();

		items.forEach((k,v)->sb.append("Item : " + k + " Count : " + v + ". "));

		return sb.toString();
	}
	
	private static String java8way2(Map<String, Integer> items){
		StringBuilder sb = new StringBuilder();

		items.forEach((k,v)->{
			sb.append("Item : " + k + " Count : " + v + ". ");
			if("CAT".equals(k)){
				System.out.println("There is a CAT here");
			}
		});
		
		return sb.toString();
	}
}
