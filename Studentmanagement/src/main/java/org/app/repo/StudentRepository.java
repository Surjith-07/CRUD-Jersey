package org.app.repo;

import org.app.db.DbConnection;
import org.app.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String getAllquery = "select * from students";
    private static final String getIndividual = "select id,name,address from students where id = ?";
    private static final String createQuery = "insert into students values(default,?,?)";
    private static final String deletQuery = "delete from students where id = ?";
    public static final String updateQuery = "update students set name = ? , address= ? where id = ?";

    public static List<Student> getAllStudent() throws SQLException {
        List<Student> list = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllquery)) {
            while (resultSet.next()) {
                list.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        }
        return list;
    }

    public static Student getStudentById(int id) throws SQLException {
        ResultSet resultSet = null;
        Student student = null;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getIndividual);) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            System.out.println("id\tname\taddress");
            while (resultSet.next()) {
                student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return student;
    }

    public static void creatStudent(Student student) throws SQLException {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createQuery);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            int affectedRow = preparedStatement.executeUpdate();
            System.out.print(affectedRow > 0 ? "Successfully inserted...!" : "Somthing wrong...!");
        }
    }

    public static void updateStudent(Student student) throws SQLException {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setInt(3, student.getId());
            int affectedRow = preparedStatement.executeUpdate();
            System.out.print(affectedRow > 0 ? "Successfully Updated...!" : "Somthing wrong...!");
        }
    }

    public static void deleteStudent(int id) throws SQLException {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deletQuery);) {
            preparedStatement.setInt(1, id);
            int affectedRow = preparedStatement.executeUpdate();
            System.out.print(affectedRow > 0 ? "Successfully Deleted...!" : "Somthing wrong...!");
        }
    }
}
