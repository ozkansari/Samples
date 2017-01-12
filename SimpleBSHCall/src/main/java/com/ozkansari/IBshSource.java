package com.ozkansari;

import java.io.IOException;
import java.io.Reader;

public interface IBshSource {

	/**
	 * Uniquely identifies bsh source. This could be file path, row id in
	 * database etc. This is important when caching bsh.
	 *
	 * @return identifier
	 */
	String getIdentifier();

	/**
	 * Gets reader for source. This method is responsible for providing content.
	 *
	 * @return Reader for content.
	 * @throws IOException
	 */
	Reader getReader() throws IOException;

	/**
	 * Gets last modification date of source. This is important when caching
	 * bsh.
	 *
	 * @return Last modification date in millisecond.
	 */
	long getLastModifiedDate();
}