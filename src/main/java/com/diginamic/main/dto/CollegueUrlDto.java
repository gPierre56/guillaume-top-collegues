/**
 * 
 */
package com.diginamic.main.dto;

/**
 * @author Guillaume
 *
 */
public class CollegueUrlDto {

	private String photoUrl;

	public CollegueUrlDto() {
		super();
	}

	public CollegueUrlDto(String photoUrl) {
		super();
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "CollegueUrlDto [photoUrl=" + photoUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((photoUrl == null) ? 0 : photoUrl.hashCode());
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
		CollegueUrlDto other = (CollegueUrlDto) obj;
		if (photoUrl == null) {
			if (other.photoUrl != null)
				return false;
		} else if (!photoUrl.equals(other.photoUrl))
			return false;
		return true;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
