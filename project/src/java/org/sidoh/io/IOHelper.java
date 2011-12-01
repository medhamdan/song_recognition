package org.sidoh.io;

import java.io.File;

public class IOHelper {
	/**
	 * Recursively remove directory
	 * 
	 * Taken from: http://www.exampledepot.com/egs/java.io/DeleteDir.html
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean deleteDir(File dir) {
	    if (dir.isDirectory()) {
	        String[] children = dir.list();
	        for (int i=0; i<children.length; i++) {
	            boolean success = deleteDir(new File(dir, children[i]));
	            if (!success) {
	                return false;
	            }
	        }
	    }

	    // The directory is now empty so delete it
	    return dir.delete();
	}
	
	/**
	 * Get relative path from two absolute paths.
	 * 
	 * @return
	 */
	public static String getRelativePath(File dir, File child) {
		return dir.getAbsoluteFile().toURI().relativize(child.getAbsoluteFile().toURI()).getPath();
	}
}
