
import java.util.ArrayList;

public class reportgenerator {
    public static void report(ArrayList<student> students){
        if(students.size()==0){
            System.out.println("NO STUDENT RECORDS");
            return;
        }

        int totalstu=students.size();
        double totalGPA=0;
        student highest = students.get(0);
        student lowest= students.get(0);
        for (int i=0; i < students.size(); i++){
            student current = students.get(i);
            totalGPA= totalGPA + current.getGPA();
            if(current.getGPA()>highest.getGPA()){
                highest=current;
            }
            if(current.getGPA()<lowest.getGPA()){
                lowest=current;
            }
        }

        double averageGPA= totalGPA/totalstu;
        System.out.println(":::::::STUDENT REPORT:::::::");
        System.out.println("Total Student Number: "+totalstu);
        System.out.println("Average GPA: "+averageGPA);
        System.out.println("Highest GPA:");
        System.out.println(highest);
        System.out.println("Lowest GPA:");
        System.out.println(lowest);
    }
}