import java.io.Serializable;

public class Contact implements Serializable {
	
	private String mFirstName;
	private String mLastName;
	private String mMobileNumber;
	private String mBirthday;
	private boolean mFavorite;
	

	public Contact(String firstName, String lastName, String mobileNumber, String birthday, boolean favorite) {
		mFirstName = firstName;
		mLastName = lastName;
		mMobileNumber = mobileNumber;
		mBirthday = birthday;
		mFavorite = favorite;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}
	public String getFullName() {
		return mFirstName + " " + mLastName;
	}

	public String getMobileNumber() {
		return mMobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		mMobileNumber = mobileNumber;
	}

	public String getBirthday() {
		return mBirthday;
	}

	public void setBirthday(String birthday) {
		mBirthday = birthday;
	}
	
	public boolean isFavorite() {
		return mFavorite;
	}

	public void setFavorite(boolean favorite) {
		mFavorite = favorite;
	}
	
	

	@Override
	public String toString() {
		String favorite = (isFavorite()) ? "**" : "";
		return "Contact [" + favorite + getFullName() + favorite +  ", Mobile=" + mMobileNumber
				+ ", Birthday=" + mBirthday + "]";
	}

	/**
	 * ternary operator (mini if/else)
	 * 						boolean
	 * 				        condition   ? true : false;
	 * String favorite = (isFavorite()) ? "**" : "";
	 */
	
	
}
