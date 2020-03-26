package com.revature.exception;

public class FileUploadServiceException extends RuntimeException {

	private static final long serialVersionUID = 2468434988680850339L;	
	
	public FileUploadServiceException(String msg, Throwable throwable){
		super(msg, throwable);
	}
	
}
