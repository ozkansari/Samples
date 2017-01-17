package com.ozkansari.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.mkyong.com/java8/java-8-flatmap-example/
 * 
 */
public class StreamAndMapForSetSample {

	public static void main(String[] args) {
		new StreamAndMapForSetSample().test();
	}

	/**
	 * 
	 */
	private void test() {
		System.out.println("Set loops: ");
		System.out.println("-----------------------------");
		
		List<Student> list = createSampleList();
        
		System.out.println("normalWay: ");
		normalWay(list);
		System.out.println();
				
		System.out.println("java8Way: ");
		java8Way(list);
		System.out.println();
	}

	private static void normalWay(List<Student> studentList) {
		
		// Find distinct books
		List<String> collect = new ArrayList<>();
		for (Student student : studentList) {
			for (String book : student.getBook()) {
				if (!collect.contains(book)) {
					collect.add(book);
				}
			}
		}
		
		// Print
		for (String book : collect) {
			System.out.println(book);
		}
	}


	private static void java8Way(List<Student> list) {
		
		// Find distinct books
		List<String> collect =
                list.stream()
                        .map(x -> x.getBook())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

		// Print
        collect.forEach(x -> System.out.println(x));
		
	}

	/* ----------------------------------------------------- */
	/* HELPER METHOD(S) */
	/* ----------------------------------------------------- */
	
	/**
	 * @return
	 */
	private List<Student> createSampleList() {
		Student obj1 = new Student("ozkan");
		obj1.addBooks("Same Book 1", "Same Book 2");
		Student obj2 = new Student("bob");
		obj2.addBooks("Same Book 1", "Same Book 2", "Different Book" );
		List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
		return list;
	}

	/**
	 * Helper method
	 */
	private static void info(String msg) {
		System.out.println(msg);
		System.out.print("   ");
	}
	
	/**
	 * Class sample
	 *
	 */
	public class Student {

		private String name;
	    private Set<String> book;

	    public Student(String name) {
	    	this.name = name;
	    	
	    }
	    
	    public void addBook(String book) {
	        if (this.book == null) {
	            this.book = new HashSet<>();
	        }
	        this.book.add(book);
	    }
	    
	    public void addBooks( String ...booksArray) {
	    	for (String book : booksArray) {
	    		addBook(book);
			}
	    }

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<String> getBook() {
			return book;
		}

		public void setBook(Set<String> book) {
			this.book = book;
		}


	}

}
