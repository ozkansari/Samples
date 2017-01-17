package com.ozkansari.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LoopAListWithForEachLambda {
	public static void main(String[] args) {

		List<String> items = new ArrayList<>();
		items.add("ANTELOPE");
		items.add("BEAR");
		items.add("CAT");
		items.add("DOG");
		items.add("ELEPHANT");
		items.add("FLAMINGO");

		System.out.println("normalWay: ");
		String normalWay = normalWay(items);
		System.out.println(normalWay);

		System.out.println("java8Way 1: ");
		String java8Way1 = java8way1(items);
		System.out.println(java8Way1);

		System.out.println("java8Way 2: ");
		String java8Way2 = java8way2(items);
		System.out.println(java8Way2);
		
		System.out.println("java8Way 3: ");
		String java8Way3 = java8way3(items);
		System.out.println(java8Way3);
		
		System.out.println("java8Way 4: ");
		String java8Way4 = java8way4(items);
		System.out.println(java8Way4);
	}

	private static String normalWay(List<String> items) {
		StringBuilder sb = new StringBuilder();
		for(String item : items){
			sb.append("Item : " + item + ". ");
		}
		return sb.toString();
	}

	private static String java8way1(List<String> items) {
		StringBuilder sb = new StringBuilder();
		items.forEach(item -> sb.append("Item : " + item + ". "));
		return sb.toString();
	}

	private static String java8way2(List<String> items) {
		StringBuilder sb = new StringBuilder();

		items.forEach(item -> {
			sb.append("Item : " + item + ". ");
			if ("CAT".equals(item)) {
				System.out.println("There is a CAT here");
			}
		});

		return sb.toString();
	}
	
	/**
	 * Method reference
	 * 
	 * @param items
	 * @return
	 */
	private static String java8way3(List<String> items) {
		StringBuilder sb = new StringBuilder();

		// items.forEach(System.out::println);

		Consumer<String> sbConsumer = (String s) -> sb.append("Item : " + s + ". ");
		items.forEach(sbConsumer);
		
		return sb.toString();
	}
	
	/**
	 * Stream and filter
	 * 
	 * @param items
	 * @return
	 */
	private static String java8way4(List<String> items) {
		StringBuilder sb = new StringBuilder();

		Consumer<String> sbConsumer = (String s) -> sb.append("Item : " + s + ". ");
		items.stream().forEach(sbConsumer);
		
		Consumer<String> catAlertConsumer = (String s) -> System.out.println("There is a CAT here");
		items.stream().filter(s -> s.contains("CAT")).forEach(catAlertConsumer);
		
		return sb.toString();
	}
}
