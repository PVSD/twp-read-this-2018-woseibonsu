package com.company;
import java.util.*;
import java.io.*;

public class Grades {

    File file;
    boolean studentExists; //I'm doing it like this cause I don't feel like making a method
    boolean absenceWarning; //This could be a method too but its 6:30 and I need to get ready for school

    public Grades(File f)
    {
        file = f;
    }

    public String getAverageGrade () throws IOException
    {
        Scanner fileReader = new Scanner(file);
        fileReader.nextLine();
        int count = 0;
        double averageGrade = 0;

        while(fileReader.hasNextLine()){ //Sets count to the amount of lines in the document
            count++;
            fileReader.nextLine();
        }

        double[] grades = new double[count];

        fileReader = new Scanner(file); //Restart the scanner's position
        fileReader.nextLine();

        //PUTS ALL GRADES IN AN ARRAY
        for (int i = 0; i < count; i++)
        {
            String[] tempLine = fileReader.nextLine().split("\\t");
            grades[i] = Integer.parseInt(tempLine[2].substring(0,tempLine[2].length()-1));
        }

        //CALCULATES CLASS AVERAGE
        for (double temp : grades)
            averageGrade += temp;
        averageGrade /= count;
        return averageGrade + "%";
    }

    public String getGrades() throws IOException
    {
        Scanner fileReader = new Scanner(file);
        fileReader.nextLine();
        int count = 0;
        int numberOfAs = 0;
        int numberOfBs = 0;
        int numberOfCs = 0;
        int numberOfDs = 0;
        int numberOfFs = 0;

        while(fileReader.hasNextLine()){ //Sets count to the amount of lines in the document
            count++;
            fileReader.nextLine();
        }

        int[] grades = new int[count];

        fileReader = new Scanner(file); //Restart the scanner's position
        fileReader.nextLine();

        //PUTS ALL GRADES IN AN ARRAY
        for (int i = 0; i < count; i++)
        {
            String[] tempLine = fileReader.nextLine().split("\\t");
            grades[i] = Integer.parseInt(tempLine[2].substring(0,tempLine[2].length()-1));

            //ORGANIZES GRADES
            if (grades[i] > 90)
                numberOfAs++;
            else if (grades[i] >= 80 && grades[i] < 90)
                numberOfBs++;
            else if (grades[i] >= 70 && grades[i] < 80)
                numberOfCs++;
            else if (grades[i] >= 60 && grades[i] < 70)
                numberOfDs++;
            else
                numberOfFs++;
        }

        return "Number of As: " + numberOfAs + "\n" +
                "Number of Bs: " + numberOfBs + "\n" +
                "Number of Cs: " + numberOfCs + "\n" +
                "Number of Ds: " + numberOfDs + "\n" +
                "Number of Fs: " + numberOfFs + "\n";

    }

    public String getStudentGrade (String student) throws IOException
    {
        Scanner fileReader = new Scanner(file);
        fileReader.nextLine();
        int count = 0;
        double gradePercent = 0;
        char gradeLetter;
        int absences = 0;

        while(fileReader.hasNextLine()){ //Sets count to the amount of lines in the document
            count++;
            fileReader.nextLine();
        }

        double[] grades = new double[count];
        String[] students = new String[count];


        fileReader = new Scanner(file); //Restart the scanner's position
        fileReader.nextLine();

        //PUTS ALL GRADES IN AN ARRAY
        for (int i = 0; i < count; i++)
        {
            String[] tempLine = fileReader.nextLine().split("\\t");
            grades[i] = Integer.parseInt(tempLine[2].substring(0,tempLine[2].length()-1));
            students[i] = tempLine[0] + " " + tempLine[1];
            if (student.equals(students[i]))
            {
                gradePercent = grades[i];
                studentExists = true;
                absences = Integer.parseInt(tempLine[3]);
            }
        }

        if (gradePercent > 90)
            gradeLetter = 'A';
        else if (gradePercent >= 80 && gradePercent < 90)
            gradeLetter = 'B';
        else if (gradePercent >= 70 && gradePercent < 80)
            gradeLetter = 'C';
        else if (gradePercent >= 60 && gradePercent < 70)
            gradeLetter = 'D';
        else
            gradeLetter = 'F';

        if (gradePercent < (gradePercent - absences * .55))
        absenceWarning = true;
        return student + "\'s grade is " + gradePercent + "% (" + gradeLetter + ")";
    }


}
