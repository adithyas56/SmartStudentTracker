package com.project.main;

import com.project.db.StudentDAO;
import com.project.model.Student;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== SMART STUDENT TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                // ===== ADD =====
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();

                    Student s = new Student(name, dept, year);
                    dao.addStudent(s);
                    break;

                // ===== SHOW =====
                case 2:
                    dao.showAllStudents();
                    break;

                // ===== UPDATE =====
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    System.out.print("Enter New Year: ");
                    int newYear = sc.nextInt();

                    dao.updateStudent(id, newName, newDept, newYear);
                    break;

                // ===== DELETE =====
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int delId = sc.nextInt();

                    dao.deleteStudent(delId);
                    break;

                // ===== EXIT =====
                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
