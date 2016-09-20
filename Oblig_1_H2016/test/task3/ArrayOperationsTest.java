package task3;

import static org.junit.Assert.assertEquals;
import static task3.ArrayOperations.min;

import org.junit.Test;

public class ArrayOperationsTest {

	@Test
	public void OneElement() {
		Integer[] intArr = {0};
		assertEquals(0, min(intArr), 0);
	}
	@Test
	public void SeveralElements() {
		Integer[] intArr = {3, 2, 5};
		assertEquals(2, min(intArr), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NullReference() throws IllegalArgumentException {
		String[] s = null;
		min(s);
	}
	@Test(expected = IllegalArgumentException.class)
	public void ZeroLength() throws IllegalArgumentException {
		String[] s = new String[0];
		min(s);
	}
	
	@Test
	public void NoInitializedElements() {
		String[] s = new String[2];
		//min(s);
		assertEquals(null, min(s)); //Should this return null?
	}
	@Test
	public void SomeNullElements() {
		Double[] dArr = {0.1, 0.0, null, 3.1, null};
		assertEquals(0.0, min(dArr), 0);
	}
	
	@Test
	public void OneCircle(){
		Circle[] cArr = {new Circle(1.3)};
		assertEquals(1.3, min(cArr).getRadius(), 0.0001);
	}
	@Test
	public void TwoCircles(){
		Circle[] cArr = {new Circle(1.3), new Circle(0.8)};
		assertEquals(0.8, min(cArr).getRadius(), 0.0001);
	}
}
