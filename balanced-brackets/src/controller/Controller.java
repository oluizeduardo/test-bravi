package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Controller {

	/**
	 * It checks the balance of a brackets sequence.
	 * 
	 * @param sequence String brackets sequence.
	 * @return true or false.
	 */
	public boolean isBalanced(String sequence) {
		
		// It creates a Map with the set of opened and closed pairs of brackets.
		// A Map object is composed of a key and its value,
		// in this case, an opened standard and its similar closed.
	    Map<Character, Character> openClosePair = new HashMap<Character, Character>();
	    openClosePair.put('(', ')');
	    openClosePair.put('{', '}');
	    openClosePair.put('[', ']'); 

	    // Creates a new stack.
	    Stack<Character> stack = new Stack<Character>();
	    
	    for (int i = 0; i < sequence.length(); i++) {

	    	// It checks the key (opened brackets) at the Map object.
	        if (openClosePair.containsKey(sequence.charAt(i))) {
	        	// If there's the key, the bracket is an open one.
	        	// Add it on the stack.
	            stack.push(sequence.charAt(i));

	        // If there's no key, let's check the value (closed brackets) on the map.
	        } else if (openClosePair.containsValue(sequence.charAt(i))) {
	        	
	        	// If the first char in the sequence is a closed one, the sequence is not valid.
	            if (stack.isEmpty())
	                return false;
	            
	            // Removes the char from the top of the stack.
	            char keyChar = stack.pop();
	            // Gets the current char from the brackets sequence.
	            char currentChar = sequence.charAt(i);
	            
	            // Comparates the current char with the value of the map
	            // in order to check if it's the same standard of closed bracket.
	            // The get method uses a key to return its value.
	            if (currentChar != openClosePair.get(keyChar)) {
	            	
	            	// Show where is the error in the closed bracket.
	            	System.out.println("It should be "
	            			+ "'"+openClosePair.get(keyChar)+"' "
	            			+ "instead '"+currentChar+"'");
	            	// The standard of opened and closed brackets are not the same, return false.
	            	return false;
	            }
	        }
	    }
	    // If didn't return a false value, returns the status of the stack.
	    return stack.isEmpty();
	}
	
}
