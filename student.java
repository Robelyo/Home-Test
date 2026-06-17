
import java.io.Serializable;

public class student implements Serializable {
    private String name;
    private String department;
    private double  GPA;
    private int studentid;

    public student(String name,String department,double GPA,int studentid) {
        this.name=name;
        this.department=department;
        this.GPA=GPA;
        this.studentid=studentid;
    }

    public int getstudentid(){
        return studentid;
    }

    public String getname(){
        return name;
    }

    public String getdepartment(){
        return department;
    }

    public double getGPA(){
        return GPA;
    }

    public void setname(String name){
        this.name=name;
    }

    public void setdepartment(String department){
        this.department=department;
    }

    public void setGPA(double GPA){
        this.GPA=GPA;
    }

    @Override
    public String toString(){
        return "NAME: "+name+", DEPARTMENT: "+department+", GPA: "+GPA+", ID: "+studentid;
    }

    
}
