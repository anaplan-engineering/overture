package jp.co.csk.vdm.toolbox.api.corba.VDM;

/**
* jp/co/csk/vdm/toolbox/api/corba/VDM/VDMMapHolder.java .
* IDL-to-Java コンパイラ (ポータブル), バージョン "3.1" で生成
* 生成元: metaiv_idl.idl
* 2009年3月16日 10時22分52秒 JST
*/

public final class VDMMapHolder implements org.omg.CORBA.portable.Streamable
{
  public jp.co.csk.vdm.toolbox.api.corba.VDM.VDMMap value = null;

  public VDMMapHolder ()
  {
  }

  public VDMMapHolder (jp.co.csk.vdm.toolbox.api.corba.VDM.VDMMap initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = jp.co.csk.vdm.toolbox.api.corba.VDM.VDMMapHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    jp.co.csk.vdm.toolbox.api.corba.VDM.VDMMapHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return jp.co.csk.vdm.toolbox.api.corba.VDM.VDMMapHelper.type ();
  }

}
