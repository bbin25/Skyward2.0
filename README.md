  #Skyward2.0
//This will be a system that enters students names, schedules, grades, and whether they are absent or not
//THIS IS THE MAIN CLASS THAT SHOULD BE RUN

import java.util.Scanner;
public class term1projMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String[] classList = new String[]{"AP Computer Science A","Physics","Computer Science", "APCSP", "PLTW Cybersecurity", "Calculus"};
        
        //introduction
        System.out.println("Welcome to Skyward 2.0");
        System.out.println("This registration system assumes the user to be a teacher.");
        System.out.println("The user will enter the name of each student, schedule them for their classes,\n set their grades, and take attendance. The program will then display each student’s report card.");
        
        
        //Create 5 student objects
        Student[] listOfStudents = new Student[5]; 
        for (int i=0;i<5;i++){
            listOfStudents[i]= new Student();
        }
        
        System.out.println("");
        
        
        //give them all names
        System.out.println("Now you will name each student.");
        for (int i=0;i<2;i++){
            listOfStudents[i].createName(i+1);
        }
        
        System.out.println("");
        
        //instruction to schedule classes
        System.out.println("Now you will schedule their classes");
        System.out.println("The classes that are available are ");
        for (int i=0;i<6;i++){
            System.out.println(i+") "+classList[i]);
        }
        System.out.println("Please enter the index of the class for each block of each student: ");
        
        //schedule the classes
        System.out.println("\n");
        for (int i=0;i<2;i++){
            listOfStudents[i].schedule(listOfStudents[i].getName(), classList);;
        }
        
        System.out.println(""); //line breaks for clarity
        
        //set their grades
        System.out.println("Now you will set their grades");
        for (int i=0;i<2;i++){
            listOfStudents[i].setGrades(listOfStudents[i].getName(), classList);
        }
        
        System.out.println("");
        
        //take attendance
        System.out.println("Now you will take attendance");
        takeAttendance(listOfStudents); //run method below
        
        System.out.println("");
        
        //return their report card
        System.out.println("Outputting report cards");
        for (int i=0;i<2;i++){
            listOfStudents[i].reportCard(listOfStudents[i].getName(), classList);;
        }
    }
    
    
    
    
    
    //METHOD for taking attendance
    public static void takeAttendance(Student[] student){
        Scanner scan = new Scanner(System.in);
        //take attendance for all 5 students
        int x;
        for (int i=0;i<2;i++){
            do{
                System.out.println("Is "+ student[i].getName()+" here? Enter 1 for present, 2 for absent: ");
                x = scan.nextInt();
                if (x==1){
                    student[i].setAttendance(true);//set the boolean using a setter
                }
                else if (x==2){
                    student[i].setAttendance(false);
                }
            }
            while (!(x==1 || x==2));//Error checking - make sure the number is valid
        }
        
    }
    
    
    
}
