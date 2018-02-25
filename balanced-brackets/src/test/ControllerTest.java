package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.Controller;


class ControllerTest {

	@Test
	void testIsBalanced() {
		
		Controller controller = new Controller();
		boolean seq1 = controller.isBalanced("(){}[]");
		boolean seq2 = controller.isBalanced("[{()}](){}");
		boolean seq3 = controller.isBalanced("[]{()");
		boolean seq4 = controller.isBalanced("[{)]");
		
		assertEquals(true, seq1);
		assertEquals(true, seq2);
		assertEquals(false, seq3);
		assertEquals(false, seq4);
	}

}
