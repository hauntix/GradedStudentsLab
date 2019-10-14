package tech.carlosestrada;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
	private String firstName;
	private String lastName;
	private ArrayList<Double> testScores;

	public Student(String firstName, String lastName, Double[] examScores){
		this.firstName = firstName;
		this.lastName = lastName;
		this.testScores = new ArrayList<>(Arrays.asList(examScores));
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
		Double[] array = new Double[testScores.size()];
		return testScores.toArray(array);
	}

	public void addExamScore(Double examScore) {
		this.testScores.add(examScore);
	}

	public void setExamScore(int examNumber, double newScore) {
		this.testScores.set(examNumber, newScore);
	}

	public double getAverageExamScore(){
		double scoreTotal = 0;

		for (Double score : this.testScores) {
			scoreTotal += score;
		}

		return scoreTotal / this.testScores.size();
	}

	public int getNumberOfExamsTaken(){
		return testScores.size();
	}

	public String getExamScores(){
		String response = "Exam scores:";

		DecimalFormat df = new DecimalFormat("###");


		for (int i = 0; i < testScores.size(); i++) {
			response += "\n\tExam " + (i +1) + " -> " + df.format(testScores.get(i));
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
