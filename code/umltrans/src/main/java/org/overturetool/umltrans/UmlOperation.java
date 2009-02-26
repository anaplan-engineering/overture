//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2009-01-24 by the VDM++ to JAVA Code Generator
// (v8.2b - Fri 23-Jan-2009 13:05:50)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.umltrans;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
// ***** VDMTOOLS END Name=imports



public class UmlOperation extends IUmlOperation {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivName KEEP=NO
  private String ivName = null;
// ***** VDMTOOLS END Name=ivName

// ***** VDMTOOLS START Name=ivVisibility KEEP=NO
  private IUmlVisibilityKind ivVisibility = null;
// ***** VDMTOOLS END Name=ivVisibility

// ***** VDMTOOLS START Name=ivMultiplicity KEEP=NO
  private IUmlMultiplicityElement ivMultiplicity = null;
// ***** VDMTOOLS END Name=ivMultiplicity

// ***** VDMTOOLS START Name=ivIsQuery KEEP=NO
  private Boolean ivIsQuery = null;
// ***** VDMTOOLS END Name=ivIsQuery

// ***** VDMTOOLS START Name=ivType KEEP=NO
  private IUmlType ivType = null;
// ***** VDMTOOLS END Name=ivType

// ***** VDMTOOLS START Name=ivIsStatic KEEP=NO
  private Boolean ivIsStatic = null;
// ***** VDMTOOLS END Name=ivIsStatic

// ***** VDMTOOLS START Name=ivOwnedParameters KEEP=NO
  private IUmlParameters ivOwnedParameters = null;
// ***** VDMTOOLS END Name=ivOwnedParameters


// ***** VDMTOOLS START Name=vdm_init_UmlOperation KEEP=NO
  private void vdm_init_UmlOperation () throws CGException {
    try {

      ivName = UTIL.ConvertToString(new String());
      ivVisibility = null;
      ivMultiplicity = null;
      ivIsQuery = null;
      ivType = null;
      ivIsStatic = null;
      ivOwnedParameters = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_UmlOperation


// ***** VDMTOOLS START Name=UmlOperation KEEP=NO
  public UmlOperation () throws CGException {
    vdm_init_UmlOperation();
  }
// ***** VDMTOOLS END Name=UmlOperation


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("Operation");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept#1|IUmlVisitor KEEP=NO
  public void accept (final IUmlVisitor pVisitor) throws CGException {
    pVisitor.visitOperation((IUmlOperation) this);
  }
// ***** VDMTOOLS END Name=accept#1|IUmlVisitor


// ***** VDMTOOLS START Name=UmlOperation#7|String|IUmlVisibilityKind|IUmlMultiplicityElement|Boolean|IUmlType|Boolean|IUmlParameters KEEP=NO
  public UmlOperation (final String p1, final IUmlVisibilityKind p2, final IUmlMultiplicityElement p3, final Boolean p4, final IUmlType p5, final Boolean p6, final IUmlParameters p7) throws CGException {

    vdm_init_UmlOperation();
    {

      setName(p1);
      setVisibility((IUmlVisibilityKind) p2);
      setMultiplicity((IUmlMultiplicityElement) p3);
      setIsQuery(p4);
      setType((IUmlType) p5);
      setIsStatic(p6);
      setOwnedParameters((IUmlParameters) p7);
    }
  }
// ***** VDMTOOLS END Name=UmlOperation#7|String|IUmlVisibilityKind|IUmlMultiplicityElement|Boolean|IUmlType|Boolean|IUmlParameters


// ***** VDMTOOLS START Name=UmlOperation#9|String|IUmlVisibilityKind|IUmlMultiplicityElement|Boolean|IUmlType|Boolean|IUmlParameters|Long|Long KEEP=NO
  public UmlOperation (final String p1, final IUmlVisibilityKind p2, final IUmlMultiplicityElement p3, final Boolean p4, final IUmlType p5, final Boolean p6, final IUmlParameters p7, final Long line, final Long column) throws CGException {

    vdm_init_UmlOperation();
    {

      setName(p1);
      setVisibility((IUmlVisibilityKind) p2);
      setMultiplicity((IUmlMultiplicityElement) p3);
      setIsQuery(p4);
      setType((IUmlType) p5);
      setIsStatic(p6);
      setOwnedParameters((IUmlParameters) p7);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=UmlOperation#9|String|IUmlVisibilityKind|IUmlMultiplicityElement|Boolean|IUmlType|Boolean|IUmlParameters|Long|Long


// ***** VDMTOOLS START Name=init#1|HashMap KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("name");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setName(UTIL.ConvertToString(data.get(fname)));
    }
    {

      String fname = new String("visibility");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setVisibility((IUmlVisibilityKind) data.get(fname));
    }
    {

      String fname = new String("multiplicity");
      Boolean cond_22 = null;
      cond_22 = new Boolean(data.containsKey(fname));
      if (cond_22.booleanValue()) 
        setMultiplicity((IUmlMultiplicityElement) data.get(fname));
    }
    {

      String fname = new String("isQuery");
      Boolean cond_31 = null;
      cond_31 = new Boolean(data.containsKey(fname));
      if (cond_31.booleanValue()) 
        setIsQuery((Boolean) data.get(fname));
    }
    {

      String fname = new String("type");
      Boolean cond_40 = null;
      cond_40 = new Boolean(data.containsKey(fname));
      if (cond_40.booleanValue()) 
        setType((IUmlType) data.get(fname));
    }
    {

      String fname = new String("isStatic");
      Boolean cond_49 = null;
      cond_49 = new Boolean(data.containsKey(fname));
      if (cond_49.booleanValue()) 
        setIsStatic((Boolean) data.get(fname));
    }
    {

      String fname = new String("ownedParameters");
      Boolean cond_58 = null;
      cond_58 = new Boolean(data.containsKey(fname));
      if (cond_58.booleanValue()) 
        setOwnedParameters((IUmlParameters) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init#1|HashMap


// ***** VDMTOOLS START Name=getName KEEP=NO
  public String getName () throws CGException {
    return ivName;
  }
// ***** VDMTOOLS END Name=getName


// ***** VDMTOOLS START Name=setName#1|String KEEP=NO
  public void setName (final String parg) throws CGException {
    ivName = UTIL.ConvertToString(UTIL.clone(parg));
  }
// ***** VDMTOOLS END Name=setName#1|String


// ***** VDMTOOLS START Name=getVisibility KEEP=NO
  public IUmlVisibilityKind getVisibility () throws CGException {
    return (IUmlVisibilityKind) ivVisibility;
  }
// ***** VDMTOOLS END Name=getVisibility


// ***** VDMTOOLS START Name=setVisibility#1|IUmlVisibilityKind KEEP=NO
  public void setVisibility (final IUmlVisibilityKind parg) throws CGException {
    ivVisibility = (IUmlVisibilityKind) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setVisibility#1|IUmlVisibilityKind


// ***** VDMTOOLS START Name=getMultiplicity KEEP=NO
  public IUmlMultiplicityElement getMultiplicity () throws CGException {
    return (IUmlMultiplicityElement) ivMultiplicity;
  }
// ***** VDMTOOLS END Name=getMultiplicity


// ***** VDMTOOLS START Name=setMultiplicity#1|IUmlMultiplicityElement KEEP=NO
  public void setMultiplicity (final IUmlMultiplicityElement parg) throws CGException {
    ivMultiplicity = (IUmlMultiplicityElement) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setMultiplicity#1|IUmlMultiplicityElement


// ***** VDMTOOLS START Name=getIsQuery KEEP=NO
  public Boolean getIsQuery () throws CGException {
    return ivIsQuery;
  }
// ***** VDMTOOLS END Name=getIsQuery


// ***** VDMTOOLS START Name=setIsQuery#1|Boolean KEEP=NO
  public void setIsQuery (final Boolean parg) throws CGException {
    ivIsQuery = (Boolean) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setIsQuery#1|Boolean


// ***** VDMTOOLS START Name=getType KEEP=NO
  public IUmlType getType () throws CGException {
    return (IUmlType) ivType;
  }
// ***** VDMTOOLS END Name=getType


// ***** VDMTOOLS START Name=hasType KEEP=NO
  public Boolean hasType () throws CGException {
    return new Boolean(!UTIL.equals(ivType, null));
  }
// ***** VDMTOOLS END Name=hasType


// ***** VDMTOOLS START Name=setType#1|IUmlType KEEP=NO
  public void setType (final IUmlType parg) throws CGException {
    ivType = (IUmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setType#1|IUmlType


// ***** VDMTOOLS START Name=getIsStatic KEEP=NO
  public Boolean getIsStatic () throws CGException {
    return ivIsStatic;
  }
// ***** VDMTOOLS END Name=getIsStatic


// ***** VDMTOOLS START Name=setIsStatic#1|Boolean KEEP=NO
  public void setIsStatic (final Boolean parg) throws CGException {
    ivIsStatic = (Boolean) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setIsStatic#1|Boolean


// ***** VDMTOOLS START Name=getOwnedParameters KEEP=NO
  public IUmlParameters getOwnedParameters () throws CGException {
    return (IUmlParameters) ivOwnedParameters;
  }
// ***** VDMTOOLS END Name=getOwnedParameters


// ***** VDMTOOLS START Name=hasOwnedParameters KEEP=NO
  public Boolean hasOwnedParameters () throws CGException {
    return new Boolean(!UTIL.equals(ivOwnedParameters, null));
  }
// ***** VDMTOOLS END Name=hasOwnedParameters


// ***** VDMTOOLS START Name=setOwnedParameters#1|IUmlParameters KEEP=NO
  public void setOwnedParameters (final IUmlParameters parg) throws CGException {
    ivOwnedParameters = (IUmlParameters) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setOwnedParameters#1|IUmlParameters

}
;
