package com.northbender.compiler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemStreamRedirector implements AutoCloseable {

    private static ByteArrayOutputStream out;
    private PrintStream sysOut;
    private PrintStream sysErr;

	public SystemStreamRedirector() {

		out = new ByteArrayOutputStream();
		PrintStream redirected = new PrintStream(out);
		sysOut = System.out;
		System.setOut(redirected);
		sysErr = System.err;
		System.setErr(redirected);
	}
	
    @Override
	public void close() throws Exception {
		System.out.flush();
    	System.setOut(sysOut);
		System.err.flush();
    	System.setErr(sysErr);
	}
    
    public static String getString() {
    	return out.toString();
    }
}
