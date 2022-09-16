package com.sojapplication.model;

/**
 * Model to display error details during exception
 */
public class ErrorDetails {

	private int    errorStatus;
	private String errorMessage;
	private String path;

	public ErrorDetails(final int errorStatus, final String errorMessage, final String path) {
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
		this.path = path;
	}

	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(final int errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}

}
