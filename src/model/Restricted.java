package model;

public class Restricted extends Playlist{


	private User[] accesss;

	public Restricted(String name) {
		super(name);
		this.accesss = new User[5];
	}

	/*
	 * This method is to add to array
	 * @param User a
	 * @return A String
	 */

	public String addtoArray(User a) {
		String message = "";
		for (int i = 0; i < accesss.length; i++) {
			if(accesss[i] == null) {
				accesss[i] = a;
				message = "Se agrego al array";
				break;
			}else {
				message = "No se agrego al array";

			}

		}

		return message;
	}

	/*
	 * This method is to get a array of user access
	 * @param empty
	 * @return A User[] accesss
	 */

	public User[] getAccess5() {
		return accesss;
	}

	/*
	 * This method is to set a array of user access
	 * @param User[]
	 * @param accesss
	 * @return void
	 */

	public void setAccess5(User[] accesss) {
		this.accesss = accesss;
	}

	/*
	 * This method is to check if already have a all user access
	 * @param empty
	 * @return A boolean
	 */

	public boolean isFulltoP() {
		boolean full = true;;
		for (int i = 0; i < accesss.length; i++) {
			if(getAccess5()[i] == null) {
				full = false;
				break;
			}
		}
		return full;
	}

	/*
	 * This method is to give the name of all acess
	 * @param empty
	 * @return A String
	 */


	public String getNameofAllAccess() {
		String message = "";
		for (int i = 0; i < accesss.length; i++) {
			if(accesss[i] != null) {
				message += accesss[i].getUserName() + ", ";
			}
		}
		return message;

	}


}
