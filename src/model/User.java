package model;

public class User {

	private String userName;
	private String password;
	private int category;
	private int contribution;
	private int age;
	public static int NEWBIE = 0;
	public static int LITTLE_CONTRIBUTOR = 1;
	public static int MILD_CONTRIBUTOR = 2;
	public static int STAR_CONTRIBUTOR = 3;

	public User(String userName, String password, int age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.category = NEWBIE;
		this.contribution = 0;
	}

	/*
	 * This method is to select a category dependence of category
	 * @param empty
	 * @return String
	 */

	public String selectCategory() {
		String message = "";
		if(category == 0) {
			message = "NEWBIE";
		}else if(category == 1) {
			message = "LITTLE_CONTRIBUTOR";
		}else if(category == 2) {
		message = "MILD_CONTRIBUTOR";
		}else if(category == 3) {
			message = "STAR_CONTRIBUTOR";
		}else {
			message = "dont have category";
		}

		return message;

	}

	/*
	 * This method is to add contribution a user
	 * @param empty
	 * @return void
	 */

	public void addContribution() {
		this.contribution++;
		updateCategory();
	}

	/*
	 * This method is to update a category of user
	 * @param empty
	 * @return void
	 */

	public void updateCategory() {
		if(contribution >= 3) {
			setCategory(LITTLE_CONTRIBUTOR);
		}else if(contribution >= 10){
			setCategory(MILD_CONTRIBUTOR);
		}else if(contribution >= 30){
			setCategory(STAR_CONTRIBUTOR);
		}else {
			setCategory(NEWBIE);
		}
	}

	/*
	 * This method is to get a name of user
	 * @param empty
	 * @return name
	 */

	public String getUserName() {
		return userName;
	}

	/*
	 * This method is to set a name of user
	 * @param userName
	 * @return void
	 */


	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * This method is to get a password of user
	 * @param empty
	 * @return password
	 */


	public String getPassword() {
		return password;
	}

	/*
	 * This method is to set a password of user
	 * @param password
	 * @return void
	 */


	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * This method is to get a age of user
	 * @param empty
	 * @return age
	 */


	public int getAge() {
		return age;
	}

	/*
	 * This method is to set a age of user
	 * @param age
	 * @return void
	 */

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * This method is to get a category of user
	 * @param empty
	 * @return category
	 */


	public int getCategory() {
		return category;
	}

	/*
	 * This method is to set a category of user
	 * @param category
	 * @return void
	 */


	public void setCategory(int category) {
		this.category = category;
	}

	/*
	 * This method is to get a contribution of user
	 * @param empty
	 * @return contribution
	 */

	public int getContribution() {
		return contribution;
	}

	/*
	 * This method is to get a set of user
	 * @param contribution
	 * @return void
	 */

	public void setContribution(int contribution) {
		this.contribution = contribution;
	}









}
