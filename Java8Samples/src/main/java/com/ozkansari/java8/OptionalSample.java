package com.ozkansari.java8;

import java.util.Optional;

/**
 * Optional allows you to handle all the possible error conditions without an
 * Exception or nested if/else logic
 * 
 * https://www.javacodegeeks.com/2015/02/java-8-optional-is-not-just-for-replacing-a-null-value.html/
 * https://examples.javacodegeeks.com/core-java/util/optional/java-8-optional-example/
 *
 */
public class OptionalSample {

	private static final boolean NULL_VALUE = false;

	public static void main(String[] args) {

		System.out.println("normalWay: ");
		normalway();

		System.out.println("java8Way 1: ");
		java8way1();
		
		System.out.println("java8Way 2: ");
		java8way2();
		
		System.out.println("java8Way 3: ");
		java8way3();
	}

	private static void normalway() {
		String text = somethingNull(NULL_VALUE);

		if (text != null) {
			System.out.println(text);
		} else {
			System.out.println("NULL");
		}

	}

	private static void java8way1() {
		Optional<String> text = somethingOptional(NULL_VALUE);

		if (text != null && text.isPresent()) {
			System.out.println(text.get());
		} else {
			System.out.println("NULL");
		}
	}
	
	private static void java8way2() {
		Optional<String> text = somethingOptional(NULL_VALUE);
		Optional.of(text.orElse("NULL")).ifPresent( System.out::println );
		// text.orElseThrow( IllegalStateException::new );
	}
	
	private static void java8way3() {
		Optional<String> text = somethingOptional(NULL_VALUE);
		text
			.filter(x -> "dummy text".equals(x) ) // could be null
			.ifPresent(x -> System.out.println( x ) );
	}

	/**
	 * Null returning helper method
	 * 
	 * @return null
	 */
	private static String somethingNull(boolean empty) {
		if (empty) {
			return null;
		} else {
			return "dummy text";
		}

	}

	/**
	 * Optional returning helper method
	 * 
	 * @return null
	 */
	private static Optional<String> somethingOptional(boolean empty) {
		if (empty) {
			return Optional.empty();
		} else {
			return Optional.of("dummy text");
		}

	}

}
