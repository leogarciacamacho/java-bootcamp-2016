package com.mycompany.app.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) throws SQLException {
		ResultRow resultRow = new ResultRow();
		ResultTable resultTable = new ResultTable();
		Connection conn = DataBaseConnector.getInstance().getConnection();
		PreparedStatement preparedStatement;
		ResultSet result;
		String query = "SELECT t.last_name, t.first_name, cst.day_week, cst.start_time, cst.finish_time, c.name FROM teacher t INNER JOIN course c ON t.id_teacher = c.id_teacher INNER JOIN course_schedule_time cst ON c.id_course = cst.id_course WHERE t.id_teacher = ? ORDER BY cst.day_week;";

		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				resultRow.setLastName(result.getString("last_name"));
				resultRow.setFirstName(result.getString("first_name"));
				resultRow.setDayOfWeek(result.getInt("day_week"));
				resultRow.setStartTime(result.getTime("start_time"));
				resultRow.setFinishTime(result.getTime("finish_time"));
				resultRow.setCourseName(result.getString("name"));
				resultTable.addRow(resultRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(ResultRow row : resultTable.getRows()) {
			System.out.println(row.toString());   // this is only for personal testing
		}
	}
}	