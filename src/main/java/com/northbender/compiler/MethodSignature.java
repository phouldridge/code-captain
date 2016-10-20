package com.northbender.compiler;

public class MethodSignature {
	private String name;
	private Class<?> returnType;
	private Class<?>[] parameterTypes;
	
	public MethodSignature(String signature) {
	}

	public String getName() {
		return name;
	}

	public Class<?> getReturnType() {
		return returnType;
	}

	public Class<?>[] getParameterTypes() {
		return parameterTypes;
	}
}