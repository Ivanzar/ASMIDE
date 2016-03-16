package Ivanzar.asmidea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.awt.AWTUtilities;

public class Frame implements ActionListener{
    
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    
    JDesktopPane desktop;
    
    BufferedImage logo;
    
    
    public Frame(){

        JFrame f =  new JFrame("AIDE - Assembler IDE 1.0.0");
        
        
        try {
            logo = ImageIO.read(new File("images\\logo2.png"));
            f.setIconImage(logo);
        } catch (Exception e) {
        }
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setJMenuBar(createMenu());
        f.setSize(new Dimension(400, 400));
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //f.setAlwaysOnTop(true);
        //f.pack();

        desktop = new JDesktopPane();
        f.setContentPane(desktop);
        desktop.setBackground(new Color(55, 244, 140));
        //desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        createCodeFrame();
        
        
        
    
    }
    
    JMenuBar createMenu(){
    
        menuBar =  new JMenuBar();
        menu = new JMenu("Setings");
        menu.getAccessibleContext().setAccessibleDescription("Setings");
        menuBar.add(menu);
        
        menuItem =  new JMenuItem("Add new progect");
        menuItem.getAccessibleContext().setAccessibleDescription("Add new progect");
        menuItem.setActionCommand("add");
        menuItem.addActionListener(this);
        menuItem.setToolTipText("Crt+N");
        menu.add(menuItem);
        
        menuItem =  new JMenuItem("Qite");
        menuItem.getAccessibleContext().setAccessibleDescription("Qite");
        menuItem.setActionCommand("qite");
        menuItem.addActionListener(this);
        menuItem.setToolTipText("Crt+Q");
        menu.add(menuItem);
        
        menu.getAccessibleContext().setAccessibleDescription("Setings");
        menuBar.add(menu);
    
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("add".equals(e.getActionCommand())){
            
            createCodeFrame();
            
        }
            else 
                if("qite".equals(e.getActionCommand())){
        
                    System.exit(0);
        
                }
    }
    
    void createCodeFrame(){
    
        CodeFrame frame = new CodeFrame();
        frame.setVisible(true);
        desktop.add(frame).setEnabled(false);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

}
