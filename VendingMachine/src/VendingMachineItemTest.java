import junit.framework.TestCase;

/**
 * @author Tara Schultz
 *
 */
public class VendingMachineItemTest extends TestCase {
	
	VendingMachineItem item;

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
		item = null;
	}

	/**
	 * Test method for {@link VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	public void testVendingMachineItem() {
		// initialize item with null 
		item = null;
		assertNull(item);
		
		// initialize item with string and double calling constructor 
		item = new VendingMachineItem("Coca-Cola", 1.25);
		assertNotNull(item);
		// item name is set correctly
		assertEquals("Coca-Cola", new VendingMachineItem("Coca-Cola", 1.25).getName());
		// item price is set correctly
		assertEquals(1.25, new VendingMachineItem("Coca-Cola", 1.25).getPrice());
	}

	/**
	 * Test method for {@link VendingMachineItem#getName()}.
	 */
	public void testGetName() {
		/* verify if item is null, a NullPointerException is thrown */
		try {
			assertNull(item.getName());
		} catch (NullPointerException npe) {
			return;
		}
		fail("Expected NullPointerException");
		
		/* initialize item using constructor then call getName() */
		item =  new VendingMachineItem("Coca-Cola", 1.25);
		assertEquals("Coca-Cola", item.getName());
	}

	/**
	 * Test method for {@link VendingMachineItem#getPrice()}.
	 */
	public void testGetPrice() {
		/* verify if item is null, a NullPointerException is thrown */
		try {
			assertNull(item.getPrice());
		} catch (NullPointerException npe) {
			return;
		}
		fail("Expected NullPointerException");
		
		/* initialize item using constructor then call getPrice() */
		item = new VendingMachineItem("Coca-Cola", 1.25);
		assertEquals(1.25, item.getPrice());
	}

}
