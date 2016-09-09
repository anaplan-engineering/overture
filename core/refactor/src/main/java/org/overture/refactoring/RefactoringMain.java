package org.overture.refactoring;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.lex.Dialect;
import org.overture.ast.modules.AModuleModules;
import org.overture.codegen.printer.MsgPrinter;
import org.overture.config.Settings;

import org.overture.typechecker.util.TypeCheckerUtil;
import org.overture.typechecker.util.TypeCheckerUtil.TypeCheckResult;

public class RefactoringMain {
	public static final String PRINT_ARG = "-print";
	public static final String OO_ARG = "-pp";
	public static final String RT_ARG = "-rt";
	public static final String SL_ARG = "-sl";
	
	public static void main(String[] args)
	{
		boolean printClasses = false;
		
		if (args == null || args.length <= 1)
		{
			usage("Too few arguments provided");
		}	
		
		List<String> listArgs = Arrays.asList(args);
		List<File> files = new LinkedList<File>();
		RefactoringMode refacMode = null;
		
		for (Iterator<String> i = listArgs.iterator(); i.hasNext();)
		{
			String arg = i.next();
			
			if (arg.equals(OO_ARG))
			{
				refacMode = RefactoringMode.OO_SPEC;
				Settings.dialect = Dialect.VDM_PP;
			} else if (arg.equals(RT_ARG))
			{
				refacMode = RefactoringMode.OO_SPEC;
				Settings.dialect = Dialect.VDM_RT;
			} else if (arg.equals(SL_ARG))
			{
				refacMode = RefactoringMode.SL_SPEC;
				Settings.dialect = Dialect.VDM_SL;
			} else if (arg.equals(PRINT_ARG))
			{
				printClasses = true;
			} else
			{
				// It's a file or a directory
				File file = new File(arg);

				if (file.isFile())
				{
					if (RefactoringUtils.isVdmSourceFile(file))
					{
						files.add(file);
					}
				} else
				{
					usage("Not a file: " + file);
				}
			}
		}
		
		//////////////////////////////////////////////////////////
		
		if (Settings.dialect == null)
		{
			usage("No VDM dialect specified");
		}

		MsgPrinter.getPrinter().println("Starting refactoring...\n");

		if (files.isEmpty())
		{
			usage("Input files are missing");
		}
		
		if (refacMode == RefactoringMode.SL_SPEC)
		{
			//handleSl(files, irSettings, javaSettings, printClasses, outputDir, separateTestCode);
			
		} else if (refacMode == RefactoringMode.OO_SPEC)
		{
			//handleOo(files, irSettings, javaSettings, Settings.dialect, printClasses, outputDir, separateTestCode);
		} else
		{
			MsgPrinter.getPrinter().errorln("Unexpected dialect: "
					+ refacMode);
		}
		
	}
	
	public static void handleSl(List<File> files, boolean printCode, File outputDir,
			boolean separateTestCode)
	{
//		try
//		{
			
			Settings.dialect = Dialect.VDM_SL;
			TypeCheckResult<List<AModuleModules>> tcResult = TypeCheckerUtil.typeCheckSl(files);

			if (RefactoringUtils.hasErrors(tcResult))
			{
				MsgPrinter.getPrinter().error("Found errors in VDM model:");
				MsgPrinter.getPrinter().errorln(RefactoringUtils.errorStr(tcResult));
				return;
			}
			
			//JavaCodeGen vdmCodGen = new JavaCodeGen();
			
			//GeneratedData data = vdmCodGen.generate(CodeGenBase.getNodes(tcResult.result));

			//processData(printCode, outputDir, vdmCodGen, data, separateTestCode);

//		} catch (AnalysisException e)
//		{
//			MsgPrinter.getPrinter().println("Could not code generate model: "
//					+ e.getMessage());
//		}
	}
	
	public static void usage(String msg)
	{
		MsgPrinter.getPrinter().errorln("VDM Refactoring Generator: " + msg
				+ "\n");
		
		MsgPrinter.getPrinter().errorln(PRINT_ARG
				+ ": print the refactored code to the console");

		System.exit(1);
	}
}
