package com.zoliron.cachemanager;

import com.zoliron.utils.IoUtils;

import java.io.*;
import java.util.Base64;



/**
 * A {@link File} base {@link CacheManager}.
 *
 * @author Ronen Zolicha
 */
public class FileCacheManager implements CacheManager{



	/**
	 * The cache directory.
	 */
	private static final File CACHE_DIRECTORY = new File("file_cache");



	@Override
	public void save(String problem, String solution) throws IOException{
		File file = getProblemFile(problem);

		try (InputStream is = IoUtils.toInputStream(solution);
			 OutputStream os = new BufferedOutputStream(new FileOutputStream(file))){

			IoUtils.pump(is, os);
		}
	}



	@Override
	public String load(String problem) throws IOException{
		File file = getProblemFile(problem);
		if (!file.exists())
			return null;

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
			return IoUtils.readAsString(bis);
		}
	}



	/**
	 * Returns the problem file.
	 */
	private static File getProblemFile(String problem){
		String base64 = Base64.getEncoder().withoutPadding().encodeToString(problem.getBytes());
		String fileName = base64 + ".data";

		return new File(CACHE_DIRECTORY, fileName);
	}



}