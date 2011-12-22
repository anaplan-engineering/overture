/*******************************************************************************
 * Copyright (c) 2009, 2011 Overture Team and others.
 *
 * Overture is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Overture is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Overture.  If not, see <http://www.gnu.org/licenses/>.
 * 	
 * The Overture Tool web-site: http://overturetool.org/
 *******************************************************************************/
package org.overture.ide.debug.ui.launchconfigurations;

import java.lang.instrument.ClassDefinition;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.eclipse.jface.operation.IRunnableContext;
import org.overture.ast.definitions.AExplicitFunctionDefinition;
import org.overture.ast.definitions.AExplicitOperationDefinition;
import org.overture.ast.definitions.SClassDefinition;
import org.overture.ast.definitions.assistants.PAccessSpecifierAssistant;
import org.overture.ast.modules.AModuleModules;
import org.overture.ast.node.INode;
import org.overture.ast.node.Token;
import org.overture.ast.patterns.assistants.PatternList;
import org.overture.ast.statements.ASubclassResponsibilityStm;


public class MethodSearchEngine
{
	public final static int MAIN_ONLY = 1;
	public final static int EXPLICIT_FUNCTION = 2;
	public final static int EXPLICIT_OPERATION = 4;
	public final static int STATIC = 8;
	public final static int PUBLIC = 16;
	public static final int WORLD_CLASS = 32;
	public static final int RUN = 64;

	public INode[] searchMainMethods(IRunnableContext context,
			Object[] nodes, int constraints)
	{
		boolean onlyMain = (constraints & MAIN_ONLY) == MAIN_ONLY;
		boolean onlyExplicitFunction = (constraints & EXPLICIT_FUNCTION) == EXPLICIT_FUNCTION;
		boolean onlyExplicitOperation = (constraints & EXPLICIT_OPERATION) == EXPLICIT_OPERATION;
		boolean onlyStatic = (constraints & STATIC) == STATIC;
		boolean onlyPublicAccess = (constraints & PUBLIC) == PUBLIC;
		boolean onlyRun = (constraints & RUN) == RUN;
		boolean onlyWorldClass = (constraints & WORLD_CLASS) == WORLD_CLASS;

		final String MAIN_NAME = "main";
		final String RUN_NAME = "run";
		final String WORLD_NAME = "world";

		List<INode> matched = new Vector<INode>();

		for (int i = 0; i < nodes.length; i++)
		{
			Object iAstNode = nodes[i];
			boolean accept = false;

			if (onlyExplicitOperation
					&& iAstNode instanceof AExplicitOperationDefinition)
			{
				AExplicitOperationDefinition exop = (AExplicitOperationDefinition) iAstNode;
				if (isConstructor(exop))
				{
					continue;//is constructor
				}
				
				if(onlyRun && !exop.getName().getName().equalsIgnoreCase(RUN_NAME))
				{
					continue;
				}
				
				if(onlyWorldClass && (exop.getClassDefinition()==null || !exop.getClassDefinition().getName().getName().equalsIgnoreCase(WORLD_NAME)))
				{
					continue;
				}

				if (onlyStatic && !PAccessSpecifierAssistant.isStatic(exop.getAccess()))
				{
					continue;
				}

				if (!PAccessSpecifierAssistant.isStatic(exop.getAccess()) && exop.getClassDefinition() != null)
				{
					// check for empty constructor
					boolean ok = false;
					boolean constructorFound = false;
					for (Object def : exop.getClassDefinition().getDefinitions())
					{
						if (def instanceof AExplicitOperationDefinition)
						{
							AExplicitOperationDefinition ctor = (AExplicitOperationDefinition) def;
							if (isConstructor(ctor))
							{
								continue;
							}
							if (ctor.getName().getName().equalsIgnoreCase(exop.getClassDefinition().getName().getName()))
							{
								constructorFound = true;
							}
							if (ctor.getBody() instanceof ASubclassResponsibilityStm)
							{
								// abstract class instantiation impossible
								ok = false;
								break;
							}
							if ( ctor.getParameterPatterns() != null
									&& ctor.getParameterPatterns().size() > 0)
							{
								ok = true;
								break;
							}
						}

					}
					if (!ok && constructorFound)
					{
						continue;
					}
				}
				if (onlyMain
						&& !exop.getName().getName().toLowerCase().equals(MAIN_NAME))
				{
					continue;
				}
				if (onlyPublicAccess
						&& !PAccessSpecifierAssistant.isPublic(exop.getAccess()))
				{
					continue;
				}

				if ( exop.getParameterPatterns() != null
						&& exop.getParameterPatterns().size() > 0)
				{
					continue;
				}
				accept = true;

			}
			if (onlyExplicitFunction
					&& iAstNode instanceof AExplicitFunctionDefinition)
			{
				AExplicitFunctionDefinition exfu = (AExplicitFunctionDefinition) iAstNode;
				if (onlyStatic && !PAccessSpecifierAssistant.isStatic(exfu.getAccess()))
				{
					continue;
				}
				
				if(onlyRun && !exfu.getName().getName().equalsIgnoreCase(RUN_NAME))
				{
					continue;
				}
				
				if(onlyWorldClass && (exfu.getClassDefinition()==null || !exfu.getClassDefinition().getName().getName().equalsIgnoreCase(WORLD_NAME)))
				{
					continue;
				}
				
				if (onlyMain
						&& !exfu.getName().getName().toLowerCase().equals(MAIN_NAME))
				{
					continue;
				}
				if (onlyPublicAccess
						&& !PAccessSpecifierAssistant.isPublic(exfu.getAccess()))
				{
					continue;
				}

				if (exfu.getParamPatternList() != null
						&& (exfu.getParamPatternList().size() > 0 && exfu.getParamPatternList().get(0) instanceof PatternList && ((PatternList)exfu.getParamPatternList().get(0)).size()>0))
				{
					continue;
				}
				accept = true;

			}

			if (accept && iAstNode instanceof INode)
			{
				matched.add((INode) iAstNode);
			}

			if (iAstNode instanceof ClassDefinition)
			{
				Object[] elements = ((SClassDefinition) iAstNode).getDefinitions().toArray();
				matched.addAll(Arrays.asList(searchMainMethods(context, elements, constraints)));
			}
			if (iAstNode instanceof AModuleModules)
			{
				Object[] elements = ((AModuleModules) iAstNode).getDefs().toArray();
				matched.addAll(Arrays.asList(searchMainMethods(context, elements, constraints)));
			}
		}
		return matched.toArray(new INode[matched.size()]);
	}
	
	
	public static boolean isConstructor(AExplicitOperationDefinition op)
	{
		if (op.getIsConstructor()||op.getClassDefinition()!=null && op.getName().getName().equalsIgnoreCase(op.getClassDefinition().getLocation().module))
		{
			return true;
		}
		return false;
	}
}