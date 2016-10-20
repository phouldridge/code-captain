package com.northbender.compiler;

import static org.junit.Assert.*;

import org.junit.Test;
public class MethodSignatureTest {
	private String testSignature = "public static int addNumbers(int a, int b)";
	
	@Test
	public void methodNameExtractedFromSignaturePassedToConstructor() {
		MethodSignature signature = new MethodSignature(testSignature);
		assertEquals("addNumbers", signature.getName());
	}
	
	@Test
	public void returntypeExtractedFromSignaturePassedToConstructor() {
		MethodSignature signature = new MethodSignature(testSignature);
		assertEquals(Integer.class, signature.getReturnType());
	}

	@Test
	public void parametersExtractedFromSignaturePassedToConstructor() {
		Class<?>[] expected = {Integer.class, Integer.class};
		MethodSignature signature = new MethodSignature(testSignature);
		assertArrayEquals(expected, signature.getParameterTypes());
	}
}
