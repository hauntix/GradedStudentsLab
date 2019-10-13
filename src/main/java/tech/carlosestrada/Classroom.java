package tech.carlosestrada;

import java.util.HashMap;

public class Classroom {
	private Student[] students;

	public Classroom(int maxNumberOfStudents){
		this.students = new Student[maxNumberOfStudents];
	}

	public Classroom(Student[] students){
		this.students = students;
	}

	public Classroom() {
		this.students = new Student[30];
	}

	public Student[] getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		int totalStudents = 0;

		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] == null) {
				this.students[i] = student;
				break;
			} else {
				totalStudents++;
			}
		}

		if (totalStudents == this.students.length){
			throw new Error("Classroom is already full.");
		}
	}

	public void removeStudent(String firstName, String lastName) {
		for (int i = 0; i < this.students.length; i++) {
			if(this.students[i].getFirstName().equals(firstName) && this.students[i].getLastName().equals(lastName))
				this.students[i] = null;
		}

		for(int i = 0; i < this.students.length; i++) {
			if(this.students[i] == null){
				for (int j = i+1; j < this.students.length; j++) {
					this.students[j-1] = this.students[j];
				}
				this.students[students.length -1] = null;
				break;
			}
		}
	}

	public double getAverageExamScore() {
		double totalScore = 0;

		for (Student student : students) {
			totalScore += student.getAverageExamScore();
		}

		return totalScore / students.length;
	}

	public Student[] getStudentsByScore() {
		Student[] sortedStudents = this.students;
		Student tmp;

		for (int i = 0; i < this.students.length; i++) {
			for (int j = 1; j < this.students.length-i; j++) {
				if(sortedStudents[j-1].getAverageExamScore() > sortedStudents[j].getAverageExamScore()){
					// TODO: add ability to sort by name too
					tmp = sortedStudents[j-1];
					sortedStudents[j-1] = sortedStudents[j];
					sortedStudents[j] = tmp;
				}
			}
		}

		return sortedStudents;
	}

	public HashMap<Student, Character> getGradeBook() {
		HashMap<Student, Character> gradeBook = new HashMap<>();

		for (Student student : this.students) {
			char letterGrade;

			if(student.getAverageExamScore() >= (.9 * getAverageExamScore()) )
				letterGrade = 'A';
			else if (student.getAverageExamScore() >= ( .71 * getAverageExamScore() ))
				letterGrade = 'B';
			else if (student.getAverageExamScore() >= ( .50 * getAverageExamScore() ))
				letterGrade = 'C';
			else if (student.getAverageExamScore() >= ( .11 * getAverageExamScore() ))
				letterGrade = 'D';
			else
				letterGrade = 'F';

			gradeBook.put(student, letterGrade);
		}

		return gradeBook;
	}
}
