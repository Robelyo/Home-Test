
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        file.initialize();

        ArrayList<student> students = systemservice.loadobj();
        
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println(":::::::::STUDENT RECORD MANAGEMENT SYSTEM:::::::::");
            System.out.println("1.ADD STUDENT");
            System.out.println("2.SEARCH STUDENT");
            System.out.println("3.UPDATE STUDENT");
            System.out.println("4.DELETE STUDENT");
            System.out.println("5.DISPLAY ALL STUDENT");
            System.out.println("6.GENERATE REPORT");
            System.out.println("7.BACKUP");
            System.out.println("8.SHOW FILE INFORMATION");
            System.out.println("9.EXIT");

            System.out.println("ENTER YOUR CHOICE: ");
            if(!scan.hasNextInt()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        continue;
                    }
            int choice=scan.nextInt();

            switch(choice){
                case 1:
                    System.out.println(":::::::::ADD STUDENT:::::::::");
                    System.out.println("Enter id: ");
                    if(!scan.hasNextInt()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        break;
                    }
                    int id = scan.nextInt();
                    scan.nextLine();

                    if(systemservice.searchstudent(id, students)!=null){
                        System.out.println("ID IS TAKEN");
                        break;
                    }

                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    
                    System.out.println("Enter department: ");
                    String department = scan.nextLine();

                    System.out.println("Enter GPA: ");
                    if(!scan.hasNextDouble()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        break;
                    }
                    double GPA = scan.nextDouble();

                    if(GPA<0||GPA>4.0){
                        System.out.println("INVALID GPA MUST BE BETWEEN 0 AND 4");
                        break;
                    }

                    student student = new student(name, department, GPA, id);
                    students.add(student);

                    systemservice.savetext(students);
                    systemservice.savebin(students);
                    systemservice.saveobj(students);

                    System.out.println("STUDENT ADDED SUCCESSFULLY");
                    break;

                case 2:
                    System.out.println(":::::::::SEARCH STUDENT:::::::::");
                    System.out.println("Enter student id: ");
                    if(!scan.hasNextInt()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        break;
                    }
                    int ID =scan.nextInt();
                    student stud = systemservice.searchstudent(ID, students);

                    if(stud!=null){
                        System.out.println("STUDENT FOUND");
                        System.out.println(stud);
                    }
                    else{
                        System.out.println("STUDENT NOT FOUND");
                    }
                    break;

                case 3:
                    System.out.println(":::::::::UPDATE STUDENT:::::::::");
                    System.out.println("ENTER STUDENT ID: ");
                    if(!scan.hasNextInt()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        break;
                    }
                    int Identify = scan.nextInt();
                    scan.nextLine();
                    System.out.println("ENTER NEW NAME: ");
                    String NAME= scan.nextLine();
                    System.out.println("ENTER NEW DEPARTMENT: ");
                    String DEP= scan.nextLine();
                    System.out.println("ENTER NEW GPA: ");
                    if(!scan.hasNextDouble()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        break;
                    }
                    double gpa= scan.nextDouble();
                    if(gpa<0||gpa>4.0){
                        System.out.println("INVALID GPA MUST BE BETWEEN 0 AND 4");
                        break;
                    }
                    boolean updated= systemservice.update(NAME, DEP, gpa, Identify, students);
                    if (updated){
                        systemservice.savetext(students);
                        systemservice.savebin(students);
                        systemservice.saveobj(students);

                        System.out.println("STUDENT INFO UPDATED");

                    }
                    else{
                        System.out.println("STUDENT NOT FOUND");
                    }
                    break;

                case 4:
                    System.out.println(":::::::::DELETE STUDENT:::::::::");
                    System.out.println("ENTER STUDENT ID: ");
                    if(!scan.hasNextInt()){
                        System.out.println("INVALID INPUT ENTER A NUMBER");
                        scan.next();
                        break;
                    }
                    int identify = scan.nextInt();
                    boolean deleted= systemservice.delete(identify, students);
                    if(deleted){
                        systemservice.savetext(students);
                        systemservice.savebin(students);
                        systemservice.saveobj(students);

                        System.out.println("STUDENT DELETED");
                    }
                    else{
                        System.out.println("STUDENT NOT FOUND");
                    }
                    break;

                case 5:
                    System.out.println(":::::::::STUDENT DISPLAY:::::::::");
                    if(students.size()==0){
                        System.out.println("NO STUDENTS AVAILABLE");
                    }
                    else{
                        System.out.println(":::::::::STUDENT LIST:::::::::");
                        for (int i=0; i < students.size(); i++){
                            System.out.println(students.get(i));
                        }
                    }
                    break;

                case 6:
                    System.out.println(":::::::::REPORT GENERATOR:::::::::");
                    reportgenerator.report(students);
                    break;

                case 7:
                    System.out.println(":::::::::BACKUP:::::::::");
                    backuprecord.backup();
                    break;

                case 8:
                    System.out.println(":::::::::FILE INFORMATION:::::::::");
                    file.showfileinfo(file.Objectfile);
                    break;

                case 9:
                    systemservice.savetext(students);
                    systemservice.savebin(students);
                    systemservice.saveobj(students);
                    System.out.println(":::::::::PROGRAM ENDED:::::::::");
                    scan.close();
                    return;

                default:
                    System.out.println("INVALID CHOICE");
                    break;
                
            }
        }
    }
}
