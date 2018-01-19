package skymind.dsx;

/**
 * Created by tomhanlon on 1/18/18.
 */
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class DirectoryContents {

    public static void main(String[] args) throws IOException {




        File f = new File("KerasModels"); // current directory

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".h5")) {
                    return true;
                } else {
                    return false;
                }
            }
        };


        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            System.out.println(file.getCanonicalPath());
        }

        System.out.println(files.length);

        //String path = new String("KerasModels");

        /*
        File dir = new File(path);
        String[] fileslist = dir.list();
        //System.out.print(Arrays.toString(fileslist));
        for (String strTemp : fileslist){
            System.out.println(path + "/" + strTemp);


}
*/


    }



}