package by.krukouski.triangle.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.krukouski.triangle.exception.InvalidTriangleException;
import by.krukouski.triangle.figure.Triangle;
import by.krukouski.triangle.fileoperation.StringParser;
import by.krukouski.triangle.fileoperation.StringReader;

@RunWith(Parameterized.class)
public class RightTriangleTest {
	private String testData; 
	
	public RightTriangleTest(String testData) {
		this.testData = testData;
	}
	
	@Parameters
	public static ArrayList<String> generateTestData() throws IOException {  
		return StringReader.readFile(new File("resource/RightTriangleTest.txt"));
	}
	
	@Test
	public void Triangle() {
		Triangle triangle ;
		
		double expected;
		double actual;
		
		try {	    	
			triangle = StringParser.buildTriangle(testData);
	    	
	    	expected = Math.hypot(triangle.getSideOne().defineLength(), triangle.getSideTwo().defineLength());
	    	actual = triangle.getSideThree().defineLength();
	    	
	    	Assert.assertEquals(expected, actual, 0.01);
	    } catch(InvalidTriangleException e) {
	    	fail(e.getMessage());
	    }
	}
}