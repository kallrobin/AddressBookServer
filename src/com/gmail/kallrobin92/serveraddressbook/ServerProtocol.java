package com.gmail.kallrobin92.serveraddressbook;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Robin Gk on 2016-12-03 as a school project.
 * email kallrobin92@gmail.com
 */
public class ServerProtocol {


    public String processInput(String theInput, String filePath) {
        String theOutput = "";

        if (theInput.equals("getall")) {
            try (Scanner reader = new Scanner(new FileReader(filePath))) {
                while (true){
                    if (reader.hasNextLine()){
                        theOutput += reader.nextLine().replaceAll(",", " ") + "\n";
                    } else {
                        theOutput += "End of file";
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (theInput.equals("exit")) {
            theOutput = "Closing connection.";
        }
        return theOutput;
    }
}
