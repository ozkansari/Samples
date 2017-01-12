package com.ozkansari;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileBshSource implements IBshSource {
	private String bshAbsoluteFileName;

	public FileBshSource(String bshAbsoluteFileName) {
		this.bshAbsoluteFileName = bshAbsoluteFileName;
	}

	/**
	 * Absolute file path for bsh file.
	 */
	public String getIdentifier() {
		return bshAbsoluteFileName;
	}

	public Reader getReader() throws IOException {
		return new FileReader(bshAbsoluteFileName);
	}

	public long getLastModifiedDate() {
		return new File(bshAbsoluteFileName).lastModified();
	}

	
}
