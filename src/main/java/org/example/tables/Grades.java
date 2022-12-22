package org.example.tables;

import org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Grades {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);



    public static boolean createGradesTable() {
        try {
            ps = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Grades(" +
                            "id serial PRIMARY KEY," +
                            "students_id int NOT NULL," +
                            "score int NOT NULL," +
                            "grade varchar(255) NOT NULL," +
                            "FOREIGN KEY(students_id) REFERENCES Students(id))");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static void getAllGrades(){



        try{
            ps = connection.prepareStatement("SELECT * FROM Grades");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String studentsId = "students_id: " + rs.getInt("students_id");
                String score = "score: " + rs.getInt("score");
                String grade = "grade: " + rs.getString("grade");

                System.out.println(id + ", " + studentsId + ", " + score + ", " + grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean createNewGrade() {
        // Add prompts to tell the user what data they need to enter next
        System.out.print("Enter the students id: ");
        int studentsId = scanner.nextInt();

        System.out.print("Enter the new score: ");
        int score = scanner.nextInt();

        System.out.print("Enter the new grade: ");
        String grade = scanner.nextLine();




        try {
            ps = connection.prepareStatement("INSERT INTO Grades(students_id, score, grade) " +
                    "VALUES(" + studentsId + "," + score + ", '" + grade + "')");

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Implement a method to update an item using its id where its id should be passed by the user,
    // i.e use the scanner class to get the id.

    public static boolean updateGrade() {
        // Update prompts to tell the user what data they need to enter next


        System.out.print("Enter the new score: ");
        int score = scanner.nextInt();

        System.out.print("Enter the new grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter the id you want to update: ");
        int id = scanner.nextInt();






        try {
            ps = connection.prepareStatement("UPDATE items SET " +
                    "score = " + score + ", " +
                    "grade = '" + grade + "'," +
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
    public static boolean deleteGrade() {
        // Update prompts to tell the user what data they need to enter next


        System.out.print("Enter the id you want to delete: ");
        int id = scanner.nextInt();


        try {
            ps = connection.prepareStatement("DELETE FROM Grades " + " " +
                    "WHERE id = " + id);

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
