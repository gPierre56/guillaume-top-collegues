/**
 * 
 */
package com.diginamic.main.dto;

/**
 * @author Guillaume
 *
 */
public class CollegueEmailDTO {

	private String email;

	public CollegueEmailDTO(String email) {
		super();
		this.email = email;
	}

	public CollegueEmailDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CollegueEmailDTO [email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollegueEmailDTO other = (CollegueEmailDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
