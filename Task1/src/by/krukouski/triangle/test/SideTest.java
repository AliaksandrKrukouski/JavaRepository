package by.krukouski.triangle.test;

import org.junit.Assert;
import org.junit.Test;

import by.krukouski.triangle.figure.Point;
import by.krukouski.triangle.figure.Side;

public class SideTest {	
	@Test
	public void defineLengthTest() {
		Point pointOne = new  Point(-1, 3);
		Point pointTwo = new Point(2, -1);
		
		Side side = new Side(pointOne, pointTwo); 
		
		double expected = 5;
		double actual = side.defineLength();
		
		Assert.assertEquals(expected, actual, 0.01); 
	}

}