package com.sojapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Model to display error details during exception
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

	private int    errorStatus;
	private String errorMessage;
	private String path;

}
