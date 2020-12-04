package model;

import java.util.ArrayList;

public class Public extends Playlist{

	private double averageMark;
	private ArrayList<Double> grades;
	private ArrayList<User> access;

	public Public(String name) {
		super(name);
		this.averageMark = 0.0;
		this.access = new ArrayList<User>();
	}

	/*
	 * This method is to calculate the average
	 * @param empty
	 * @return void
	 */

	public void calculateAverage() {
		double a = 0.0;
		for (int i = 0; i < grades.size(); i++) {
			a += grades.get(i);
		}

		double average = a / grades.size();

		setAverageMark(average);
	}

	/*
	 * This method is to get a grades
	 * @param empty
	 * @return A ArrayList<Double> grades
	 */

	public ArrayList<Double> getGrades() {
		return grades;
	}

	/*
	 * This method is to set a grades
	 * @param ArrayList<Double> grades
	 * @return void
	 */

	public void setGrades(ArrayList<Double> grades) {
		this.grades = grades;
	}

	/*
	 * This method is to get a averageMark
	 * @param empty
	 * @return A double averageMark
	 */

	public double getAverageMark() {
		return averageMark;
	}

	/*
	 * This method is to set a averageMark
	 * @param double
	 * @param averageMark
	 * @return void
	 */

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}

	/*
	 * This method is to get a user access
	 * @param empty
	 * @return A ArrayList<User> access
	 */

	public ArrayList<User> getAccess0() {
		return access;
	}

	/*
	 * This method is to set a user access
	 * @param ArrayList<User>
	 * @param access
	 * @return void
	 */

	public void setAccess0(ArrayList<User> access) {
		this.access = access;
	}


}
