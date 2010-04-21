import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
	Rectangle rect1, rect2;

	@Before
	public void setUp() throws Exception {
		rect1 = new Rectangle(new Point(2.0, 2.0), new Point(4.0, 7.0));
		rect2 = new Rectangle(new Point(2.0, 6.0), new Point(4.0, 3.0));
	}

	@Test
	public void testGetArea() {
		assertEquals(10.0, rect1.getArea(),0.001);
		assertEquals(6.0, rect2.getArea(),0.001);
	}

	@Test
	public void testGetDiagonal() {
		assertEquals(5.3852, rect1.getDiagonal(), 0.0001);
		assertEquals(3.6056, rect2.getDiagonal(), 0.0001);
	}
}
