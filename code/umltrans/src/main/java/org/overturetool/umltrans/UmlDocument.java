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



public class UmlDocument extends IUmlDocument {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivFilename KEEP=NO
  private String ivFilename = null;
// ***** VDMTOOLS END Name=ivFilename

// ***** VDMTOOLS START Name=ivTopNode KEEP=NO
  private IUmlNode ivTopNode = null;
// ***** VDMTOOLS END Name=ivTopNode

// ***** VDMTOOLS START Name=ivLexems KEEP=NO
  private Vector ivLexems = null;
// ***** VDMTOOLS END Name=ivLexems


// ***** VDMTOOLS START Name=vdm_init_UmlDocument KEEP=NO
  private void vdm_init_UmlDocument () throws CGException {
    try {

      ivFilename = UTIL.ConvertToString(new String());
      ivTopNode = null;
      ivLexems = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_UmlDocument


// ***** VDMTOOLS START Name=UmlDocument KEEP=NO
  public UmlDocument () throws CGException {
    vdm_init_UmlDocument();
  }
// ***** VDMTOOLS END Name=UmlDocument


// ***** VDMTOOLS START Name=getFilename KEEP=NO
  public String getFilename () throws CGException {
    return ivFilename;
  }
// ***** VDMTOOLS END Name=getFilename


// ***** VDMTOOLS START Name=setFilename#1|String KEEP=NO
  public void setFilename (final String pfilename) throws CGException {
    ivFilename = UTIL.ConvertToString(UTIL.clone(pfilename));
  }
// ***** VDMTOOLS END Name=setFilename#1|String


// ***** VDMTOOLS START Name=hasModel KEEP=NO
  public Boolean hasModel () throws CGException {
    return new Boolean(ivTopNode instanceof IUmlModel);
  }
// ***** VDMTOOLS END Name=hasModel


// ***** VDMTOOLS START Name=getModel KEEP=NO
  public IUmlModel getModel () throws CGException {
    return (IUmlModel) ivTopNode;
  }
// ***** VDMTOOLS END Name=getModel


// ***** VDMTOOLS START Name=setModel#1|IUmlModel KEEP=NO
  public void setModel (final IUmlModel pNode) throws CGException {
    ivTopNode = (IUmlNode) UTIL.clone(pNode);
  }
// ***** VDMTOOLS END Name=setModel#1|IUmlModel


// ***** VDMTOOLS START Name=getLexems KEEP=NO
  public Vector getLexems () throws CGException {
    return ivLexems;
  }
// ***** VDMTOOLS END Name=getLexems


// ***** VDMTOOLS START Name=setLexems#1|Vector KEEP=NO
  public void setLexems (final Vector plexems) throws CGException {
    ivLexems = (Vector) UTIL.ConvertToList(UTIL.clone(plexems));
  }
// ***** VDMTOOLS END Name=setLexems#1|Vector


// ***** VDMTOOLS START Name=accept#1|IUmlVisitor KEEP=NO
  public void accept (final IUmlVisitor pVisitor) throws CGException {
    pVisitor.visitDocument((IUmlDocument) this);
  }
// ***** VDMTOOLS END Name=accept#1|IUmlVisitor


// ***** VDMTOOLS START Name=toVdmSlValue KEEP=NO
  public String toVdmSlValue () throws CGException {
;
    return new String("");
  }
// ***** VDMTOOLS END Name=toVdmSlValue


// ***** VDMTOOLS START Name=toVdmPpValue KEEP=NO
  public String toVdmPpValue () throws CGException {
;
    return new String("");
  }
// ***** VDMTOOLS END Name=toVdmPpValue


// ***** VDMTOOLS START Name=UmlDocument#3|String|IUmlNode|Vector KEEP=NO
  public UmlDocument (final String pfilename, final IUmlNode pnode, final Vector plexems) throws CGException {

    vdm_init_UmlDocument();
    {

      setFilename(pfilename);
      ivTopNode = (IUmlNode) UTIL.clone(pnode);
      setLexems(plexems);
    }
  }
// ***** VDMTOOLS END Name=UmlDocument#3|String|IUmlNode|Vector

}
;
