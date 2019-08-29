package com.diginamic.main.exception;

public class CollegueNonTrouveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1886283008059405885L;

	private String msg;

	public CollegueNonTrouveException(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
