import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class MyMathTest {

	MyMath mm = new MyMath();
	
	// ------------------------------------------------------------------------------- //
	//
	// 1. Add two integer values and return the result.
	//
	//
	
	public static Stream<Arguments> addTestData(){
		return Stream.of(
				Arguments.of(0, 0, 0),
				Arguments.of(0, 1, 1),
				Arguments.of(0, 10, 10),
				Arguments.of(1, 0, 1),
				Arguments.of(10, 0, 10),
				Arguments.of(-1, 0, -1),
				Arguments.of(-10, 0, -10),
				Arguments.of(0, -1, -1),
				Arguments.of(0, -10, -10),
				Arguments.of(1, -1, 0),
				Arguments.of(10, -1, 9),
				Arguments.of(1, -10, -9),
				Arguments.of(-1, 1, 0),
				Arguments.of(-10, 1, -9),
				Arguments.of(-1, 10, 9)
				);
	}
	
	@ParameterizedTest(name = "{index} addTest {0} + {1} = {2}")
	@MethodSource("addTestData")
	void testAdd(int a, int b, int sum) {
		int expected = sum;
		int actual = mm.add(a, b);
		assertEquals(expected, actual);
	}

		
	// ------------------------------------------------------------------------------- //
	//
	// 2. Subtract two integer values and return the result.
	//
	//
		
	public static Stream<Arguments> subtractTestData(){
		return Stream.of(
			Arguments.of(0, 0, 0),
			Arguments.of(0, 1, -1),
			Arguments.of(0, 10, -10),
			Arguments.of(1, 0, 1),
			Arguments.of(10, 0, 10),
			Arguments.of(-1, 0, -1),
			Arguments.of(-10, 0, -10),
			Arguments.of(0, -1, 1),
			Arguments.of(0, -10, 10),
			Arguments.of(1, -1, 2),
			Arguments.of(10, -1, 11),
			Arguments.of(1, -10, 11),
			Arguments.of(-1, 1, -2),
			Arguments.of(-10, 1, -11),
			Arguments.of(-1, 10, -11)
		);
	}
	
	@ParameterizedTest(name = "{index} subtractTest {0} - {1} = {2}")
	@MethodSource("subtractTestData")
	void testSubtract(int a, int b, int difference) {
		int expected = difference;
		int actual = mm.substract(a, b);
		assertEquals(expected, actual);
	}

	

	// ------------------------------------------------------------------------------- //
	//
	// 3. Multiply two integer values and return the result.
	//
	//
	
	public static Stream<Arguments> multiplyTestData(){
		return Stream.of(
				Arguments.of(0, 0, 0),
				Arguments.of(1, 1, 1),
				Arguments.of(1, -1, -1),
				Arguments.of(-1, 1, -1),
				Arguments.of(-1, -1, 1),
				Arguments.of(1, 0, 0),
				Arguments.of(0, 1, 0),
				Arguments.of(-1, 0, 0),
				Arguments.of(0, -1, 0),
				Arguments.of(-10, 0, 0),
				Arguments.of(0, -10, 0),
				Arguments.of(1, -1, -1),
				Arguments.of(-1, 1, -1),
				Arguments.of(10, 1, 10),
				Arguments.of(10, -1, -10),
				Arguments.of(1, 10, 10),
				Arguments.of(-1, 10, -10),
				Arguments.of(1, -10, -10),
				Arguments.of(-1, -10, 10),
				Arguments.of(10, 10, 100),
				Arguments.of(-10, 10, -100),
				Arguments.of(10, -10, -100),
				Arguments.of(-10, -10, 100)
				);
	}
	
	@ParameterizedTest(name = "{index} multiplyTest {0} * {1} = {2}")
	@MethodSource("multiplyTestData")
	void testMultiply(int a, int b, int product) {
		int expected = product;
		int actual = mm.multiply(a, b);
		assertEquals(expected, actual);
	}
	
	// ------------------------------------------------------------------------------- //
	//
	// 4. Divide two integer values and return the result. Should throw an exception upon attempt at division by zero.
	//
	//
	
	public static Stream<Arguments> divideByZeroTestData() {
		return Stream.of(
				Arguments.of(0, 0),
				Arguments.of(1, 0),
				Arguments.of(-1, 0),
				Arguments.of(100, 0),
				Arguments.of(-100, 0)
				);
	}

	public static Stream<Arguments> divideTestData(){
		return Stream.of(
				// need to consider division by zero!!! test should catch this.
				Arguments.of(1, 1, 1),
				Arguments.of(1, -1, -1),
				Arguments.of(-1, 1, -1),
				Arguments.of(0, 1, 0),
				Arguments.of(0, 10, 0),
				Arguments.of(10, 1, 10),
				Arguments.of(10, -1, -10),
				Arguments.of(-10, 1, -10),
				Arguments.of(-10, -1, 10),
				Arguments.of(100, 10, 10),
				Arguments.of(100, -10, -10),
				Arguments.of(-100, 10, -10),
				Arguments.of(-100, -10, 10),
				Arguments.of(0, -1, (double)0/(double)-1),
				Arguments.of(0, -10, (double)0/(double)-10),
				Arguments.of(1, 10, (double)1/(double)10),
				Arguments.of(-1, 10, (double)-1 / (double)10),
				Arguments.of(1, -10, (double)1 / (double)-10),
				Arguments.of(-1, -10, (double)-1 / (double)-10),
				Arguments.of(1, 3, (double)1 / (double)3),
				Arguments.of(-1, 3, (double)-1 / (double)3),
				Arguments.of(1, -3, (double)1 / (double)-3),
				Arguments.of(-1, -3, (double)-1 / (double)-3)
				);
	}
	
	
	@ParameterizedTest(name = "{index} testDivisionByZeroExpectedException {0} / {1}}")
	@MethodSource("divideByZeroTestData")
	void testDivisionByZeroExpectedException(int a, int b) {
		// test division by zero. Method should throw an exception
		assertThrows(Exception.class, () -> {
			mm.divide(a,  b);
		});
	}
	
	@ParameterizedTest(name = "{index} divideTest {0} / {1} = {2}")
	@MethodSource("divideTestData")
	void testDivide(int a, int b) throws Exception {
//		double expected = divisor;
		double expected = (double)a / (double)b;
		double actual = mm.divide(a, b);
		assertEquals(expected, actual);
	}
	
	
	// ------------------------------------------------------------------------------- //
	//
	// 5. Return the product of two vectors as a new vector.
	//

	public static Stream<Arguments> incompatibleVectorData() {
		return Stream.of(
				Arguments.of(new int[] {1}, new int[] {1, 1}),
				Arguments.of(new int[] {1, 1}, new int[] {1}),
				Arguments.of(new int[] {1, 1}, new int[] {1, 1, 0}),
				Arguments.of(new int[] {1, 1, 0}, new int[] {1, 1}),
				Arguments.of(new int[] {0, 0, 1}, new int[] {1}),
				Arguments.of(new int[] {1}, new int[] {0, 0, 0})
				);
	}
	
	public static Stream<Arguments> vectorProductTestData(){
		return Stream.of(
				// i guess this test should also try and multiply vectors of non-matching dimensions
				Arguments.of(new int[] {0}, new int[] {0}, new int[] {0}),
				Arguments.of(new int[] {0}, new int[] {1}, new int[] {0}),
				Arguments.of(new int[] {1}, new int[] {1}, new int[] {1}),
				Arguments.of(new int[] {1}, new int[] {1}, new int[] {1}),
				Arguments.of(new int[] {0, 0}, new int[] {0, 0}, new int[] {0}),
				Arguments.of(new int[] {1, 0}, new int[] {0, 1}, new int[] {0}),
				Arguments.of(new int[] {0, 1}, new int[] {1, 0}, new int[] {0}),
				Arguments.of(new int[] {1, 1}, new int[] {1, 0}, new int[] {1}),
				Arguments.of(new int[] {1, 1}, new int[] {1, 1}, new int[] {2}),
				Arguments.of(new int[] {-1, 1}, new int[] {1, 1}, new int[] {0}),
				Arguments.of(new int[] {1, 1}, new int[] {-1, 1}, new int[] {0}),
				Arguments.of(new int[] {1, 1}, new int[] {1, -1}, new int[] {0}),
				Arguments.of(new int[] {1, -1}, new int[] {-1, 1}, new int[] {-2}),
				Arguments.of(new int[] {0, 0, 0}, new int[] {0, 0, 0}, new int[] {0}),
				Arguments.of(new int[] {0, 0, 1}, new int[] {1, 0, 0}, new int[] {0}),
				Arguments.of(new int[] {0, 1, 1}, new int[] {1, 1, 0}, new int[] {1}),
				Arguments.of(new int[] {1, 1, 1}, new int[] {1, 1, 1}, new int[] {3}),
				Arguments.of(new int[] {1, 1, 1}, new int[] {1, -1, 0}, new int[] {0}),
				Arguments.of(new int[] {-1, -1, 1}, new int[] {1, 1, 1}, new int[] {-1}),
				Arguments.of(new int[] {-1, -1, -1}, new int[] {1, 1, 1}, new int[] {-3}),
				Arguments.of(new int[] {-1, -1, -1}, new int[] {-1, -1, -1}, new int[] {3}),
				Arguments.of(new int[] {10, 1, 1}, new int[] {1, -1, 0}, new int[] {9}),
				Arguments.of(new int[] {10, 1, 1}, new int[] {-1, -1, 0}, new int[] {-11}),
				Arguments.of(new int[] {1, 10, 1}, new int[] {1, -10, 0}, new int[] {-99}),
				Arguments.of(new int[] {1, 10, 1}, new int[] {-1, -10, 0}, new int[] {-101})
				);
	}
	
	@ParameterizedTest(name = "{index} testVectorProductExpectedException {0} . {1}}")
	@MethodSource("incompatibleVectorData")
	void testVectorProductExpectedException(int[] vector1, int[] vector2) {
		// attempt to compute the product of vectors of incompatible dimensions.
		assertThrows(Exception.class, () -> {
			mm.vectorProduct(vector1, vector2);
		});
	}
	
	@ParameterizedTest(name = "{index} vectorProductTest {0} . {1} = {2}")
	@MethodSource("vectorProductTestData")
	void testVectorProduct(int[] vector1, int[] vector2, int[] product) throws Exception {
		int[] expected = product;
		int[] actual = mm.vectorProduct(vector1, vector2);
		assertArrayEquals(expected, actual);
	}
	
	
	// ------------------------------------------------------------------------------- //
	//
	//
	// 6. Return the product of a matrix and a vector.
	// 
	//
	
	// same here for incompatible sizes. need to test the exception gets thrown
	public static Stream<Arguments> incompatibleMatrixVectorProductData() {
		return Stream.of(
				Arguments.of(
						new int[][] {{1, 1}, {1, 1}, {1, 1}},
						new int[] {1}
						),
				Arguments.of(
						new int[][] {{0, 0}, {0, 0}, {0, 0}},
						new int[] {0, 0, 0}
						),
				Arguments.of(
						new int[][] {{1, 1}, {1, 1}, {1, 1}, {1, 1}},
						new int[] {1, 1, 1, 1}
						),
				Arguments.of(
						new int[][] {{1, 1, 0}, {1, 0, 0}},
						new int[] {1, 0}
						),
				Arguments.of(
						new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
						new int[] {1, 0, 0, 1}
						)
				);
	}
	
	public static Stream<Arguments> matrixVectorProductTestData(){
		return Stream.of(
				Arguments.of(
						new int[][] {{0, 0}, {0, 0}, {0, 0}},
						new int[] {0, 0},
						new int[] {0, 0, 0}
						),
				Arguments.of(
						new int[][] {{1, 0}, {0, 1}},
						new int[] {1, 2},
						new int[] {1, 2}
						),
				Arguments.of(
						new int[][] {{-2, 0}, {0, -2}},
						new int[] {1, 5},
						new int[] {-2, -10}
						),
				Arguments.of(
						new int[][] {{1, 1}, {1, 1}, {1, 1}},
						new int[] {1, 1},
						new int[] {2, 2, 2}
						),
				Arguments.of(
						new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},
						new int[] {1, -1, 10},
						new int[] {1, -1, 10}
						),
				Arguments.of(
						new int[][] {{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}},
						new int[] {1, -1, 10},
						new int[] {-1, 1, -10}
						),
				Arguments.of(
						new int[][] {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}},
						new int[] {1, -1, 10},
						new int[] {10, -1, 1}
						),
				Arguments.of(
						new int[][] {{0, 0, 1, 0}, {0, 1, 0, 0}, {1, 0, 0, 0}},
						new int[] {1, -1, 10, 0},
						new int[] {10, -1, 1}
						)
				);
	}
		
		@ParameterizedTest(name = "{index} testMatrixVectorProductExpectedException {0} * {1}}")
		@MethodSource("incompatibleMatrixVectorProductData")
		void testMatrixVectorProductExpectedException(int[][] matrix, int[] vector) {
			// attempt to compute the product of a matrix and vector of incompatible dimensions.
			assertThrows(Exception.class, () -> {
				mm.matrixVectorProduct(matrix, vector);
			});
		}
		
		@ParameterizedTest(name = "{index} matrixVectorProductTest {0} * {1} = {2}")
		@MethodSource("matrixVectorProductTestData")
		void testMatrixVectorProduct(int[][] matrix, int[] vector, int[] product) throws Exception {
			int[] expected = product;
			int[] actual = mm.matrixVectorProduct(matrix, vector);
			assertArrayEquals(expected, actual);
		}
		
	
	// ------------------------------------------------------------------------------- //
	//
	// 7. Check if a matrix is the identity matrix.
	//
	
	
	public static Stream<Arguments> identityMatrixTestData(){
		return Stream.of(
				Arguments.of(new int[][] {{0}}, false),
				Arguments.of(new int[][] {{1}}, true),
				Arguments.of(new int[][] {{-1}}, false),
				Arguments.of(new int[][] {{0, 0}, {0, 0}}, false),
				Arguments.of(new int[][] {{1, 0}, {0, 1}}, true),
				Arguments.of(new int[][] {{-1, 0}, {0, -1}}, false),
				Arguments.of(new int[][] {{0, 1}, {1, 0}}, false),
				Arguments.of(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, true),
				Arguments.of(new int[][] {{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}}, false),
				Arguments.of(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, -0}}, false)
				);
	}
	
	@ParameterizedTest(name = "{index} testIsIdentityMatrix {0} == I = {1}")
	@MethodSource("identityMatrixTestData")
	void testIsIdentityMatrix(int[][] matrix, boolean isIdentity) throws Exception {
		boolean expected = isIdentity;
		boolean actual = mm.isIdentityMatrix(matrix);
		assertEquals(expected, actual);
	}

	// ------------------------------------------------------------------------------- //
	//
	// 8. Return the product of two matrices.
	//
	
	public static Stream<Arguments> incompatibleMatrixProductData() {
		return Stream.of(
				Arguments.of(
						new int[][] {{1, 1}, {1, 0}},
						new int[][] {{1}, {0}, {1}}
						),
				Arguments.of(
						new int[][] {{1, 0}, {0, 1}},
						new int[][] {{1, 0}, {0, 1}, {1, 0}}
						),
				Arguments.of(
						new int[][] {{1, 0}, {0, 1}, {1, 0}},
						new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}
						),
				Arguments.of(
						new int[][] {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}},
						new int[][] {{1, 0, 1}, {0, 1, 0}}
						)
				);
	}
	
	public static Stream<Arguments> matrixProductTestData(){
		return Stream.of(
				Arguments.of(
						new int[][] {{0, 0}, {0, 0}},
						new int[][] {{0, 0}, {0, 0}},
						new int[][] {{0, 0}, {0, 0}}
						),
				Arguments.of(
						new int[][] {{1, 0}, {0, 1}},
						new int[][] {{1, 0}, {0, 1}},
						new int[][] {{1, 0}, {0, 1}}
						),
				Arguments.of(
						new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},
						new int[][] {{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}},
						new int[][] {{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}}
						),
				Arguments.of(
						new int[][] {{0, 0}, {0, 0}},
						new int[][] {{0, 0}, {0, 0}},
						new int[][] {{0, 0}, {0, 0}}
						),
				Arguments.of(
						new int[][] {{1, 0}, {0, 1}},
						new int[][] {{2, 0}, {0, 2}},
						new int[][] {{2, 0}, {0, 2}}
						),
				Arguments.of(
						new int[][] {{1}, {1}, {1}},
						new int[][] {{1, 1, 1}},
						new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}
						),
				Arguments.of(
						new int[][] {{1}, {0}},
						new int[][] {{0, 1}},
						new int[][] {{0, 1}, {0, 0}}
						)
				);
	}
	
	@ParameterizedTest(name = "{index} testMatrixProductExpectedException {0} * {1}}")
	@MethodSource("incompatibleMatrixProductData")
	void testMatrixProductExpectedException(int[][] matrix1, int[][] matrix2) {
		// attempt to compute the product of vectors of incompatible dimensions.
		assertThrows(Exception.class, () -> {
			mm.matrixProduct(matrix1, matrix2);
		});
	}
	
	@ParameterizedTest(name = "{index} matrixProductTest {0} * {1} = {2}")
	@MethodSource("matrixProductTestData")
	void testMatrixProduct(int[][] matrix1, int[][] matrix2, int[][] product) throws Exception {
		int[][] expected = product;
		int[][] actual = mm.matrixProduct(matrix1, matrix2);
		assertArrayEquals(expected, actual);
	}

	
	// ------------------------------------------------------------------------------- //
	//
	// 9. Return the transpose of a matrix.
	//
	
	public static Stream<Arguments> transposeMatrixTestData(){
		return Stream.of(
			Arguments.of(
					new int[][] {{0, 0}, {0, 0}},
					new int[][] {{0, 0}, {0, 0}}
					),
			Arguments.of(
					new int[][] {{1, 0}, {0, 1}},
					new int[][] {{1, 0}, {0, 1}}
					),
			Arguments.of(
					new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},
					new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}
					),
			Arguments.of(
					new int[][] {{1, 0}, {0, 1}, {1, 1}},
					new int[][] {{1, 0, 1}, {0, 1, 1}}
					)
				);
	}
	
	@ParameterizedTest(name = "{index} transposeMatrixTest {0} * {1} = {2}")
	@MethodSource("transposeMatrixTestData")
	void testTransposeMatrix(int[][] matrix, int[][] transpose) {
		int[][] expected = transpose;
		int[][] actual;
		try {
			actual = mm.transposeMatrix(matrix);
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
