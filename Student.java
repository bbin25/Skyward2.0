//THIS IS THE STUDENT CLASS - NOT MAIN
/*Directions: You are to propose, design, 
and write the program for a registration 
system for a school.  The program should 
be capable of taking attendance, scheduling
a student for classes, and assigning and 
reporting grades.*/

import java.util.Scanner;
public class Student {
    //import scanner
    Scanner scan = new Scanner(System.in);
    //declare variables
    public String name;
    public boolean attendance;
    public int[] classIndexList = new int[4]; //this will hold the student’s schedule - every number here corresponds to a class using parallel arrays to the class list in main.
    public double[] gradeList = new double[4]; //this is the grade for each block
    

    //CONSTRUCTOR
    public void Student(){
        name = "";
        attendance = true;
    }
    
    public void Student(String n,boolean a, int[] c, double[] g){
        name = n;
        attendance = a;
        classIndexList = c;
        gradeList = g;
    }
    

    //GETTERS
    //name
    public String getName(){
        return name;
    }
    //attendance
    public boolean getAttendance(){
        return attendance;
    }
    //classIndexList
    public int getClassIndexList(int i){
        return classIndexList[i];
    }
    //gradeList
    public double getGradeList(int i){
        return gradeList[i];
    }
    

    //SETTERS
    //name
    public void setName(String n){
        name = n;
    }
    //attendance
    public void setAttendance(boolean a){
        attendance = a;
    }
    //classIndexList
    public void setClassIndexList(int x, int index){
        classIndexList[index] = x;
    }
    //gradeList
    public void setGradeList(double x, int index){
        gradeList[index] = x;
    }
    
    
    //METHODS
    //Create a students with name
    public void createName(int n){
        System.out.println("Enter the name of student "+n);
        name = scan.nextLine();
    }
    
    
    //Schedule the classes
    public void schedule(String n, String[] classList){
        //set schedule by block for 4 blocks
        do{
            for (int i=0; i<4; i++){
                System.out.println("For " +n+ ", enter the index for block " +(i+1)+ ": "); //enter the block and add to class index list
                classIndexList[i]=scan.nextInt();
            }
        }//below is the error checking for the classes to make sure they are all legitimate classes and are not repeated
        while (classIndexList[0]==classIndexList[1]
            ||classIndexList[0]==classIndexList[2]
            ||classIndexList[0]==classIndexList[3]
            ||classIndexList[1]==classIndexList[2]
            ||classIndexList[1]==classIndexList[3]
            ||classIndexList[2]==classIndexList[3]
            ||classIndexList[0]>6 || classIndexList[0]<0
            ||classIndexList[1]>6 || classIndexList[1]<0
            ||classIndexList[2]>6 || classIndexList[2]<0
            ||classIndexList[3]>6 || classIndexList[3]<0);
        //view schedule by block for 4 blocks
        System.out.println(n+"'s schedule looks like this: ");
        for (int j=0; j<4;j++){
            System.out.println("Block " +(j+1)+ ": "+ classList[classIndexList[j]]);
        }
    }
    
    
    //set grades
    public void setGrades(String n, String[] classList){
        //set schedule by block for 4 blocks
        for (int i=0; i<4; i++){
            do{
                System.out.println("For " +n+ ", enter the grade as a percent (0-100) for " +classList[classIndexList[i]]+ ": ");
                gradeList[i]=scan.nextDouble();//set the grade to the correct index
            }
            while(scan.nextDouble()<0||scan.nextDouble()>100);//error checking so it is between 0-100
        }
    }
    
    
    //generate report card
    public void reportCard(String n, String[] classList){
        System.out.println("Report Card for "+n);
        for (int j=0; j<4;j++){
            //print what block
            System.out.print("Block " +(j+1)+ ": ");
            //print name of class
            System.out.print(classList[classIndexList[j]]);
            //print out grade
            System.out.println(" Grade: "+gradeList[j]);
        }
        System.out.print("This student is ");
        if (attendance==true){
            System.out.println("present");
        }
        else{
            System.out.println("absent");
        }
        
    }
}


