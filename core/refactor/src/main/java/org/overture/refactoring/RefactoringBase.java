package org.overture.refactoring;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.lex.Dialect;
import org.overture.ast.modules.AModuleModules;
import org.overture.ast.node.INode;
import org.overture.ast.statements.AIdentifierStateDesignator;
import org.overture.ast.util.modules.ModuleList;
import org.overture.codegen.analysis.vdm.Renaming;
import org.overture.codegen.ir.IRGenerator;
import org.overture.codegen.ir.IRInfo;
import org.overture.codegen.ir.IRSettings;
import org.overture.codegen.printer.MsgPrinter;
import org.overture.codegen.utils.GeneralCodeGenUtils;
import org.overture.config.Settings;
import org.overture.parser.util.ParserUtil;
import org.overture.rename.RefactoringRenameCollector;
import org.overture.rename.Renamer;
import org.overture.typechecker.util.TypeCheckerUtil;
import org.overture.typechecker.util.TypeCheckerUtil.TypeCheckResult;

public class RefactoringBase {
	
	protected IRGenerator generator;
	private List<Renaming> allRenamings;
	private GeneratedData generatedData;
	public RefactoringBase(){
		this.generator = new IRGenerator();
		
		IRSettings irSettings = new IRSettings();
		irSettings.setCharSeqAsString(true);
		irSettings.setGeneratePreConds(false);
		irSettings.setGeneratePreCondChecks(false);
		irSettings.setGeneratePostConds(false);
		irSettings.setGeneratePostCondChecks(false);
		generator.getIRInfo().setSettings(irSettings);
	}
	
	public List<INode> generate(List<INode> ast, String[] parameters) throws AnalysisException
	{

		if (Settings.dialect == Dialect.VDM_SL)
		{
			ModuleList moduleList = new ModuleList(getModules(ast));
			moduleList.combineDefaults();
			ast = getNodes(moduleList);
		}
		
		List<INode> userModules = getUserModules(ast);
		
		allRenamings = new LinkedList<Renaming>();
		allRenamings.addAll(performRenaming(userModules, getInfo().getIdStateDesignatorDefs(), parameters));

		generatedData = new GeneratedData();
		generatedData.setAllRenamings(allRenamings);

		return userModules;
	}
	
	public List<INode> getAST(String fileName) throws AnalysisException
	{
		File file = new File(fileName);
		
		List<AModuleModules> expInput = ParserUtil.parseSl(file).result;
		
		TypeCheckResult<List<AModuleModules>> tcResult = TypeCheckerUtil.typeCheckSl(file);

		if (GeneralCodeGenUtils.hasErrors(tcResult))
		{
			MsgPrinter.getPrinter().error("Found errors in VDM model:");
			MsgPrinter.getPrinter().errorln(GeneralCodeGenUtils.errorStr(tcResult));
			return null;
		}

		List<INode> ast = getNodes(tcResult.result);
		
		if (Settings.dialect == Dialect.VDM_SL)
		{
			ModuleList moduleList = new ModuleList(getModules(ast));
			moduleList.combineDefaults();
			ast = getNodes(moduleList);
		}
		
		List<INode> userModules = getUserModules(ast);
		return userModules;
	}
	
	public static List<INode> getNodes(List<? extends INode> ast)
	{
		List<INode> nodes = new LinkedList<>();

		nodes.addAll(ast);

		return nodes;
	}
	
	public static List<AModuleModules> getModules(List<INode> ast)
	{
		List<AModuleModules> modules = new LinkedList<>();

		for (INode n : ast)
		{
			if (n instanceof AModuleModules)
			{
				modules.add((AModuleModules) n);
			}
		}

		return modules;
	}
	
	private List<Renaming> performRenaming(List<INode> mergedParseLists,
			Map<AIdentifierStateDesignator, PDefinition> idDefs, String[] parameters)
			throws AnalysisException
	{

		List<Renaming> allRenamings = new LinkedList<Renaming>();

		RefactoringRenameCollector renamingsCollector = new RefactoringRenameCollector(generator.getIRInfo().getTcFactory(), idDefs);
		Renamer renamer = new Renamer();
		renamingsCollector.SetRefactoringParameters(parameters);
		for (INode node : mergedParseLists)
		{
			Set<Renaming> currentRenamings = renamer.computeRenamings(node, renamingsCollector);

			if (!currentRenamings.isEmpty())
			{
				renamer.rename(node, currentRenamings);
				allRenamings.addAll(currentRenamings);
			}
		}

		Collections.sort(allRenamings);

		return allRenamings;
	}
	
	protected List<INode> getUserModules(List<? extends INode> ast)
	{
		List<INode> userModules = new LinkedList<INode>();

		for (INode node : ast)
		{
			if (!getInfo().getDeclAssistant().isLibrary(node))
			{
				userModules.add(node);
			}
		}

		return userModules;
	}

	public IRInfo getInfo()
	{
		return generator.getIRInfo();
	}
	
	public GeneratedData getGeneratedData(){
		return generatedData;
	}
}
