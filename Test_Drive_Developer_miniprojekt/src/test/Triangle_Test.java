package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import triangle.Triangle;

class Triangle_Test {
	
	private final InputStream originalIn = System.in;

	@Test
	@DisplayName("Test if a  triangle with equal sides is identified as Equilateral")
	void testTriangleIntIntInt() {
		Triangle equilateral = new Triangle(1,1,1);
		assertEquals(Triangle.TYPE.EQUILATERAL, equilateral.getCurrent_type(), "Equilateral triangle test failed");
		
		Triangle scalene = new Triangle(3,4,5);
	    assertEquals(Triangle.TYPE.SCALENE, scalene.getCurrent_type(), "Scalene triangle test failed");
	    

		Triangle isosceles = new Triangle(5,5,8);
		assertEquals(Triangle.TYPE.ISOSCELES, isosceles.getCurrent_type(), "sosceles triangle test failed");
		
		Triangle almostInvalid = new Triangle(2, 2, 3);
	    assertEquals(Triangle.TYPE.ISOSCELES, almostInvalid.getCurrent_type(), "Almost invalid triangle should be isosceles");

	    // Extrema värden
	    Triangle largeTriangle = new Triangle(1000, 1000, 1000);
	    assertEquals(Triangle.TYPE.EQUILATERAL, largeTriangle.getCurrent_type(), "Large equilateral triangle test failed");
	}
	   
	    
	 
	

	@Test
	@DisplayName("Test if a trianle is corrently identified from string array input")
	void testTriangleStringArray() {
		Triangle isosceles = new Triangle(new String[] {"2", "2", "3"});
		assertEquals(Triangle.TYPE.ISOSCELES, isosceles.getCurrent_type(), "Isosceles triangle test failed");
		
		
		Triangle equilateral = new Triangle(new String[] {"1", "1","1"});
		assertEquals(Triangle.TYPE.EQUILATERAL, equilateral.getCurrent_type(), "Equilateral triangle failed");
		
		
		Triangle scalene = new Triangle(new String[] {"2", "4", "5"});
		assertEquals(Triangle.TYPE.SCALENE, scalene.getCurrent_type(), " Scalene triangle failed");
		
	}

	@Test
	@DisplayName("Test the default constructor and setCurrent_type method")
	void testTriangle() {
	    Triangle triangle = new Triangle();
	    assertNull(triangle.getCurrent_type(), "Default constructor test failed");
	    
	    // Testa setCurrent_type med giltiga värden
	    triangle.setCurrent_type(3, 3, 3);
	    assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type(), "Triangle should be equilateral");
	    
	    // Testa setCurrent_type med felaktiga värden
	    triangle.setCurrent_type(-1, 3, 3);
	    assertNull(triangle.getCurrent_type(), "Triangle with negative side should be invalid");
	    
	    // Test setCurrent_type med ogiltig triangel
	    triangle.setCurrent_type(1, 2, 3);
	    assertNull(triangle.getCurrent_type(), "Triangle with sides 1, 2, 3 should be invalid");
	    
	    // Testa toString-metoden
	    String expectedToString = "3, 3, 3, This is a Equilateral triangle";
	    triangle.setCurrent_type(3, 3, 3);
	    assertEquals(expectedToString, triangle.toString(), "toString should describe an equilateral triangle");
	}
	
	
	@BeforeEach
	void setUpInput() {
		String simulatedInput = "3,4,5";
		System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
		
	}
	
	@AfterEach
	void restoreInput() {
		System.setIn(originalIn);
	}


	@Test
	@DisplayName("Test user input processing")
	void testGetUserInput() {
	    //String input = "3\n4\n5\n";
		//InputStream orginalIn = System.in;
		//System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		Triangle triangle = new Triangle();
		triangle.getUserInput();
		
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type(), "getUserInput should correctly identify a scalene triangle");
		
		//System.setIn(orginalIn);
		
	}
	
	@Test
	void testGetUserInputInvalidInput() {
	    String invalidInput = "a\nb\nc\n";
	    InputStream originalIn = System.in;
	    System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

	    Triangle triangle = new Triangle();
	    triangle.getUserInput();

	    // Kontrollera att triangeln inte är giltig eller hanterar input på förväntat sätt
	    assertNull(triangle.getCurrent_type(), "getUserInput should handle invalid input correctly");

	    System.setIn(originalIn);
	}

	@Test
	void testSetCurrent_type() {
		Triangle equilateral = new Triangle();
		equilateral.setCurrent_type(2, 2, 2);
		assertEquals(Triangle.TYPE.EQUILATERAL, equilateral.getCurrent_type(), "setCurrent_type test failed");
		
		Triangle isosceles = new Triangle();
		isosceles.setCurrent_type(2,2,3);
		assertEquals(Triangle.TYPE.ISOSCELES, isosceles.getCurrent_type(), "Isosceles triangle test failed");
		
		Triangle scalene = new Triangle();
		scalene.setCurrent_type(2, 3, 4);
		assertEquals(Triangle.TYPE.SCALENE, scalene.getCurrent_type(), "Scalene trinagle test failed");
		
		Triangle triangle1 = new Triangle();
		triangle1.setCurrent_type(1, 2, 3);
		assertNull(triangle1.getCurrent_type(), "Invalid triangle test failed");
		
		
		Triangle triangle2 = new Triangle();
		triangle2.setCurrent_type(-1, 2, 2);
		assertNull(triangle2.getCurrent_type(), "Triangle with negative sides should be invalid");
		
		
		Triangle triangle3 = new Triangle();
		triangle3.setCurrent_type(0, 2, 2);
		assertNull(triangle3.getCurrent_type(), "Triangle with a side of zero should be invalid");
	}

	@Test
	@DisplayName("Test setting current type of triangle with various inputs")
	void testGetCurrent_type() {
		Triangle scalene = new Triangle(3, 4, 5);
		assertEquals(Triangle.TYPE.SCALENE, scalene.getCurrent_type(), "getCurrent_type test failed");
		
		
		Triangle isosceles = new Triangle(2, 2, 3);
		assertEquals(Triangle.TYPE.ISOSCELES, isosceles.getCurrent_type(), "Isosceles triangles test failed");
		
		Triangle equilateral = new Triangle(3, 3, 3);
		assertEquals(Triangle.TYPE.EQUILATERAL, equilateral.getCurrent_type(), "Equilateral triangle test failed");
		
		Triangle invalid = new Triangle(1, 2, 3);
		assertNull(invalid.getCurrent_type(), "Invalid triangle test ");
		
		Triangle negative = new Triangle(-1, 2, 2);
		assertNull(negative.getCurrent_type(), "Triangle with negative sides");
		
		Triangle zeroSide = new Triangle(0, 2, 2);
		assertNull(zeroSide.getCurrent_type(), "Triangle with a side of zero should be invalid");
	}

	@Test
	@DisplayName("Test toString method for correct triangle description")
	void testToString() {
	    Triangle equilateral = new Triangle(1, 1, 1);
	    String expectedOutput = "1, 1, 1, This is a Equilateral triangle";
	    assertEquals(expectedOutput, equilateral.toString(), "toString test failed");
	    
	    Triangle isosceles = new Triangle(3, 3, 2);
	    String expectedToString1 = "3, 3, 2, This is a Isosceles triangle"; // Notera användningen av stor bokstav
	    assertEquals(expectedToString1, isosceles.toString(), "toString should describe an isosceles triangle");
	    
	    Triangle scalene = new Triangle(3, 4, 5);
	    String expectedToString2 = "3, 4, 5, This is a Scalene triangle"; // Notera användningen av stor bokstav
	    assertEquals(expectedToString2, scalene.toString(), "toString should describe a scalene triangle");
	    
	    Triangle invalid = new Triangle(1, 2, 3);
	    String expectedToString3 = "1, 2, 3, This is not a triangle"; // Notera användningen av stor bokstav
	    assertEquals(expectedToString3, invalid.toString(), "toString should describe an invalid triangle");
	}

	@Test
    @DisplayName("Test constructor with valid string array input")
    void testConstructorWithValidInput() {
        Triangle validTriangle = new Triangle(new String[] {"3", "4", "5"});
        assertEquals(Triangle.TYPE.SCALENE, validTriangle.getCurrent_type(), "Valid string array should create a scalene triangle");
    }

    @Test
    @DisplayName("Test constructor with invalid string array input (NumberFormatException)")
    void testConstructorWithInvalidInput() {
        Triangle invalidTriangle = new Triangle(new String[] {"a", "b", "c"});
        assertNull(invalidTriangle.getCurrent_type(), "Invalid string array should not set triangle type");
    }

    @Test
    @DisplayName("Test constructor with incorrect array length")
    void testConstructorWithIncorrectArrayLength() {
        Triangle shortArrayTriangle = new Triangle(new String[] {"3", "4"});
        assertNull(shortArrayTriangle.getCurrent_type(), "Array with incorrect length should not set triangle type");
    }

	@Test
	void testMain() {
		 // Test av main är vanligtvis inte nödvändigt
	}

}
