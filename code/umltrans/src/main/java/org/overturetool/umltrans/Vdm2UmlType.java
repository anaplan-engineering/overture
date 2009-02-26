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

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import jp.co.csk.vdm.toolbox.VDM.quotes.*;
import org.overturetool.ast.imp.*;
import org.overturetool.ast.itf.*;
// ***** VDMTOOLS END Name=imports



public class Vdm2UmlType {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp


// ***** VDMTOOLS START Name=vdm_init_Vdm2UmlType KEEP=NO
  private void vdm_init_Vdm2UmlType () throws CGException {}
// ***** VDMTOOLS END Name=vdm_init_Vdm2UmlType


// ***** VDMTOOLS START Name=Vdm2UmlType KEEP=NO
  public Vdm2UmlType () throws CGException {
    vdm_init_Vdm2UmlType();
  }
// ***** VDMTOOLS END Name=Vdm2UmlType


// ***** VDMTOOLS START Name=extractMultiplicity#1|IOmlType KEEP=NO
  static public IUmlMultiplicityElement extractMultiplicity (final IOmlType t) throws CGException {

    Boolean isOrdered = new Boolean(false);
    Boolean isUnique = new Boolean(true);
    Long lower = new Long(1);
    Long upper = new Long(1);
    boolean succ_2 = true;
    {

      succ_2 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlSetType))) 
        succ_2 = false;
      if (succ_2) {

        upper = null;
        lower = UTIL.NumberToLong(UTIL.clone(new Long(0)));
        isOrdered = (Boolean) UTIL.clone(new Boolean(false));
      }
      else {

        succ_2 = true;
        if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlSeq0Type))) 
          succ_2 = false;
        if (succ_2) {

          lower = UTIL.NumberToLong(UTIL.clone(new Long(0)));
          upper = null;
          isOrdered = (Boolean) UTIL.clone(new Boolean(true));
          isUnique = (Boolean) UTIL.clone(new Boolean(false));
        }
        else {

          succ_2 = true;
          if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlSeq1Type))) 
            succ_2 = false;
          if (succ_2) {

            lower = UTIL.NumberToLong(UTIL.clone(new Long(1)));
            upper = null;
            isOrdered = (Boolean) UTIL.clone(new Boolean(true));
            isUnique = (Boolean) UTIL.clone(new Boolean(false));
          }
          else {

            succ_2 = true;
            if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlGeneralMapType))) 
              succ_2 = false;
            if (!succ_2) {

              succ_2 = true;
              if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlInjectiveMapType))) 
                succ_2 = false;
            }
            if (succ_2) {

              isOrdered = (Boolean) UTIL.clone(new Boolean(true));
              upper = null;
              lower = UTIL.NumberToLong(UTIL.clone(new Long(0)));
              isUnique = (Boolean) UTIL.clone(new Boolean(false));
            }
            else {

              succ_2 = true;
              if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlOptionalType))) 
                succ_2 = false;
              if (succ_2) {

                upper = UTIL.NumberToLong(UTIL.clone(new Long(1)));
                lower = UTIL.NumberToLong(UTIL.clone(new Long(0)));
              }
            }
          }
        }
      }
    }
    return (IUmlMultiplicityElement) new UmlMultiplicityElement(isOrdered, isUnique, lower, upper);
  }
// ***** VDMTOOLS END Name=extractMultiplicity#1|IOmlType


// ***** VDMTOOLS START Name=getQualifier#1|IOmlType KEEP=NO
  static public IUmlType getQualifier (final IOmlType t) throws CGException {

    IUmlType varRes_2 = null;
    boolean succ_3 = true;
    {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlInjectiveMapType))) 
        succ_3 = false;
      if (succ_3) {

        IOmlInjectiveMapType t1 = (IOmlInjectiveMapType) t;
        IOmlType par_10 = null;
        par_10 = (IOmlType) t1.getDomType();
        varRes_2 = (IUmlType) convertType((IOmlType) par_10);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlGeneralMapType))) 
        succ_3 = false;
      if (succ_3) {

        IOmlGeneralMapType t1 = (IOmlGeneralMapType) t;
        IOmlType par_15 = null;
        par_15 = (IOmlType) t1.getDomType();
        varRes_2 = (IUmlType) convertType((IOmlType) par_15);
      }
    }
    if (!succ_3) 
      varRes_2 = null;
    return (IUmlType) varRes_2;
  }
// ***** VDMTOOLS END Name=getQualifier#1|IOmlType


// ***** VDMTOOLS START Name=convertType#1|IOmlType KEEP=NO
  static public IUmlType convertType (final IOmlType t) throws CGException {

    Object varRes_2 = null;
    boolean succ_3 = true;
    {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlBoolType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlBoolType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlNat1Type))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlIntegerType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlNatType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlIntegerType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlIntType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlIntegerType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlRealType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlUnlimitedNatural();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlCharType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlCharType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlTokenType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlIntegerType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlSetType))) 
        succ_3 = false;
      if (succ_3) {

        IOmlSetType t1 = (IOmlSetType) t;
        IOmlType par_24 = null;
        par_24 = (IOmlType) t1.getType();
        varRes_2 = convertType((IOmlType) par_24);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlSeq0Type))) 
        succ_3 = false;
      if (succ_3) {

        IOmlSeq0Type t1 = (IOmlSeq0Type) t;
        IOmlType par_29 = null;
        par_29 = (IOmlType) t1.getType();
        varRes_2 = convertType((IOmlType) par_29);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlSeq1Type))) 
        succ_3 = false;
      if (succ_3) {

        IOmlSeq1Type t1 = (IOmlSeq1Type) t;
        IOmlType par_34 = null;
        par_34 = (IOmlType) t1.getType();
        varRes_2 = convertType((IOmlType) par_34);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlInjectiveMapType))) 
        succ_3 = false;
      if (succ_3) {

        IOmlInjectiveMapType t1 = (IOmlInjectiveMapType) t;
        IOmlType par_39 = null;
        par_39 = (IOmlType) t1.getRngType();
        varRes_2 = convertType((IOmlType) par_39);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlGeneralMapType))) 
        succ_3 = false;
      if (succ_3) {

        IOmlGeneralMapType t1 = (IOmlGeneralMapType) t;
        IOmlType par_44 = null;
        par_44 = (IOmlType) t1.getRngType();
        varRes_2 = convertType((IOmlType) par_44);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlEmptyType))) 
        succ_3 = false;
      if (succ_3) 
        varRes_2 = new UmlVoidType();
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlOptionalType))) 
        succ_3 = false;
      if (succ_3) {

        IOmlOptionalType t1 = (IOmlOptionalType) t;
        IOmlType par_51 = null;
        par_51 = (IOmlType) t1.getType();
        varRes_2 = convertType((IOmlType) par_51);
      }
    }
    if (!succ_3) {

      succ_3 = true;
      if (!UTIL.equals(new Boolean(true), new Boolean(t instanceof IOmlTypeName))) 
        succ_3 = false;
      if (succ_3) {

        IOmlTypeName a = (IOmlTypeName) t;
        String arg_56 = null;
        IOmlName obj_57 = null;
        obj_57 = (IOmlName) a.getName();
        arg_56 = obj_57.getIdentifier();
        varRes_2 = new UmlClassNameType(arg_56);
      }
    }
    if (!succ_3) 
      varRes_2 = null;
    return (IUmlType) varRes_2;
  }
// ***** VDMTOOLS END Name=convertType#1|IOmlType


// ***** VDMTOOLS START Name=convertPropertyType#2|IOmlType|String KEEP=NO
  static public IUmlType convertPropertyType (final IOmlType t, final String owner) throws CGException {

    Object varRes_3 = null;
    {

      IUmlType ty = (IUmlType) (IUmlType) convertType((IOmlType) t);
      if (new Boolean(UTIL.equals(ty, null)).booleanValue()) 
        varRes_3 = new UmlClassNameType(owner);
      else 
        varRes_3 = ty;
    }
    return (IUmlType) varRes_3;
  }
// ***** VDMTOOLS END Name=convertPropertyType#2|IOmlType|String

}
;
