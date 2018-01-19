package tomthetrainer.kerasImports;

/**
 * Created by tomhanlon on 12/29/17.
 */
import org.apache.log4j.BasicConfigurator;
import org.bytedeco.javacpp.presets.opencv_core;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import scala.tools.cmd.gen.AnyVals;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class Keras2ModelImport {
    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();

        // UnComment and Run this Block on particular H5
        // To see error

/*
        String kerasModelfromKerasExport = "KerasModels/pollution_theano.h5";
        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(kerasModelfromKerasExport,false);
        System.out.println("Model Configuration");
        String modelconfig = model.conf().toJson();
        System.out.println(modelconfig);


*/


        // Step through all *.h5 files in
        // Directory KerasModels
        // Load them into a MultiLayerNetwork
        // If success, add to successes Array
        // If Failure add to failures Array



        File f = new File("KerasModels");


        // Filter for .h5 suffix

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


        // ArrayList for Successes and Failures

        ArrayList<String> Successes = new ArrayList<String>();
        ArrayList<String> Failures = new ArrayList<String>();

        File[] files = f.listFiles(textFilter);





        for (File fileTemp : files){
            String filename = fileTemp.getPath();

            try {
                //System.out.println("********" + filename + "*********");
                MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(filename,false);
                //System.out.println("Model Configuration");
                String modelconfig = model.conf().toJson();
                //System.out.println(modelconfig);
                Successes.add(filename);
            }
            catch(Exception e) {
                Failures.add(filename);
            }
        }


        System.out.println("\n######### SUCCESSES ##########");
            System.out.println(Successes);

        System.out.println("\n\n######### Failures ##########");
        System.out.println(Failures);

        // A better way to do this would be
        // to loop through enforce training config true/false
        // See here.
        //myMethod(false);
        //myMethod(true);

    }
    //public static void myMethod(boolean input) {
    //    System.out.println("IN BOOLEAN");
    //    System.out.println(input);
    //    }

}
