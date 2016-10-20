package com.northbender.compiler;

import java.util.ArrayList;

import org.springframework.util.ClassUtils;

public class MethodSignature {
	private String name;
	private Class<?> returnType;
	private Class<?>[] parameterTypes;
	
	public MethodSignature(String signature) {
		String[] header = signature.replaceAll("\\(.*?\\)","").split(" ");
		String[] parms = signature.substring(signature.indexOf("(")+1,signature.indexOf(")")).split(",\\s");

		setName( header[header.length-1]);

		try {
			setReturnType( ClassUtils.forName(header[header.length-2],null));
		} catch (ClassNotFoundException e) {
			setReturnType( null);
		}

		ArrayList<Class<?>> parmTypes = new ArrayList<Class<?>>(); 
		try {
			for(String parm: parms) {
				if( !parm.isEmpty()) {
					String parmType = parm.substring(0,parm.indexOf(" "));
					parmTypes.add(ClassUtils.forName(parmType,null));
				}
			}

			Class<?>[] types = new Class<?>[parmTypes.size()];
			setParameterTypes( parmTypes.toArray(types));
		} catch (ClassNotFoundException e) {
			setParameterTypes( null);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public void setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
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