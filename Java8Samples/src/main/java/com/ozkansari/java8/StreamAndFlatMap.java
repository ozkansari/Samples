package com.ozkansari.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.mkyong.com/java8/java-8-flatmap-example/
 * 
 */
public class StreamAndFlatMap {

	/*--
	 * How flatMap() works : 
	 *       { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6} 
	 * 
	 * Stream<String[]>		-> flatMap ->	Stream<String>
	 * Stream<Set<String>>	-> flatMap ->	Stream<String>
	 * Stream<List<String>>	-> flatMap ->	Stream<String>
	 * Stream<List<Object>>	-> flatMap ->	Stream<Object>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("array2dim loops: ");
		System.out.println("-----------------------------");
		
		String[][] array2dim = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		
		System.out.println("normalWay: ");
		normalWay(array2dim);
		System.out.println();
				
		System.out.println("java8Way 1: ");
		java8Array2Dim(array2dim);
		System.out.println();
	}

	private static void normalWay(String[][] array2dim) {
		
		info(" Convert 2dim array to 1 dim array : ");
		List<String[]> array1dim = Arrays.asList(array2dim);
		for (String[] a : array1dim) {
			System.out.print(a);
		}
		System.out.println();
		
		info(" Convert 1dim array to values : ");
		for (String[] a : array1dim) {
			for (String s : Arrays.asList(a)) {
				System.out.print(s);
			}
		}
		System.out.println();
	}

	/**
	 * @param array2dim
	 */
	private static void java8Array2Dim(String[][] array2dim) {
		
		info(" Convert 2dim array to 1 dim array : ");
		info(" > Arrays.stream(array2dim).forEach(System.out::print) : ");
		Stream<String[]> array2dimStream = Arrays.stream(array2dim);
		array2dimStream.forEach(System.out::print);
		System.out.println();
		
		info(" Convert 1dim array to values : ");
		info(" > array2dimStream.flatMap(x -> Arrays.stream(x).forEach(System.out::print)) : ");
		Stream<String> array1dimStringStream = Arrays.stream(array2dim).flatMap(x -> Arrays.stream(x));
		array1dimStringStream.forEach(System.out::print);
		System.out.println();
		
		/*
		Arrays.stream(array2dim)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()))
                .forEach(System.out::print);
         */
	}

	/**
	 * 
	 */
	private static void info(String msg) {
		System.out.println(msg);
		System.out.print("   ");
	}

}
