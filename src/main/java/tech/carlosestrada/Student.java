package tech.carlosestrada;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private Double[] testScores;

	public Student(String firstName, String lastName, Double[] examScores){
		this.firstName = firstName;
		this.lastName = lastName;
		this.testScores = examScores;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double[] getTestScores() {
		return testScores;
	}

	public void addExamScore(Double examScore) {
		Double[] tmpScoreArray = new Double[this.testScores.length+1];

		// Copy all the current testScores into the tmpScoreArray
		System.arraycopy(this.testScores, 0, tmpScoreArray,0, this.testScores.length);

		tmpScoreArray[testScores.length] = examScore;
		this.testScores = tmpScoreArray;
	}

	public void setExamScore(int examNumber, double newScore) {
		this.testScores[examNumber -1] = newScore;
	}

	public double getAverageExamScore(){
		double scoreTotal = 0;

		for (Double score : this.testScores) {
			scoreTotal += score;
		}

		return scoreTotal / this.testScores.length;
	}

	public int getNumberOfExamsTaken(){
		return testScores.length;
	}

	public String getExamScores(){
		String response = "Exam scores:";

		DecimalFormat df = new DecimalFormat("###");


		for (int i = 0; i < testScores.length; i++) {
			response += "\n\tExam " + (i +1) + " -> " + df.format(testScores[i]);
		}

		return response;
	}

	@Override
	public String toString() {
		return "\nStudent Name: " + this.firstName + " " + this.lastName +
				"\n> Average Score: " + this.getAverageExamScore() +
				"\n> " + this.getExamScores();
	}
}
