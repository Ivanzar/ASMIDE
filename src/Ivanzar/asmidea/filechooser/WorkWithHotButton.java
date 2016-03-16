/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ivanzar.asmidea.filechooser;

import Ivanzar.asmidea.Panel;
import Ivanzar.asmidea.files.WorkWithFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

/**
 *
 * @author ivanzar
 */
public class WorkWithHotButton {

    RSyntaxTextArea textarea; JPanel p;
    
    public void openb(JFileChooser fc, RSyntaxTextArea textarea, JPanel p){
    
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int returnVal = fc.showOpenDialog(p);
            
            if(returnVal == JFileChooser.APPROVE_OPTION){
                
                File file = fc.getSelectedFile();
            
                try {
                        textarea.setText(new WorkWithFile().read(file.getAbsoluteFile()));
                    
                       System.err.println(textarea.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
            this.textarea = textarea;
            this.p = p;
            
    
    }
    
    public void saveb(JFileChooser fc, RSyntaxTextArea textarea, JPanel p){
    
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int returnVal = fc.showSaveDialog(p);
            
            if(returnVal == JFileChooser.APPROVE_OPTION){
                
                File file = fc.getSelectedFile();
                try {
                    new WorkWithFile().write(file, textarea.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
            this.textarea = textarea;
            this.p = p;           
    
    }
    
    @SuppressWarnings("empty-statement")
    public void compilb(JFileChooser fc) throws IOException{
    
        saveb(fc, textarea, p);
        
        File file = fc.getSelectedFile();
            
            String sfile = String.valueOf(file);
            
            ProcessBuilder pb = new ProcessBuilder("./fasm",sfile);

            Process p = pb.start();
            
             BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
             String line = null;
             while ((line = reader.readLine()) != null)
             {
                System.out.println(line);
                
             }
             
             
    
    }
    
    public void startinunix(JFileChooser fc){
           
        File file = fc.getCurrentDirectory();
                      
            String sdirictory = String.valueOf(file.getAbsoluteFile());
            String sfile = String.valueOf(fc.getSelectedFile().getName());
            sfile = sfile.replaceAll(".asm", ".com");
            sfile = sdirictory.concat("/".concat(sfile));
            
            ProcessBuilder start = new ProcessBuilder("dosbox",sfile);
            System.out.println(sfile);
            
            try {
                compilb(fc);
                Process p = start.start();
            } catch (IOException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}
