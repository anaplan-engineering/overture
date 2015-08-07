package project;

import org.overture.codegen.runtime.*;

import java.util.*;


//@ nullable_by_default
@SuppressWarnings("all")
final public class Entry {
    /*@ public ghost static boolean invChecksOn = true; @*/
    private Entry() {
    }

    public static Object Run() {
        IO.println("Before useOk");

        {
            Number ignorePattern_1 = useOk();

            /* skip */
        }

        IO.println("After useOk");
        IO.println("Before useNotOk");

        {
            Number ignorePattern_2 = useNotOk();

            /* skip */
        }

        IO.println("After useNotOk");

        return 0L;
    }

    public static Number useOk() {
        project.Entrytypes.R1 r1 = new project.Entrytypes.R1(new project.Entrytypes.R2(
                    new project.Entrytypes.R3(new project.Entrytypes.R4(5L))));
        Number atomicTmp_1 = 10L;

        Number atomicTmp_2 = 5L;

        { /* Start of atomic statement */

            //@ set invChecksOn = false;
            project.Entrytypes.R2 stateDes_1 = r1.get_r2();

            project.Entrytypes.R3 stateDes_2 = stateDes_1.get_t3();

            project.Entrytypes.R4 stateDes_3 = stateDes_2.get_r4();

            stateDes_3.set_x(atomicTmp_1);

            project.Entrytypes.R2 stateDes_4 = r1.get_r2();

            project.Entrytypes.R3 stateDes_5 = stateDes_4.get_t3();

            project.Entrytypes.R4 stateDes_6 = stateDes_5.get_r4();

            stateDes_6.set_x(atomicTmp_2);

            //@ set invChecksOn = true;

            //@ assert stateDes_3.valid();

            //@ assert stateDes_2.valid();
            //@ assert inv_Entry_T3(stateDes_2);

            //@ assert stateDes_1.valid();

            //@ assert r1.valid();

            //@ assert stateDes_6.valid();

            //@ assert stateDes_5.valid();
            //@ assert inv_Entry_T3(stateDes_5);

            //@ assert stateDes_4.valid();
        } /* End of atomic statement */
        return 0L;
    }

    public static Number useNotOk() {
        project.Entrytypes.R1 r1 = new project.Entrytypes.R1(new project.Entrytypes.R2(
                    new project.Entrytypes.R3(new project.Entrytypes.R4(5L))));
        Number atomicTmp_3 = 10L;

        { /* Start of atomic statement */

            //@ set invChecksOn = false;
            project.Entrytypes.R2 stateDes_7 = r1.get_r2();

            project.Entrytypes.R3 stateDes_8 = stateDes_7.get_t3();

            project.Entrytypes.R4 stateDes_9 = stateDes_8.get_r4();

            stateDes_9.set_x(atomicTmp_3);

            //@ set invChecksOn = true;

            //@ assert stateDes_9.valid();

            //@ assert stateDes_8.valid();
            //@ assert inv_Entry_T3(stateDes_8);

            //@ assert stateDes_7.valid();

            //@ assert r1.valid();
        } /* End of atomic statement */
        return 0L;
    }

    public String toString() {
        return "Entry{}";
    }

    /*@ pure @*/
    /*@ helper @*/
    public static Boolean inv_Entry_T3(final Object check_t3) {
        if ((Utils.equals(check_t3, null)) ||
                !(Utils.is_(check_t3, project.Entrytypes.R3.class))) {
            return false;
        }

        project.Entrytypes.R3 t3 = ((project.Entrytypes.R3) check_t3);

        return !(Utils.equals(t3.get_r4().get_x(), 10L));
    }
}
