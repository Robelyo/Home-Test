
import java.io.File;
import java.util.Date;

public class file {
    public static final String Data_folder="database";
    public static final String Textfile=Data_folder+"/student.txt";
    public static final String Binaryfile=Data_folder+"/student.bin";
    public static final String Objectfile=Data_folder+"/student.obj";
    public static void initialize(){
        try {
            File Dir=new File(Data_folder);
            if(!Dir.exists()){
                Dir.mkdir();
            }
            new File(Textfile).createNewFile();
            new File(Binaryfile).createNewFile();
            new File(Objectfile).createNewFile();
        } catch (Exception e) {
            System.out.println("ERROR CREATING FILES");
        }
    }

    public static void showfileinfo(String filepath){
        File files=new File(filepath);
        System.out.println("Name: "+files.getName());
        System.out.println("Path: "+files.getAbsolutePath());
        System.out.println("Size: "+files.length()+" bytes");
        System.out.println("Last modified: "+new Date(files.lastModified()));
    }
}
