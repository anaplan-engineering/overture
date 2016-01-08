package org.overture.codegen.cgen;

import java.io.File;

import org.junit.Test;

public class CExamplesTest
{
	static final String cexamplesBase = System.getProperty("cexamples-path");
	static final String outputFolder = new File("target/cgen".replace('/', File.separatorChar)).getAbsolutePath();

	static String getPath(String rpath)
	{
		return new File(cexamplesBase, rpath.replace('/', File.separatorChar)).getAbsolutePath();
	}

	@Test
	public void a()
	{
		CGenMain.main(new String[] { getPath("classes/A.vdmrt"), outputFolder });
	}
}
