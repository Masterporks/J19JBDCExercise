package org.example.controllers;

import org.example.tables.Grades;
import org.example.tables.Students;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Students");
        System.out.println("2. Grades");


        System.out.println();
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                studentsMenu();
                break;
            case 2:
               gradesMenu();
                break;

            default:
                System.out.println("Invalid option.");
                mainMenu();
                break;
        }

    }
    public static void studentsMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get All Students");
        System.out.println("2. Create New Student");
        System.out.println("3. Update Student");
        System.out.println("2. Delete Student");


        System.out.println();
        System.out.print("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Students.getAllStudents();
                studentsMenu();
                break;
            case 2:
                Students.createNewStudent();
                studentsMenu();
                break;
            case 3:
                Students.updateStudent();
                studentsMenu();;
                break;
            case 4:
                Students.deleteStudent();
                studentsMenu();
                break;


            default:
                System.out.println("Invalid option.");
                studentsMenu();
                break;
        }

    }
    public static void gradesMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get All Grades");
        System.out.println("2. Create New Grade");
        System.out.println("3. Update Grade");
        System.out.println("2. Delete Grade");


        System.out.println();
        System.out.print("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Grades.getAllGrades();
                gradesMenu();
                break;
            case 2:
                Grades.createNewGrade();
                gradesMenu();
                break;
            case 3:
                Grades.updateGrade();
                gradesMenu();;
                break;
            case 4:
                Grades.deleteGrade();
                gradesMenu();
                break;


            default:
                System.out.println("Invalid option.");
                studentsMenu();
                break;
        }

    }


}
