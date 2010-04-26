import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author Tara Schultz
 *
 */
public class VendingMachineTest extends TestCase {
	
	VendingMachine machine;
	VendingMachineItem item;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		machine = new VendingMachine();
		item = new VendingMachineItem("Coca-Cola", 1.25);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		
		machine = null;
		item = null;
	}

	/**
	 * Test method for {@link VendingMachine#addItem(VendingMachineItem, java.lang.String)}.
	 */
	public void testAddItem() {
		/* Test: Slot code A is empty, add item to slot A
		 * EO: Item is at slot code A
		 */
		assertEquals(null, machine.getItem(VendingMachine.A_CODE));
		machine.addItem(item, VendingMachine.A_CODE);
		assertSame(item, machine.getItem(VendingMachine.A_CODE));
		
		/* Test: Slot code B is empty, add null item to slot B
		 * EO: Null is at slot code B (B is empty)
		 */
		machine.addItem(null, VendingMachine.B_CODE);
		assertNull(machine.getItem(VendingMachine.B_CODE));
		
		/* Test: Slot code A is occupied, add item to slot A
		 * EO: VendingMachineException thrown
		 */
		try {
			machine.addItem(new VendingMachineItem("Pepsi", 1.00), VendingMachine.A_CODE);
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Slot A already occupied");
		
		/* Test: Slot code F is not valid.
		 * EO: VendingMahcineException thrown
		 */
		try {
			machine.addItem(item, "F");
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Slot F is invalid");
	}

	/**
	 * Test method for {@link VendingMachine#removeItem(java.lang.String)}.
	 */
	public void testRemoveItem() {
		/*
		 * Test: Remove item from empty slot B
		 * EO: VendingMachineException thrown
		 */
		assertNull(machine.getItem(VendingMachine.B_CODE));
		try {
			machine.removeItem(VendingMachine.B_CODE);
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Slot B is empty");
		
		/*
		 * Test: Remove item from invalid slot F
		 * EO: VendingMachineException thrown
		 */
		try {
			machine.removeItem("F");
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Slot F is invalid");
		
		/*
		 * Test: Remove item from valid occupied slot A
		 * EO: item removed from slot A (slot A empty)
		 */
		machine.addItem(item, VendingMachine.A_CODE);
		assertNotNull(machine.getItem(VendingMachine.A_CODE));
		machine.removeItem(VendingMachine.A_CODE);
		assertNull(machine.getItem(VendingMachine.A_CODE));
	}

	/**
	 * Test method for {@link VendingMachine#insertMoney(double)}.
	 */
	public void testInsertMoney() {
		/*
		 * Test: Insert money with amount less than zero
		 * EO: VendingMachineException thrown
		 */
		try {
			machine.insertMoney(-.50);
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Amount less than 0");
		
		/*
		 * Test: Insert money with amount 0.00, initial balance is 0
		 * EO: balance is 0.00
		 */
		assertEquals(0.00, machine.getBalance());
		machine.insertMoney(0.00);
		assertEquals(0.00, machine.getBalance());
		
		/*
		 * Test: Insert money with amount 5.75, initial balance is 0
		 * EO: balance is 5.75
		 */
		assertEquals(0.00, machine.getBalance());
		machine.insertMoney(5.75);
		assertEquals(5.75, machine.getBalance());
		
		/*
		 * Test: Insert money with amount 0.00, initial balance is 5.75
		 * EO: balance is 5.75
		 */
		assertEquals(5.75, machine.getBalance());
		machine.insertMoney(0.00);
		assertEquals(5.75, machine.getBalance());
		
		/*
		 * Test: Insert money with amount 0.00, initial balance is -.4.00
		 * EO: VendingMachineException thrown
		 */
		machine.balance = -4.00;
		machine.insertMoney(0.00);
		try {
			machine.getBalance();
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Balance is less than zero");
		
		/*
		 * Test: Insert money with amount 1.00, initial balance is 5.75
		 * EO: balance is 6.75
		 */
		machine.balance = 5.75;
		assertEquals(5.75, machine.getBalance());
		machine.insertMoney(1.00);
		assertEquals(6.75, machine.getBalance());

		/*
		 * Test: Insert money with amount 1.00, initial balance is -3.00
		 * EO: VendingMachineException thrown (balance should not be less than 0)
		 */		
		machine.balance = -3.00;
		try {
			machine.insertMoney(1.00);
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Balance is less than zero");
	}

	/**
	 * Test method for {@link VendingMachine#getBalance()}.
	 */
	public void testGetBalance() {
		/*
		 * Test: Vending machine balance starts with 0.00
		 * EO: balance is 0.00
		 */
		assertEquals(0.00, machine.getBalance());
		
		/*
		 * Test: Get balance when balance is 5.00 (greater than 0)
		 * EO: balance is 5.00
		 */
		machine.balance = 5.00;
		assertEquals(5.00, machine.balance);
		assertEquals(machine.balance, machine.getBalance());
		
		/*
		 * Test: Get balance when balance is 0.00
		 * EO: balance is 0.00
		 */
		machine.balance = 0.00;
		assertEquals(0.00, machine.balance);
		assertEquals(machine.balance, machine.getBalance());
		
		/*
		 * Test: Get balance when balance is -3.25 (less than 0)
		 * EO: VendingMachineException thrown (balance should not be less than 0)
		 */
		machine.balance = -3.25;
		try {
			double balance = machine.getBalance();
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Balance is less than 0");
	}

	/**
	 * Test method for {@link VendingMachine#makePurchase(java.lang.String)}.
	 */
	public void testMakePurchase() {
		/*
		 * Test: Make purchase from occupied slot A, balance is 2.00
		 * EO: return true
		 *     balance is .75
		 *     item at slot A is null
		 */
		machine.addItem(item, VendingMachine.A_CODE);
		machine.balance = 2.00;
		assertTrue(machine.makePurchase(VendingMachine.A_CODE));
		assertNull(machine.getItem(VendingMachine.A_CODE));
		assertEquals(.75, machine.getBalance());
		
		/*
		 * Test: Make purchase from unoccupied slot A, balance is 2.00
		 * EO: return false
		 *     balance is 2.00
		 *     item at slot A is null
		 */
		machine.balance = 2.00;
		assertFalse(machine.makePurchase(VendingMachine.A_CODE));
		assertNull(machine.getItem(VendingMachine.A_CODE));
		assertEquals(2.00, machine.getBalance());
		
		
		/*
		 * Test: Make purchase from occupied slot B, balance is 1.00
		 * EO: return false
		 *     balance is 1.00
		 *     item at slot B is null
		 */
		machine.balance = 1.00;
		machine.addItem(item, VendingMachine.B_CODE);
		assertFalse(machine.makePurchase(VendingMachine.B_CODE));
		
		/*
		 * Test: Make purchase from unoccupied slot, balance is 1.00
		 * EO: return false
		 *     balance is 1.00
		 */
	}

	/**
	 * Test method for {@link VendingMachine#returnChange()}.
	 */
	public void testReturnChange() {
		/*
		 * Test: Return change when purchasing 1.25 item with balance of 2.50
		 * EO: return change 1.25
		 */
		machine.balance = 2.50;
		machine.addItem(item, VendingMachine.A_CODE);
		machine.makePurchase(VendingMachine.A_CODE);
		assertEquals(1.25, machine.returnChange());
		
		/*
		 * Test: Return change when purchasing 1.25 item with balance of 1.00
		 * EO: return change 1.00
		 */
		machine.balance = 1.00;
		machine.addItem(item, VendingMachine.A_CODE);
		machine.makePurchase(VendingMachine.A_CODE);
		assertEquals(1.00, machine.returnChange());
		
		/*
		 * Test: Return change when purchasing 1.25 item with balance of -2.00
		 * EO: throw VendingMachineException can't return balance change of -2.00
		 */
		machine.balance = -2.00;
		try {
			machine.makePurchase(VendingMachine.A_CODE);
		} catch (VendingMachineException vme) {
			return;
		}
		fail("Expected VendingMachineException - Cannot return negative change");
		
	}
}
