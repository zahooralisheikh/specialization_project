package com.torryharris.demo.exception;

//public class DepartmentNotFoundException extends Exception { // creates checked exception 

public class DepartmentNotFoundException extends RuntimeException { // creates unchecked exception

	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message) { // message = This department is not found.
		super(message);
	}

}
