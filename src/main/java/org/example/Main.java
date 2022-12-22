package org.example;

import org.example.controllers.Menu;
import org.example.tables.Grades;
import org.example.tables.Students;

public class Main {
    public static void main(String[] args){
        //Create a table called Students and another table called Grades
        //The columns on the students table should be as follows: id, name, age
        //Complete the controllers for the students table by adding methods
        // to handle CRD operations on each record in a table.

        //On the Grades table, store the students id, score and the Grades where
        //The columns on Grades should be : id , student_id, score
        // for each Grade:
        // 0-40 F, 40-49 is an D , 50-59 C , 60- 69 B 70-100 A.
        // Complete the controller on the Grades table to have Create  Read and Delete operation
        //For the read operation , you should be able to see the students information as well

        Students.createStudentsTable();
        Grades.createGradesTable();
        Menu.mainMenu();
    }


}