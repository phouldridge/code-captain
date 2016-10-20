package com.northbender.compiler;

import static org.junit.Assert.*;

import org.junit.Test;
public class MethodSignatureTest {
	private String testSignature = "private static int someMethod(java.lang.String hello, float b, boolean isSomething)";
	private String testHelloSignature = "public void sayHello()";
	
	@Test
	public void methodNameExtractedFromSignaturePassedToConstructor() {
		MethodSignature signature = new MethodSignature(testSignature);
		assertEquals("someMethod", signature.getName());
	}
	
	@Test
	public void returntypeExtractedFromSignaturePassedToConstructor() {
		MethodSignature signature = new MethodSignature(testSignature);
		assertEquals(int.class, signature.getReturnType());
	}

	@Test
	public void parametersExtractedFromSignaturePassedToConstructor() {
		Class<?>[] expected = {String.class, float.class, boolean.class};
		MethodSignature signature = new MethodSignature(testSignature);
		assertArrayEquals(expected, signature.getParameterTypes());
	}

	@Test
	public void voidReturntypeExtractedFromSignaturePassedToConstructor() {
		MethodSignature signature = new MethodSignature(testHelloSignature);
		assertEquals(void.class, signature.getReturnType());
	}

	@Test
	public void emptyParametersExtractedFromSignaturePassedToConstructor() {
		Class<?>[] expected = {};
		MethodSignature signature = new MethodSignature(testHelloSignature);
		assertArrayEquals(expected, signature.getParameterTypes());
	}
}
