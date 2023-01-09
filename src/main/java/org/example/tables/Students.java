package org.example.tables;

import org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {

    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void createStudentsTable() {

        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Students(" +
                    "id serial PRIMARY KEY," +
                    "first_name varchar(255) NOT NULL," +
                    "last_name varchar(255) NOT NULL," +
                    "age int)");
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getAllStudents() {


        try{
            ps = connection.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "student_id: " + rs.getInt("student_id");
                String name = "name: " + rs.getString("name");
                String age = "age: " + rs.getString("age");



                System.out.println(id + " " + name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean createNewStudent() {
        // Add prompts to tell the user what data they need to enter next
        System.out.print("Enter the Student's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the Student's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the age: ");
        int age = scanner.nextInt();



        try {
            ps = connection.prepareStatement("INSERT INTO Students(first_name, last_name, age) " +
                    "VALUES('" + firstName + "','" + lastName + "', " + age + ")");

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Implement a method to update an item using its id where its id should be passed by the user,
    // i.e use the scanner class to get the id.

    public static boolean updateStudent() {
        // Update prompts to tell the user what data they need to enter next


        System.out.print("Enter the new Student First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the new Student last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the id you want to update: ");
        int id = scanner.nextInt();

        System.out.print("Enter the new age: ");
        int age = scanner.nextInt();




        try {
            ps = connection.prepareStatement("UPDATE Students SET " +
                    "first_name = '" + firstName + "', " +
                    "last_name = '" + lastName + "'," +
                    "age =  " + age + " " +
                    "WHERE id = " + id);

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //* Implement 2 methods,
    // The first method should be called deleteItem() and it
    //should prompt the user to enter the id of the item to be deleted
    //return boolean if the operation is successful

    //The second method should be called getItemBy() and it should prompt
    //the user to also the id of the item in question
    public static boolean deleteStudent() {


        System.out.print("Enter the student's id you want to delete: ");
        int id = scanner.nextInt();


        try {

            ps = connection.prepareStatement("DELETE FROM grades WHERE student_id =" +id);
            ps.execute();

            ps = connection.prepareStatement("DELETE FROM students WHERE student_id = "+id+"");
            ps.execute();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
