package com.project.db;

import com.project.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    // ================= ADD STUDENT =================
    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO students(name, department, year) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getDepartment());
            ps.setInt(3, s.getYear());

            ps.executeUpdate();
            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= SHOW ALL STUDENTS =================
    public void showAllStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT * FROM students";
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID | NAME | DEPARTMENT | YEAR");
            System.out.println("----------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                int year = rs.getInt("year");

                System.out.println(id + " | " + name + " | " + dept + " | " + year);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE STUDENT =================
    public void updateStudent(int id, String name, String dept, int year) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE students SET name=?, department=?, year=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setInt(3, year);
            ps.setInt(4, id);

            ps.executeUpdate();
            System.out.println("Student Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= DELETE STUDENT =================
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Student Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
