/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ivanzar.asmidea.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ivanzar
 */
public class WorkWithFile {
    
    public String read(File filename) throws IOException{
    
        BufferedReader in = new BufferedReader(new FileReader(filename));
                    
                    String text = "";
                     String inputLine;
                        while ((inputLine = in.readLine()) != null)
                                    text = text.concat(inputLine.concat("\n"));
                        in.close();
    
    return text;
    }
    
    public void write(File filename, String text) throws FileNotFoundException{
    
        PrintWriter out = new PrintWriter(filename);
        
        try{
            
            out.print(text);
            
        }finally{out.close();}
    
    }
    
}
