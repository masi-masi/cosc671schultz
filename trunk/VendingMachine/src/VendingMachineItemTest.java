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
		/* Test: if item is uninitialized item is null 
		 * EO: item is null
		 */
		assertNull(item);
		
		/* Test: Use the constructor to create new VendingMachineItems and verify the 
		 *       name and price of the new VendingMachineItems are correct.
		 * EO: "Coca-Cola" is new VendingMachineItem name
		 *     $1.25 is new VendingMachineItem price
		 */
		assertEquals("Coca-Cola", new VendingMachineItem("Coca-Cola", 1.25).getName());
		assertEquals(1.25, new VendingMachineItem("Coca-Cola", 1.25).getPrice());
		
		/* Test: Initialize item with name ("Coca-Cola") and price (1.25) with constructor
		 *       and calling getName() and getPrice() after item is initialized .
		 * EO: item not null
		 *     item name = "Coca-Cola"
		 *     item price = $1.25
		 */
		item = new VendingMachineItem("Coca-Cola", 1.25);
		assertNotNull(item);
		assertEquals("Coca-Cola", item.getName());
		assertEquals(1.25, item.getPrice());
		
		/* Test: Initialize item with name ("Coca-Cola") and price (0.00) with constructor
		 *       calling getPrice to verify correct price after item is initialized.
		 * EO: item is not null
		 *     item price = $0.00
		 */
		// initialize item with string and double = 0
		item = new VendingMachineItem("Coca-Cola", 0.00);
		assertNotNull(item);
		assertEquals(0.00, item.getPrice());
		
		/* Test: Initialize item with name ("Coca-Cola") and price (-.50) with constructor
		 *       calling getPrice to verify correct price after item is initialized
		 * EO: Throws VendingMachineException
		 */
		/* verify if item is null, a NullPointerException is thrown */
		try {
			item = new VendingMachineItem("Coca-Cola", -0.50);
		} catch (VendingMachineException npe) {
			return;
		}
		fail("Expected VendingMachineException");
		
		/* Test: Initialize item with name (" ") and price (1.00) with contstructor
		 *       calling getName to verify correct name after item is initialized
		 * EO: item is not null
		 *     item name is " "
		 */
		item = new VendingMachineItem(" ", 1.00);
		assertNotNull(item);
		assertEquals(" ", item.getName());
		
		/* Test: Initialize item with name ("") and price (1.00) with constructor 
		 *       calling getName to verify correct name after item is initialized
		 * EO: item is not null
		 *     item name is ""
		 */
		item = new VendingMachineItem("", 1.00);
		assertNotNull(item);
		assertEquals("", item.getName());
		
		/* Test: Initialize item with name (null) and price (1.00) with constructor
		 *       calling getName to verify correct name after item is initialized
		 * EO: item is not null
		 *     item name is null
		 */
		item = new VendingMachineItem(null, 1.00);
		assertNotNull(item);
		assertNull(item.getName());
	}

	/**
	 * Test method for {@link VendingMachineItem#getName()}.
	 */
	public void testGetName() {
		/* Test: Verify that if item is null a NullPointerException is thrown
		 *       when getName() is called
		 * EO: item is null
		 *     Throw NullPointerException
		 */
		/* verify if item is null, a NullPointerException is thrown */
		assertNull(item);
		try {
			assertNull(item.getName());
		} catch (NullPointerException npe) {
			return;
		}
		fail("Expected NullPointerException");
		
		/* Test: Verify that if item name is set to "Coca-Cola" with constructor
		 *       item name is "Coca-Cola"
		 * EO: item is not null
		 *     item name is "Coca-Cola"
		 */
		item =  new VendingMachineItem("Coca-Cola", 1.25);
		assertNotNull(item);
		assertEquals("Coca-Cola", item.getName());
		
		/* Test: Verify that if item name is set to " " with constructor 
		 *       item name is " "
		 * EO: item is not null
		 *     item name is " "
		 */
		item = new VendingMachineItem(" ", 1.00);
		assertNotNull(item);
		assertEquals(" ", item.getName());
		
		/* Test: Verify that if item name is set to "" with constructor
		 *       item name is ""
		 * EO: item is not null
		 *     item name is ""
		 */
		item = new VendingMachineItem("", 1.00);
		assertNotNull(item);
		assertEquals("", item.getName());
		
		/* Test: Verify that if item name is set to null with constructor
		 *       item name is null
		 * EO: item is not null
		 *     item name is null
		 */
		item = new VendingMachineItem(null, 1.00);
		assertNotNull(item);
		assertNull(item.getName());
	}

	/**
	 * Test method for {@link VendingMachineItem#getPrice()}.
	 */
	public void testGetPrice() {
		/* Test: Verify that if item is null a NullPointerException is thrown
		 *       when getPrice() is called.
		 * EO: item is null
		 *     Throw NullPointerException
		 */
		assertNull(item);
		try {
			assertNull(item.getPrice());
		} catch (NullPointerException npe) {
			return;
		}
		fail("Expected NullPointerException");
		
		/* Test: Verify that if item price is set to 1.25 with constructor
		 *       item price is 1.25
		 * EO: item is not null
		 *     item price is $1.25
		 */
		item = new VendingMachineItem("Coca-Cola", 1.25);
		assertNotNull(item);
		assertEquals(1.25, item.getPrice());
		
		/* Test: Verify that if item price is set to 0.00 with constructor
		 *       item price is $0.00
		 * EO: item is not null
		 *     item price = $0.00
		 */
		item = new VendingMachineItem("Coca-Cola", 0.00);
		assertNotNull(item);
		assertEquals(0.00, item.getPrice());
		
		/* Test: Verify that if item price is set to -0.50 with constructor
		 *       a VendingMachineException is thrown.
		 * EO: Throws VendingMachineException
		 */
		try {
			item = new VendingMachineItem("Coca-Cola", -0.50);
		} catch (VendingMachineException npe) {
			return;
		}
		fail("Expected VendingMachineException");
	}

}
