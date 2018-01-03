package app;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class KlasseTest {

	private Klasse klasse;

	@Before
	public void setUp() throws Exception {

		klasse = new Klasse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMaxIntInt() {
		int result = klasse.max(3, 5);
		assertEquals(5, result);
		assertNotEquals(42, result);

	}

	@Test
	public void testMaxIntArray() {
		int[] arr = { 45, 1, 23, 2, -44, 0, 2222, 76 };
		int result = klasse.max(arr);
		assertEquals(2222, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMethodeMItException() {
		klasse.methodeMItException(0);// Exception auslösen

	}

	@Test(timeout = 100) // Maximal 100 Millisekunden darf die Methode laufen
	public void testDauertZeit() {
		klasse.dauertZeit();
	}


	@Test(expected = NullPointerException.class)
	public void testCreateComponent() {
		JComponent c = klasse.createComponent("b");
		assertTrue(c instanceof JButton);
		
		JComponent c2 = klasse.createComponent("xyz");
		assertTrue(c2 instanceof JLabel);
	
		JComponent c3 = klasse.createComponent(null);
		
	}

	@Test
	public void testXYZ() {
		try {
			// code...
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	@Test
	public void testNochWas(){
		int n = klasse.max(3,5);
		if (n < 100) {
			assertTrue(true);
		} else {
			fail();
		}
	}
	
}
