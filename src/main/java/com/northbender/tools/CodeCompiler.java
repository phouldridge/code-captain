package com.northbender.tools;

import org.mdkt.compiler.InMemoryJavaCompiler;

public class CodeCompiler {
	@SuppressWarnings("unused")
	private Class<?> compiledClass = null;
	
	public CompilationResult compile(String className, String sourceCode) {
		CompilationResult result = new CompilationResult();
		
		try (SystemStreamRedirector console = new SystemStreamRedirector()) {
			compiledClass = InMemoryJavaCompiler.compile(className, sourceCode);
		} catch (Error e) {
			result.setSuccess(false);
			result.setResult("Error: " + e.toString());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setResult("Exceptiopn: " + e.toString());
		}
		
		if( !"".equals(SystemStreamRedirector.getString())) {
			result.setSuccess(false);
			result.setResult(SystemStreamRedirector.getString());
		}
		else if( result.isSuccess()){
			result.setResult("Build Successful");
		}
		return result;
	}
}
