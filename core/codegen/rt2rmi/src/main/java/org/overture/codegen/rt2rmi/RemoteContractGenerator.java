package org.overture.codegen.rt2rmi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.overture.ast.analysis.AnalysisException;
import org.overture.cgrmi.extast.declarations.ARemoteContractDeclCG;
import org.overture.codegen.cgast.declarations.ADefaultClassDeclCG;
import org.overture.codegen.cgast.declarations.AMethodDeclCG;

/*
 * This set up the remote contracts for the generated Java code
 * according to the description in the main report
 * Here only signatures of methods are set up, because it is a
 * remote contract
 * 
 * Sets up the ARemoteContractDeclCG node
 */

public class RemoteContractGenerator {

	private List<ADefaultClassDeclCG> irClasses;

	public RemoteContractGenerator(List<ADefaultClassDeclCG> irClasses) {
		super();
		this.irClasses = irClasses;
	}

	public Set<ARemoteContractDeclCG> run() throws AnalysisException {

		Set<ARemoteContractDeclCG> remoteContracts = new HashSet<ARemoteContractDeclCG>();

		for(ADefaultClassDeclCG classCg : irClasses){

			String currentName = classCg.getName().toString();

			ARemoteContractDeclCG remoteContract = new ARemoteContractDeclCG();

			remoteContract.setName(currentName + "_i"); // transform name

			if(classCg.getSuperName()==null) {
				remoteContract.setIsSuperClass(true);
				remoteContract.setSuperName(currentName);
			}
			else{
				remoteContract.setIsSuperClass(false);
				remoteContract.setSuperName(classCg.getSuperName()+"_i");
			}
			
//			if(classCg.getSuperName()==null) contractImpl.setIsUniCast(true);
//			else contractImpl.setIsUniCast(false);
			
			for(AMethodDeclCG method : classCg.getMethods()){

				AMethodDeclCG methodSignature = method.clone();
				
				// Skip the auto generated toString() method
				if(methodSignature.getName().equals("toString")){
				}
				else if(methodSignature.getAccess().equals("public")){// && methodSignature.getStatic()==null){ // if public add to remote contract

					if(methodSignature.getIsConstructor()) continue;
					methodSignature.setAbstract(false);
					methodSignature.setBody(null);
					//methodSignature.setStatic(false);
					remoteContract.getMethodSignatures().add(methodSignature);
				}
			}
			remoteContracts.add(remoteContract);
		}
		return remoteContracts;
	}
}