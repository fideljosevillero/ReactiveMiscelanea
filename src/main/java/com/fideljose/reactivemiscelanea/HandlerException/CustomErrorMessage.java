package com.fideljose.reactivemiscelanea.HandlerException;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CustomErrorMessage {

	private Date timestamp;
	private String message;
	private String custom;
	
	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
