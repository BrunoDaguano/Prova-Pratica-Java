package catalago.com.controller;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private Boolean success;
	private String message;
	private Map<String, Object> data;
	private Map<String, String> fieldErrors;

	public Result() {
		this.success = Boolean.TRUE;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		if (this.data == null) {
			this.data = new HashMap<String, Object>();
		}

		return this.data;
	}

	public Map<String, String> getFieldErrors() {
		if (this.fieldErrors == null) {
			this.fieldErrors = new HashMap<String, String>();
		}
		return this.fieldErrors;
	}


}
