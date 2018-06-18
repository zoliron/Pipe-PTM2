package com.pipe.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



/**
 * A I/O related utilities.
 *
 * @author Ronen Zolicha
 */
public class IoUtils{



	/**
	 * Read the specified {@link InputStream} to {@link String}.
	 */
	public static String readAsString(InputStream is) throws IOException{
		ByteArrayOutputStream os = new ByteArrayOutputStream(1024);

		pump(is, os);

		return os.toString("UTF-8");
	}



	/**
	 * Read the specified {@link InputStream} to byte array.
	 */
	public static byte[] readToEnd(InputStream is) throws IOException{
		ByteArrayOutputStream os = new ByteArrayOutputStream(1024);

		pump(is, os);

		return os.toByteArray();
	}



	/**
	 * Pump the specified {@link InputStream} to {@link OutputStream}.
	 */
	public static void pump(InputStream is, OutputStream os) throws IOException{
		byte[] buffer = new byte[1024];

		int length;
		while ((length = is.read(buffer)) != -1)
			os.write(buffer, 0, length);
	}



}