package sample.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Different methods to write a file in java
 */
public class _HowToWriteAFile {

	public static void main(String[] args) {
		
		File file = new File("outputfile.txt");
		String content = "This is the content to write into file";
		
		writeFileUsingBufferedWriter(file, content);
		
		writeFileUsingFileOutputStream(file, content);

		writeFileUsingPrintWriter(file, content);

	}

	/**
	 * @param file
	 * @param content
	 */
	private static void writeFileUsingPrintWriter(File file, String content) {
		
			
		PrintWriter writer = null;
		try {
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			writer = new PrintWriter(file);
			// writer = new PrintWriter(file, "UTF-8");
			writer.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
		System.out.println("Done");
	}

	/**
	 * In Java, FileOutputStream is a bytes stream class that’s used to handle raw binary data. 
	 * To write the data to file, you have to convert the data into bytes and save it to file.
	 * 
	 * Check http://java.sun.com/j2se/1.4.2/docs/api/java/io/FileOutputStream.html
	 * 
	 * @param file
	 * @param content
	 */
	private static void writeFileUsingFileOutputStream(File file, String content) {
		FileOutputStream fop = null;
		try {

			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * In Java, BufferedWriter is a character streams class to handle the character data. 
	 * Unlike bytes stream (convert data into bytes), you can just write the strings, arrays 
	 * or characters data directly to file.
	 * 
	 * Check http://docs.oracle.com/javase/1.4.2/docs/api/java/io/BufferedWriter.html
	 * 
	 * @param file
	 * @param content
	 */
	private static void writeFileUsingBufferedWriter(File file, String content) {
		try {

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			boolean append = false;
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), append);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
