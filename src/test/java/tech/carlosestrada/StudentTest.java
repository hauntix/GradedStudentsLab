package tech.carlosestrada;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

	@Test
	public void addExamScore() {
		Double[] scores = new Double[]{50.0,20.0};
		Student student = new Student("Carlos", "Estrada",scores);
		student.addExamScore(30.0);

		Double[] expected = new Double[] {50.0,20.0,30.0};
		Double[] actual = student.getTestScores();

		Assert.assertArrayEquals(expected,actual);
	}
}
