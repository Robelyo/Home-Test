
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class systemservice {
    public static void Addstudent(student s){
        try {
            FileWriter fw = new FileWriter(file.Textfile,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(s.getname()+" : "+s.getdepartment()+" : "+s.getGPA()+" : "+s.getstudentid());
            pw.close();
        } catch (Exception e) {
            System.out.println("SYSTEM SERVICE ERROR");
        }
    }

    public static ArrayList<student> loadtext(){
        ArrayList<student> students = new ArrayList<>();
        try {
            File F = new File(file.Textfile);
            Scanner scan=new Scanner(F);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] data= line.split(" : ");
                if (data.length==4){
                    String name = data[0];
                    String department = data[1];
                    double GPA = Double.parseDouble(data[2]);
                    int studentid = Integer.parseInt(data[3]);
                    student s = new student(name, department, GPA, studentid);
                    students.add(s);
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("ERROR LOADING STUDENTS");
        }
        return students;
    } 

    public static student searchstudent(int id, ArrayList<student> students){
        for(int i=0; i < students.size(); i++){
            student s = students.get(i);
            if (s.getstudentid()==id){
                return s;
            }
        }
        return null;
    }

    public static boolean update(String Newname, String Newdepartment, double NewGPA, int ID, ArrayList<student> students){
        student s = searchstudent(ID, students);
        if (s!=null){
            s.setname(Newname);
            s.setdepartment(Newdepartment);
            s.setGPA(NewGPA);
            return true;
        }
        return false;
    }

    public static boolean delete(int id, ArrayList<student> students){
        for (int i=0; i < students.size(); i++){
            if (students.get(i).getstudentid()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public static void savetext(ArrayList<student> students){
        try {
            PrintWriter pw = new PrintWriter(file.Textfile);
            for (int i=0; i < students.size(); i++){
                student s = students.get(i);
                pw.println(s.getname()+","+s.getdepartment()+","+s.getGPA()+","+s.getstudentid());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("ERROR SAVING TEXT");
        }
    }

    public static void savebin(ArrayList<student> students){
        try {
            DataOutputStream DSoutput = new DataOutputStream(new FileOutputStream(file.Binaryfile));
            DSoutput.writeInt(students.size());
            for (int i=0; i < students.size(); i++){
                student s = students.get(i);
                DSoutput.writeUTF(s.getname());
                DSoutput.writeUTF(s.getdepartment());
                DSoutput.writeDouble(s.getGPA());
                DSoutput.writeInt(s.getstudentid());
            }
            DSoutput.close();
        } catch (Exception e) {
            System.out.println("ERROR SAVING BINARY");
        }
    }

    public static ArrayList<student> loadbin(){
        ArrayList<student> students = new ArrayList<>();
        try {
            DataInputStream DSinput= new DataInputStream(new FileInputStream(file.Binaryfile));
            int count=DSinput.readInt();
            for (int i=0; i < count; i++){
                String name=DSinput.readUTF();
                String department=DSinput.readUTF();
                double GPA=DSinput.readDouble();
                int Id=DSinput.readInt();
                student s = new student(name, department, GPA, Id);
                students.add(s);
            }
            DSinput.close();
        } catch (Exception e) {
            System.out.println("ERROR LOADING BINARY");
        }
        return students;
    }

    public static void saveobj(ArrayList<student> students){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(file.Objectfile));
            OOS.writeObject(students);
            OOS.close();
        } catch (Exception e) {
            System.out.println("ERROR SAVING OBJECT");
        }
    }
    
    public static ArrayList<student> loadobj(){
        ArrayList<student> students = new ArrayList<>();
        try {
            File f =new File(file.Objectfile);
            if(f.length()==0){
                return students;
            }
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file.Objectfile));
            students = (ArrayList<student>) OIS.readObject();
            OIS.close();
        } catch (Exception e) {
            System.out.println("ERROR LOADING OBJECT");
        }
        return students;
    }
}
