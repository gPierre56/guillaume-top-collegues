/**
 * 
 */
package com.diginamic.main.exception;

/**
 * @author Guillaume
 *
 */
public class CollegueInvalideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 61612844108345292L;

	private String msg;

	public CollegueInvalideException(String msg) {
		super();
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
