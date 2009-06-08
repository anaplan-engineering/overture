/**
 * 
 */
package org.overturetool.potrans.external_tools;

import org.overturetool.potrans.external_tools.ConsoleProcessInputText;

import junit.framework.TestCase;

/**
 * @author gentux
 *
 */
public class CommandLineProcessStringInputTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.overturetool.potrans.external_tools.ConsoleProcessInputText#CommandLineProcessStringInput(java.lang.String)}.
	 */
	public void testCommandLineProcessStringInput() {
		String expected = "test string";
		ConsoleProcessInputText stringInput = new ConsoleProcessInputText(expected);
		
		assertEquals(expected, stringInput.input);
	}

	/**
	 * Test method for {@link org.overturetool.potrans.external_tools.ConsoleProcessInputText#getBytes()}.
	 */
	public void testGetBytes() {
		String testString = "test string";
		ConsoleProcessInputText stringInput = new ConsoleProcessInputText(testString);
		byte[] expected = testString.getBytes();
		byte[] actual = stringInput.getBytes();
		
		assertEquals(expected.length, actual.length);
		for(int i = 0; i < expected.length; i++)
			assertEquals(expected[i], actual[i]);
	}

	/**
	 * Test method for {@link org.overturetool.potrans.external_tools.ConsoleProcessInputText#isStatic()}.
	 */
	public void testIsStatic() {
		String expected = "test string";
		ConsoleProcessInputText stringInput = new ConsoleProcessInputText(expected);
		
		assertTrue(stringInput.isStatic());
	}

	/**
	 * Test method for {@link org.overturetool.potrans.external_tools.ConsoleProcessInputText#getText()}.
	 */
	public void testGetText() throws Exception {
		String expected = "test string";
		ConsoleProcessInputText stringInput = new ConsoleProcessInputText(expected);
		
		assertEquals(expected, stringInput.getText());
	}

}
