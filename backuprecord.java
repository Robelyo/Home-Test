
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class backuprecord {
    public static void backup(){
        try {
            FileInputStream FIS = new FileInputStream(file.Objectfile);
            BufferedInputStream BIS = new BufferedInputStream(FIS);
            FileOutputStream FOS = new FileOutputStream("database/backup.obj");
            BufferedOutputStream BOS = new BufferedOutputStream(FOS);

            int data;

            while(true){
                data=BIS.read();

                if (data==-1){
                    break;
                }

                BOS.write(data);
            }

            BOS.close();
            BIS.close();
            
            System.out.println("BACKUP CREATED");

        } catch (Exception e) {
            System.out.println("BACKUP ERROR");
        }
    }
}
