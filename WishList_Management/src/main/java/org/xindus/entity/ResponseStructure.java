package org.xindus.entity;

@lombok.Data
public class ResponseStructure<T> {
	private T Data;
	private String message;
	private int statusCode;
}
