package com.ozkansari.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose
 * .html
 *
 */
public class TryWithResourcesSample {

	public static void main(String[] args) throws IOException {
		
		String path = createTempFile();
		
		System.out.println("normalWay: ");
		normalway(path);
		
		System.out.println("java8Way: ");
		java8way(path);
	}

	private static void normalway(String path) throws IOException {

		// readFirstLineFromFileWithFinallyBlock
		BufferedReader br = new BufferedReader(new FileReader(path));
	    try {
	    	System.out.println(br.readLine());
	    } finally {
	        if (br != null) br.close();
	    }
	}
	
	private static void java8way(String path) throws IOException {

		// readFirstLineFromFileWithFinallyBlock
		try (
			BufferedReader br = new BufferedReader(new FileReader(path))
		) {
			System.out.println(br.readLine());
		}
	}
	

	/**
	 * Helper method
	 * 
	 * @return
	 * @throws IOException
	 */
	private static String createTempFile() throws IOException {
		String path = ".\\temp.txt";
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		try{
		    PrintWriter writer = new PrintWriter(file, "UTF-8");
		    writer.println("The first line");
		    writer.println("The second line");
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
		
		return path;
	}


}
