package toolset;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFileUtils {

	private static final Logger LOGGER = Logger.getLogger(MyFileUtils.class.getName());

	public static void main(String[] args) {
		try {
	        final String pathName = "C:\\_TCMB\\_sonuc";
			Files.walk(Paths.get(pathName))
	                .filter(Files::isRegularFile)
	                .sorted((p1,p2)->0-p1.getName(2).compareTo(p2.getName(2)))
	                .forEach( e -> { printInfo(e); } );

	    } catch (IOException ex) {
	        LOGGER.log(Level.SEVERE, null, ex);
	    }
	}

	private static void printInfo(Path p) {
		try {
			String content = new String(Files.readAllBytes(p), Charset.forName("UTF-8"));
			String errorStatus = content.contains("hata") ? "HATA" : " OK ";
			String minimizedContent = content.replaceAll("\n", "").replaceAll("isimli zip ", "");
			String formattedContent = clearTurkishChars(minimizedContent);
			System.out.println(errorStatus + "\t" + formattedContent);
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		}
		
	}
	
	public static String clearTurkishChars(String str) {
		  String ret = str;
			char[] turkishChars = new char[] {0x131, 0x130, 0xFC, 0xDC, 0xF6, 0xD6, 0x15F, 0x15E, 0xE7, 0xC7, 0x11F, 0x11E};
			char[] englishChars = new char[] {'i', 'I', 'u', 'U', 'o', 'O', 's', 'S', 'c', 'C', 'g', 'G'};
			for (int i = 0; i < turkishChars.length; i++) {
				ret = ret.replaceAll(new String(new char[]{turkishChars[i]}), new String(new char[]{englishChars[i]}));
			}
			return ret;
		}

}
