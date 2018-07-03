package org.overture.interpreter.utilities.statement;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.analysis.QuestionAnswerAdaptor;
import org.overture.ast.node.INode;
import org.overture.ast.statements.*;
import org.overture.interpreter.assistant.IInterpreterAssistantFactory;

/***************************************
 * This method finds a statement type in a model.
 * 
 * @author gkanos
 ****************************************/
public class StatementFinder extends QuestionAnswerAdaptor<Integer, PStm>
{
	protected static IInterpreterAssistantFactory af;

	@SuppressWarnings("static-access")
	public StatementFinder(IInterpreterAssistantFactory af)
	{
		this.af = af;
	}

	@Override
	public PStm caseAAlwaysStm(AAlwaysStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		found = stm.getAlways().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getAlways(), lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getBody().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getBody(), lineno);
	}

	@Override
	public PStm caseAAtomicStm(AAtomicStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}

		for (AAssignmentStm stmt : stm.getAssignments())
		{
			found = stmt.apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stmt, lineno);
			if (found != null)
			{
				break;
			}
		}

		return found;
	}

	@Override
	public PStm caseACasesStm(ACasesStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}

		for (ACaseAlternativeStm stmt : stm.getCases())
		{
			found = stmt.getResult().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stmt.getResult(),
															// lineno);
			if (found != null)
			{
				break;
			}
		}

		return found;
	}

	@Override
	public PStm caseACyclesStm(ACyclesStm stm, Integer lineno)
			throws AnalysisException
	{
		return stm.getStatement().apply(THIS, lineno);
	}

	@Override
	public PStm caseADurationStm(ADurationStm stm, Integer lineno)
			throws AnalysisException
	{
		return stm.getStatement().apply(THIS, lineno);
	}

	@Override
	public PStm caseAElseIfStm(AElseIfStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getThenStm().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getThenStm(), lineno);
	}

	@Override
	public PStm caseAForAllStm(AForAllStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getStatement().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm caseAForIndexStm(AForIndexStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getStatement().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm caseAForPatternBindStm(AForPatternBindStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getStatement().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm caseAIfStm(AIfStm stm, Integer lineno) throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		found = stm.getThenStm().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getThenStm(),
														// lineno);
		if (found != null)
		{
			return found;
		}

		for (AElseIfStm stmt : stm.getElseIf())
		{
			found = stmt.apply(THIS, lineno);// af.createPStmAssistant().findStatement(stmt, lineno);
			if (found != null)
			{
				return found;
			}
		}

		if (stm.getElseStm() != null)
		{
			found = stm.getElseStm().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getElseStm(),
															// lineno);
		}

		return found;
	}

	@Override
	public PStm caseALetBeStStm(ALetBeStStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getStatement().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm caseALetStm(ALetStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}

		found = af.createPDefinitionAssistant().findStatement(stm.getLocalDefs(), lineno);
		if (found != null)
		{
			return found;
		}

		return stm.getStatement().apply(THIS, lineno); // StmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm caseADefStm(ADefStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}

		found = af.createPDefinitionAssistant().findStatement(stm.getLocalDefs(), lineno);
		if (found != null)
		{
			return found;
		}

		return stm.getStatement().apply(THIS, lineno); // StmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm defaultSSimpleBlockStm(SSimpleBlockStm stm, Integer lineno)
			throws AnalysisException
	{
		if (stm.getLocation().getStartLine() == lineno)
		{
			return stm;
		}
		PStm found = null;

		for (PStm stmt : stm.getStatements())
		{
			found = stmt.apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stmt, lineno);
			if (found != null)
			{
				break;
			}
		}

		return found;
	}

	@Override
	public PStm caseATixeStm(ATixeStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		found = stm.getBody().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getBody(), lineno);
		if (found != null)
		{
			return found;
		}

		for (ATixeStmtAlternative tsa : stm.getTraps())
		{
			found = tsa.getStatement().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(tsa.getStatement(),
															// lineno);
			if (found != null)
			{
				break;
			}
		}

		return found;
	}

	@Override
	public PStm caseATrapStm(ATrapStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		found = stm.getBody().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getBody(), lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getWith().apply(THIS, lineno);// PStmAssistantInterpreter.findStatement(stm.getWith(), lineno);
	}

	@Override
	public PStm caseAWhileStm(AWhileStm stm, Integer lineno)
			throws AnalysisException
	{
		PStm found = findStatementBaseCase(stm, lineno);
		if (found != null)
		{
			return found;
		}
		return stm.getStatement().apply(THIS, lineno); // PStmAssistantInterpreter.findStatement(stm.getStatement(),
														// lineno);
	}

	@Override
	public PStm defaultPStm(PStm stm, Integer lineno) throws AnalysisException
	{
		return findStatementBaseCase(stm, lineno);
	}

	@Override
	public PStm createNewReturnValue(INode node, Integer question)
			throws AnalysisException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PStm createNewReturnValue(Object node, Integer question)
			throws AnalysisException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static PStm findStatementBaseCase(PStm stm, int lineno)
	{
		return stm.getLocation().getStartLine() == lineno ? stm : null;
	}
}
