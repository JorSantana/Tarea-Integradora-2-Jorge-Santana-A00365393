package model;

import java.util.ArrayList;

public class Private extends Playlist {

	private User aaccess;

	public Private(String name) {
		super(name);
		this.aaccess = null;
	}

	/*
	 * This method is to get a user access
	 * @param empty
	 * @return A User
	 */

	public User getAccess1() {
		return aaccess;
	}

	/*
	 * This method is to get a user access
	 * @param User
	 * @param aaccess
	 * @return void
	 */

	public void setAccess1(User aaccess) {
		this.aaccess = aaccess;
	}

	/*
	 * This method is to check if already have a user access
	 * @param empty
	 * @return A boolean
	 */

	public boolean isFulltoP() {
		boolean full = false;
		if(getAccess1() != null) {
			full = true;
		}
		return full;
	}




}
