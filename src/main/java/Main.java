import tech.carlosestrada.Classroom;
import tech.carlosestrada.Student;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Double[] s1Scores = { 100.0, 150.0 };
		Double[] s2Scores = { 225.0, 25.0 };
		Double[] s3Scores = { 85.0, 95.0 };
		Double[] s4Scores = { 200.0, 70.0 };

		Student s1 = new Student("student", "one", s1Scores);
		Student s2 = new Student("student", "two", s2Scores);

		Student s3 = new Student("student", "three", s3Scores);
		Student s4 = new Student("student", "four", s4Scores);

		Student[] students = new Student[]{s1,s2,s3,s4};
		Classroom classroom = new Classroom(students);

		System.out.println(classroom.getGradeBook());
	}
}
