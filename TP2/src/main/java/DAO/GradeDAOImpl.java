package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GradeDAOImpl implements GradeDAO {

	private static final String RESOURCE_NAME = "jdbc/grade";

	public Connection createConnection() throws SQLException, NamingException {
		InitialContext ic = new InitialContext();
		Context ctx = (Context) ic.lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup(RESOURCE_NAME);

		return ds.getConnection();
	}

	@Override
	public Double getMean() {
		Connection connection = null;
		Double averageGrade = 0D;
		try {
			connection = createConnection();
			String sqlAverage = "SELECT AVG(grade) AS average_grade FROM grades";
			Statement averageStatement = connection.createStatement();
			ResultSet averageResult = averageStatement.executeQuery(sqlAverage);

			if (averageResult.next()) {
				averageGrade = averageResult.getDouble("average_grade");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return averageGrade;
	}

	@Override
	public void addStudent(String name, String firstName, Integer studentNumber, Double grade) {
		Connection connection = null;
		String sqlInsert = "INSERT INTO grades (name, first_name, student_number, grade) VALUES (?, ?, ?, ?)";
		try {
			connection = createConnection();
			PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
			insertStatement.setString(1, name);
			insertStatement.setString(2, firstName);
			insertStatement.setInt(3, studentNumber);
			insertStatement.setDouble(4, grade);
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
