package sample.files;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * A file is a collection of bytes on a disc, these bytes are your data. There
 * are various levels of abstraction above that that Java provides:
 * 
 * 1-) File(Input|Output)Stream - read these bytes as a stream of byte. 
 * 2-) File(Reader|Writer) - read from a stream of bytes as a stream of char. 
 * 3-) Scanner - read from a stream of char and tokenise it. 
 * 4-) RandomAccessFile - read these bytes as a searchable byte[]. 
 * 5-) FileChannel - read these bytes in a safe multithreaded way.
 * 
 */
public class _HowToReadAFile {

	public static void main(String[] argv) {

		File file = new File("inputfile.txt");

		// USING INPUT STREAMS
		readFileUsingFileInputStream(file);
		readFileUsingBufferedInputStream(file);

		// USING FILE READER
		readFileUsingBufferedReader(file);

		// USING SCANNER
		readFileUsingScanner(file);

	}

	/**
	 * Reads text from a character-input stream, buffering characters so as to
	 * provide for the efficient reading of characters, arrays, and lines.The
	 * buffer size may be specified, or the default size may be used. The
	 * default is large enough for most purposes.In general, each read request
	 * made of a Reader causes a corresponding read request to be made of the
	 * underlying character or byte stream. It is therefore advisable to wrap a
	 * BufferedReader around any Reader whose read() operations may be costly,
	 * such as FileReaders and InputStreamReaders.
	 * 
	 * It will buffer the input from the specified file. Without buffering, each
	 * invocation of read() or readLine() could cause bytes to be read from the
	 * file, converted into characters, and then returned, which can be very
	 * inefficient.Programs that use DataInputStreams for textual input can be
	 * localized by replacing each DataInputStream with an appropriate
	 * BufferedReader.
	 * 
	 * Check:
	 * http://docs.oracle.com/javase/6/docs/api/java/io/BufferedReader.html
	 * 
	 * @param file
	 */
	private static void readFileUsingBufferedReader(File file) {
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Scanner can parse primitive types and strings using regular expressions.
	 * A Scanner breaks its input into tokens using a delimiter pattern, which
	 * by default matches whitespace. The resulting tokens may then be converted
	 * into values of different types.
	 * 
	 * Check: http://docs.oracle.com/javase/6/docs/api/java/util/Scanner.html
	 * 
	 * @param file
	 */
	private static void readFileUsingScanner(File file) {
		Scanner in;
		try {
			in = new Scanner(file);

			while (in.hasNext()) {
				// System.out.println(in.next());
				System.out.println(in.nextLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * FileInputStream is a bytes stream class that’s used to read bytes from
	 * file.
	 * 
	 * @param file
	 */
	private static void readFileUsingFileInputStream(File file) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : "
					+ fis.available());

			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
			
			// IF FILE IS SMALL
			// byte[] data = new byte[(int) file.length()];
			// fis.read(data);
			// String str = new String(data, "UTF-8");
			// fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param file
	 */
	private static void readFileUsingBufferedInputStream(File file) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(file);

			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			while (dis.available() != 0) {
				System.out.println(dis.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bis.close();
				dis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
