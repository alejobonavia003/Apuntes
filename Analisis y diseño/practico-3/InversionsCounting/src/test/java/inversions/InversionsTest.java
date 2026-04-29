package inversions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class InversionsTest {
	
	
	
	
	
	/**
	 * Proveedor de argumentos para pruebas parametrizadas.
	 * Genera una secuencia de casos de prueba para contar inversiones en arreglos.
	 * 
	 * @return Un Stream de argumentos, donde cada argumento consiste en:
	 *         - Un array de enteros que representa una secuencia de números (entrada del test).
	 *         - Un entero que indica la cantidad esperada de inversiones en el array (salida esperada).
	 */

	private static Stream<Arguments> inversionsArgsProvider() { 
		return Stream.of(
				Arguments.of(new int[] {5,4,2,3,1}, 9), 
				Arguments.of(new int[] {3,1,5,2}, 3), 
				Arguments.of(new int[] {4,1,3,2}, 4)
		);		
	}
	
	
	@ParameterizedTest(name = "{index}:  number of Inversions in {0} is {1}") 
	@MethodSource("inversionsArgsProvider")
	void inversionsCounterTest(int [] arr, int expected) {
    	int result = InversionsCounting.inversionsCounter(arr);
	    assertEquals(expected, result); 
	}
	
	

}
