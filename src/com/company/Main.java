package com.company;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Grades grades = new Grades(new File("Imports.txt"));
        Scanner kbinput = new Scanner(System.in);

        System.out.println("Welcome to Grade Sorter.\n" +
                "Press 1 for class average.\n" +
                "Press 2 for the number of each letter grade.\n" +
                "Press 3 for to search for a student's grade\n" +
                "Press 4 to prompt options again.\n" +
                "Press 5 to exit.");

        while (true){
            String input = kbinput.next();
            if (input.equals("1"))
                System.out.println("Class Average: " + grades.getAverageGrade());
            else if (input.equals("2"))
                System.out.println("Class Grades: \n" + grades.getGrades());
            else if (input.equals("3")) {
                System.out.println("Which student would you like");
                input = kbinput.nextLine(); //WTJ
                input = kbinput.nextLine();
                System.out.println(grades.getStudentGrade(input));
                if(!grades.studentExists)
                    System.out.println(("Pssst... This student doesn't exist."));
                else
                    if(!grades.absenceWarning)
                    System.out.println(("Pssst... This student's absence is hurting their grade."));
            }
            else if (input.equals("4"))
                System.out.println("Press 1 for class average.\n" +
                        "Press 2 for the number of each letter grade.\n" +
                        "Press 3 for to search for a student\n" +
                        "Press 4 to prompt options again.\n" +
                        "Press 5 to exit.");
            else if (input.equals("5"))
            {
                System.out.println("Goodbye!");
                break;
            }
            else
                System.out.println("That's not an option. Try again.");
        }



    }
}
