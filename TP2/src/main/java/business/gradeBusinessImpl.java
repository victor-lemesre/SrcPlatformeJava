package business;

import DAO.GradeDAO;
import DAO.GradeDAOImpl;

public class gradeBusinessImpl implements gradeBusiness {

	private GradeDAO grade;

	public gradeBusinessImpl() {
		this.grade = new GradeDAOImpl();
	}

	@Override
	public Double getMean() {
		return grade.getMean();
	}

	@Override
	public void addGrade(String name, String firstName, Integer studentNumber, Double grade) {
		this.grade.addStudent(name, firstName, studentNumber, grade);

	}
}
