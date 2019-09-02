/**
 * 
 */
package com.diginamic.main.dto;

/**
 * @author Guillaume
 * 
 *
 */
public class CollegueDto {

	private String email;
	private String urlPhoto;

	public CollegueDto() {
		super();
	}

	public CollegueDto(String email, String urlPhoto) {
		super();
		this.email = email;
		this.urlPhoto = urlPhoto;
	}

	@Override
	public String toString() {
		return "CollegueDto [email=" + email + ", urlPhoto=" + urlPhoto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((urlPhoto == null) ? 0 : urlPhoto.hashCode());
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
		CollegueDto other = (CollegueDto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (urlPhoto == null) {
			if (other.urlPhoto != null)
				return false;
		} else if (!urlPhoto.equals(other.urlPhoto))
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

	/**
	 * @return the urlPhoto
	 */
	public String getUrlPhoto() {
		return urlPhoto;
	}

	/**
	 * @param urlPhoto the urlPhoto to set
	 */
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

}
