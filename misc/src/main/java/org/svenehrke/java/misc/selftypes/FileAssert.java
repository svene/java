package org.svenehrke.java.misc.selftypes;

import java.io.File;

public class FileAssert extends GenericAssert<FileAssert, File> {
	public FileAssert(File aActual) {
		super(aActual);
	}
}
